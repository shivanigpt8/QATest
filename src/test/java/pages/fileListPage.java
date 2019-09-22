package pages;

import helpers.configFileReader;
import managers.pageObjectManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class fileListPage extends basePage{

    private pageObjectManager pgObjMnger;

    @FindBy(id = "rcDialogTitle0")
    private WebElement labelBulkUpload;

    @FindBy(xpath = "//strong[text()=\"File List\"]/../../button")
    private WebElement btnUpload;

    @FindBy(xpath = "//p[@class=\"ant-upload-drag-icon\"]")
    private WebElement uploadFileIcon;

    @FindBy(xpath = "//div[@class=\"ant-modal-footer\"]/button[2]")
    private WebElement btnUploadOnPopUp;

    @FindBy(xpath = "//i[@class=\"anticon anticon-down ant-select-arrow-icon\"]")
    private WebElement dropDownIcon;

    private By msgOnFileUpload = By.xpath("//div[@class=\"ant-message-notice-content\"]");

    public fileListPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getFileUploadMessage(){
        wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(msgOnFileUpload));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(msgOnFileUpload));
        return driver.findElement(msgOnFileUpload).getText();
    }

    public WebElement getlabelBulkUpload(){
        return labelBulkUpload;
    }

    public void uploadFile(String fileName, String action)
    {
        enterNameInFileUploadForm(fileName);

        //Select the action of the file
        dropDownIcon.click();
        driver.findElement(By.xpath("//ul[@role=\"listbox\"]/li[text()=\"" + action +  "\"]")).click();

        //Upload file
        btnUploadOnPopUp.click();
    }

    private void typeFileName(String name) {
        configFileReader reader = new configFileReader("config.properties");
        String filesPath = reader.getPropertyFromFile("filesPath");

        String fileName = System.getProperty("user.dir") + filesPath + name;
        StringSelection ss = new StringSelection(fileName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Exception occured while typing file name in upload dialog");
        }
    }

    public void enterNameInFileUploadForm(String fileName){
        btnUpload.click();
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(uploadFileIcon));
        uploadFileIcon.click();
        try {
            Thread.sleep(5000);
            typeFileName(fileName);
            Thread.sleep(5000);
        }
        catch (Throwable th)
        {
            th.printStackTrace();
        }

    }

}
