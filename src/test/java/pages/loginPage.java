package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends basePage{

    @AndroidFindBy(id = "com.todoist:id/btn_welcome_continue_with_email")
    private WebElement btnContinueWithEmail;

    @AndroidFindBy(id = "com.todoist:id/email_exists_input")
    private WebElement txtFieldEmail;

    @AndroidFindBy(id = "com.todoist:id/btn_continue_with_email")
    private WebElement btnContinue;

    @AndroidFindBy(id = "com.todoist:id/log_in_password")
    private WebElement txtFieldPassword;

    @AndroidFindBy(id = "com.todoist:id/btn_log_in")
    private WebElement btnLogin;

    public loginPage(AndroidDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public void login(String email, String password)
    {
        btnContinueWithEmail.click();
        txtFieldEmail.sendKeys(email);
        btnContinue.click();
        txtFieldPassword.sendKeys(password);
        btnLogin.click();
    }

}
