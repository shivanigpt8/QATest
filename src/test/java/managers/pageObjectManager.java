package managers;

import io.appium.java_client.android.AndroidDriver;
import pages.homePage;
import pages.loginPage;
import pages.projectPage;

public class pageObjectManager {

    private AndroidDriver driver;
    private homePage homePg;
    private loginPage loginPg;
    private projectPage projectPg;

    public pageObjectManager(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public homePage gethomePage()
    {
        return (homePg == null) ? homePg = new homePage(driver) : homePg;
    }

    public loginPage getloginPage()
    {
        return loginPg == null ? loginPg = new loginPage(driver) : loginPg;
    }

    public projectPage getProjectPage()
    {
        return projectPg == null ? projectPg = new projectPage(driver) : projectPg;
    }
}
