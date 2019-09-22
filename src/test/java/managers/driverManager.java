package managers;

import helpers.configFileReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class driverManager {

        private WebDriver webDriver;
        private AndroidDriver driver;

        public WebDriver getWebDriver(){
            if(webDriver == null) {
                webDriver = createWebDriver();
            }
            return webDriver;
        }

        private WebDriver createWebDriver()
        {
            configFileReader reader = new configFileReader("config.properties");
            String browser = reader.getPropertyFromFile("browser");

            if(browser.equalsIgnoreCase("chrome")){
                String driverPath = reader.getPropertyFromFile("driversPath");
                driverPath = System.getProperty("user.dir") + driverPath + "chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", driverPath);
                webDriver = new ChromeDriver();
                return webDriver;
            }
            else if(browser.equalsIgnoreCase("firefox")){
                String driverPath = reader.getPropertyFromFile("driversPath");
                driverPath = System.getProperty("user.dir") + driverPath + "geckodriver.exe";
                System.setProperty("webdriver.firefox.marionette", driverPath);
                WebDriver driver = new FirefoxDriver();
                return webDriver;
            }
            return null;
        }

        private AndroidDriver createDriver()
        {
            DesiredCapabilities caps = new DesiredCapabilities();
            configFileReader reader = new configFileReader("config.properties");
            caps.setCapability("deviceName",reader.getPropertyFromFile("deviceName"));
            caps.setCapability("udid", reader.getPropertyFromFile("deviceID")); //Give Device ID of your mobile phone
            caps.setCapability("platformName", reader.getPropertyFromFile("platformName"));
            caps.setCapability("platformVersion", reader.getPropertyFromFile("platformVersion"));
            caps.setCapability("appPackage", reader.getPropertyFromFile("appPackage"));
            caps.setCapability("appActivity", reader.getPropertyFromFile("appActivity"));
            caps.setCapability("noReset", "true");

            try {
                driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
                return driver;

            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
   }
