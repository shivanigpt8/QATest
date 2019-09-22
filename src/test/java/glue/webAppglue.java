package glue;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.configFileReader;

import managers.driverManager;
import managers.pageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.fileListPage;
import pages.homePage;
import pages.loginPage;
import pages.rewardsPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

public class webAppglue {

    private driverManager driverMngr;
    private pageObjectManager pgObjMnger;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private rewardsPage rewardsPg;
    private homePage homePg;
    private loginPage loginPg;
    private fileListPage listPage;

    @After
    public void after_scenario() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Given("^Perx dashboard URL is launched$")
    public void launch_web_app()
    {
        driverManager driverMngr = new driverManager();
        webDriver = driverMngr.getWebDriver();
        configFileReader reader = new configFileReader("config.properties");
        String URL = reader.getPropertyFromFile("URL");
        webDriver.get(URL);
    }

    @When("user logs in dashboard with \"([^\"]*)\" and \"([^\"]*)\"")
    public void login(String username, String password)
    {
        loginPg = getPgObjMnger().getloginPage();
        loginPg.login(username,password);
    }

    @Given("^user access the URL \"([^\"]*)\" directly$")
    public void open_URL(String URL) throws Exception {
        driverManager driverMngr = new driverManager();
        webDriver = driverMngr.getWebDriver();
        webDriver.get(URL);
        wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("email")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("password")));
    }

    @Then("^user should be on login page$")
    public void verify_user_is_on_login_page() {
        wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("email")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("password")));
    }

    @When("^user upload txt,csv or xlsx file and tie it to an action then file should get uploaded and the file list should reflect the uploaded file$")
    public void verify_file_is_uploaded(DataTable data) throws Throwable
    {
        homePg = getPgObjMnger().gethomePage();
        homePg.goToPage("File List");
        listPage= getPgObjMnger().getFileListPage();
        List<Map<String, String>> list = data.asMaps(String.class, String.class);
        for(int i=0; i<list.size(); i++) {
            String fileName = list.get(i).get("FileName");
            String action = list.get(i).get("Action");
            listPage.uploadFile(fileName,action);
            String message = listPage.getFileUploadMessage();
            Assert.assertEquals("File uploaded message is not displayed","File uploaded",message);

            //Verify that uploaded file is displayed in the file list page
            String fileNameOfFirstEntryInFileListPage = webDriver.findElement(By.xpath("//tbody[@class=\"ant-table-tbody\"]/tr[1]/td[2]")).getText();
            String fileNameWithoutExt = fileNameOfFirstEntryInFileListPage.substring(0,fileNameOfFirstEntryInFileListPage.indexOf("."));
            Assert.assertEquals("File is not displayed in the file list page",fileName,fileNameWithoutExt);
            System.out.println("File uploaded is displayed in first rows in the file list page");
        }
    }

    @When("^user upload tries to upload doc file then this unsupported file should not be shown in File Upload form$")
    public void verify_file_is_not_uploaded(DataTable data) throws Throwable {
        homePg = getPgObjMnger().gethomePage();
        homePg.goToPage("File List");
        listPage = getPgObjMnger().getFileListPage();
        List<Map<String, String>> list = data.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            String fileName = list.get(i).get("FileName");
            listPage.enterNameInFileUploadForm(fileName);
            try {
                Robot robot = new Robot();

                //hit enter to close the "File not found" system pop
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                Thread.sleep(500);
                //hit Esc to close the file upload form
                robot.keyPress(KeyEvent.VK_ESCAPE);
                robot.keyRelease(KeyEvent.VK_ESCAPE);
                Thread.sleep(500);
            } catch (AWTException ex) {
                ex.printStackTrace();
            } finally {
                System.out.println("Exception occured while closing the file upload form or window popup");
            }

            //to verify that user is on bulk upload page after closing the file upload form
            Assert.assertTrue("User is not on Bulk Upload Page",listPage.getlabelBulkUpload().isDisplayed());
        }
    }

    @Then("^user should be on the page with title \"([^\"]*)\"$")
    public void validate_user_on_page(String pageName){
        wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("strong")));
        String  pageTtitle = webDriver.findElement(By.tagName("strong")).getText();
        Assert.assertEquals("User is not on " + pageName + " page.",pageName,pageTtitle);
    }

    @When("^user click on Create New button on rewards page$")
    public void click_createBtn_on_rewardsPage(){
        rewardsPg = getPgObjMnger().getRewardsPage();
        rewardsPg.clickOnCreateNewBtn();
    }

    @When("^user submits reward form without end date$")
    public void verify_error_on_submit_reward(){
        rewardsPg = getPgObjMnger().getRewardsPage();
        rewardsPg.submitRewardWithoutEndDate();
    }

    @When("^\"([^\"]*)\" error is displayed on reward page$")
    public void verify_error_on_reward_page(String errorMsg) {
        wait = new WebDriverWait(webDriver, 20);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()=\"" + errorMsg + "\"]")));

        Assert.assertEquals("",errorMsg,webDriver.findElement(By.xpath("//label[text()=\"" + errorMsg + "\"]")).getText());
    }

    @When("^user fills \"([^\"]*)\"$")
    public void fill_date(String str) throws Throwable{
        rewardsPg = getPgObjMnger().getRewardsPage();
        if(str.equalsIgnoreCase("start date")){
            rewardsPg.fillStartDate();
        }
        else if(str.equalsIgnoreCase("end date")){
            rewardsPg.fillEndDate();
        }
    }

    @When("^remove the start date$")
    public void remove_start_date() throws Throwable {
        rewardsPg = getPgObjMnger().getRewardsPage();
        rewardsPg.removeStartDate();
    }

    @And("^click Next button on rewards page$")
        public void click_next_btn() throws Throwable{
            rewardsPg = getPgObjMnger().getRewardsPage();
            rewardsPg.clickNextButton();
        }

        @When("^user launch the reward$")
        public void launch_reward(){
            rewardsPg = getPgObjMnger().getRewardsPage();
            Assert.assertEquals("Reward is not created","Creating reward...",rewardsPg.launchReward());
        }

        @When("^user enters reward name \"([^\"]*)\" on the reward info page$")
        public void enter_reward_name(String name){
            rewardsPg = getPgObjMnger().getRewardsPage();
            rewardsPg.enterRewardName(name);
        }

        @Then("^reward \"([^\"]*)\" should be displayed in the rewards list$")
        public void verify_reward_in_list(String name){
            wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")));
            String text = webDriver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
            Assert.assertTrue("Reward " + name + " is not found in rewards list",text.contains(name));
        }

    @When("^user selects reward type as \"([^\"]*)\"$")
    public void select_reward(String rewardType) {
        rewardsPg = getPgObjMnger().getRewardsPage();
        rewardsPg.selectRewardType(rewardType);
    }

    @Then("^\"([^\"]*)\" label and input field should disappear$")
    public void verify_label_and_field_not_displayed(String label) throws Throwable{
        rewardsPg = getPgObjMnger().getRewardsPage();
        rewardsPg.isLabelDisplayed(label);
        Assert.assertFalse("Label " + label + " is displayed",rewardsPg.isLabelDisplayed(label));
        rewardsPg.isFieldDisplayed(label);
        Assert.assertFalse("Field " + label + " is displayed",rewardsPg.isFieldDisplayed(label));
    }

    @When("^user navigates to \"([^\"]*)\" page$")
    public void navigate_to_page(String pageName) throws Throwable{
        homePg = getPgObjMnger().gethomePage();
        homePg.goToPage(pageName);
    }

    private pageObjectManager getPgObjMnger(){
        return new pageObjectManager(webDriver);
    }
}
