package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class basePage {
    AndroidDriver driver;

    public basePage(AndroidDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
