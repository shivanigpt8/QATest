package managers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import pages.fileListPage;
import pages.homePage;
import pages.loginPage;
import pages.rewardsPage;

public class pageObjectManager {

    private WebDriver driver;
    private homePage homePg;
    private loginPage loginPg;
    private rewardsPage rewardsPg;
    private fileListPage fileListPg;

    public pageObjectManager(WebDriver driver)
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

    public rewardsPage getRewardsPage()
    {
        return rewardsPg == null ? rewardsPg = new rewardsPage(driver) : rewardsPg;
    }

    public fileListPage getFileListPage()
    {
        return fileListPg == null ? fileListPg = new fileListPage(driver) : fileListPg;
    }
}
