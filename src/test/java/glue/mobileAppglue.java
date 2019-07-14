package glue;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import managers.driverManager;
import managers.pageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.homePage;
import pages.loginPage;
import pages.projectPage;

import java.util.List;
import java.util.Map;

public class mobileAppglue {

    private driverManager driverMngr;
    private pageObjectManager pgObjMnger;
    private AndroidDriver driver;

    @When("^Open mobile application$")
    public void openMobileApp()
    {
        driverManager driverMngr = new driverManager();
        driver = driverMngr.getDriver();
    }

    @When("^login into mobile application$")
    public void login(DataTable dataTable)
    {
        List<Map<String,String>> credentials = dataTable.asMaps(String.class,String.class);
        String email = credentials.get(0).get("Email");
        String password = credentials.get(0).get("Password");
        pgObjMnger = new pageObjectManager(driver);
        loginPage loginPg = pgObjMnger.getloginPage();
        loginPg.login(email,password);
    }

    @Then("^verify on mobile that project \"(.*)\" is created$")
    public void verify_project_created(String projectName)
    {
        pgObjMnger = new pageObjectManager(driver);
        homePage homePg = pgObjMnger.gethomePage();
        WebElement prj = homePg.getProject(projectName);
        if(prj != null)
        {
            System.out.println("Project:" + prj.getText() + " found");
        }
        else {
            System.out.println("Project:" + projectName + " not found");
            Assert.fail("Project:" + projectName + " not found");
        }
    }

    @And("^Open test project \"(.*)\"$")
    public void openTestProject(String projectName)
    {
        pgObjMnger = new pageObjectManager(driver);
        homePage homePg = pgObjMnger.gethomePage();
        WebElement prj = homePg.getProject(projectName);
        prj.click();
    }

    @When("^Open test task \"(.*)\"$")
    public void openTask(String taskName)
    {
        pgObjMnger = new pageObjectManager(driver);
        projectPage projectPg = pgObjMnger.getProjectPage();
        projectPg.selectTask(taskName);
    }

    @And("^Complete test task$")
    public void completeTask()
    {
        pgObjMnger = new pageObjectManager(driver);
        projectPage projectPg = pgObjMnger.getProjectPage();
        try {
            projectPg.completeOpenedTask();
            //forcefully wait for task to be closed before running the rest API to reopen it
            Thread.sleep(5000);
            System.out.println("Opened task completed successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Unable to complete the opened task");
        }
    }

    @Then("^Verify that test task \"(.*)\" appears in test project \"(.*)\"$")
    public void verify_task_in_project(String taskName, String projectName)
    {
        pgObjMnger = new pageObjectManager(driver);
        projectPage projectPg = pgObjMnger.getProjectPage();
        projectPg.selectTask(taskName);
    }

    @When("^Create test task \"(.*)\" via mobile application in test project \"(.*)\"$")
    public void createTaskInProject(String taskName, String projectName)
    {
        pgObjMnger = new pageObjectManager(driver);
        homePage homePg = pgObjMnger.gethomePage();
        WebElement prj = homePg.getProject(projectName);
        prj.click();
        projectPage projectPg = pgObjMnger.getProjectPage();
        projectPg.createTask(taskName);
    }
}
