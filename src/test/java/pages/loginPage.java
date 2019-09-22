package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends basePage{

    @FindBy(id = "email")
    private WebElement txtFieldEmail;

    @FindBy(id = "password")
    private WebElement txtFieldPassword;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btnLogin;

    public loginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    public void login(String email, String password)
    {
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(txtFieldEmail));
        txtFieldEmail.sendKeys(email);
        txtFieldPassword.sendKeys(password);
        btnLogin.click();
    }

}
