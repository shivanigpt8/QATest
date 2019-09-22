package pages;

import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage extends basePage{

    @FindBy(xpath = "//i[@src=\"rewards\"]")
    private WebElement rewardsIcon;

    @FindBy(xpath = "//i[@src=\"customers\"]")
    private WebElement customerIcon;

    @FindBy(xpath = "//a[@href=\"/dashboard/p/rewards\"]")
    private WebElement rewardsSubMenu;

    @FindBy(xpath = "//a[@href=\"/dashboard/p/bulkaction\"]")
    private WebElement bulkActionSubMenu;

    @FindBy(xpath = "//strong[text()=\"File List\"]")
    private WebElement fileListTitle;

    public homePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToPage(String pageName) throws Throwable
    {
        if(pageName.equalsIgnoreCase("rewards")){
            rewardsIcon.click();
            wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(rewardsSubMenu));
            rewardsSubMenu.click();
        }
        else if(pageName.equalsIgnoreCase("File List")){
            Thread.sleep(2000);
            Actions action = new Actions(driver);
            WebElement we = driver.findElement(By.xpath("//li[@data-key=\"customer_management\"]//i[@src=\"customers\"]"));
            action.moveToElement(we).build().perform();
            wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(bulkActionSubMenu));
            bulkActionSubMenu.click();
            wait.until(ExpectedConditions.visibilityOf(fileListTitle));
        }
        else{
            Assert.fail("Page " + pageName + " is not available");
        }
    }
}
