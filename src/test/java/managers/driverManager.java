package managers;

import helpers.configFileReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class driverManager {

        private AndroidDriver driver;

        public AndroidDriver getDriver() {
            if(driver == null) driver = createDriver();
            return driver;
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
