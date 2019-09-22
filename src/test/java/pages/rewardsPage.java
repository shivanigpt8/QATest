package pages;

import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class rewardsPage extends basePage{

    @FindBy(xpath = "//strong[text()=\"Rewards\"]")
    private WebElement labelRewards;

    @FindBy(xpath = "//strong[text()=\"Rewards\"]/..//button")
    private WebElement btnCreateNew;

    @FindBy(xpath = "//span[text()=\"Next\"]/parent::button")
    private WebElement btnNext;

    @FindBy(xpath = "//input[@class=\"ant-calendar-input \"]")
    private WebElement txtEndDate;

    @FindBy(xpath = "//section[text()=\"End Date\"]/..//i[1]")
    private WebElement calenderIconEndDate;

    @FindBy(xpath = "//input[@class=\"ant-calendar-input \"]")
    private WebElement txtStartDate;

    @FindBy(xpath = " //section[text()=\"Start Date\"]/..//i[1]")
    private WebElement calenderIconStartDate;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btnLaunchReward;

    @FindBy(xpath = "//input[@name=\"name_en\"]")
    private WebElement txtFieldName;

    @FindBy(xpath = " //label[text()=\"Brands\"]")
    private WebElement labelBrands;

    @FindBy(xpath = "//div[text()=\"Please select your brands\"]")
    private WebElement txtBrands;

    @FindBy(xpath = " //label[text()=\"Tags\"]")
    private WebElement labelTags;

    @FindBy(xpath = "//div[text()=\"Please select your tags\"]")
    private WebElement txtTags;

    @FindBy(xpath = " //label[text()=\"Categories\"]")
    private WebElement labelCategories;

    @FindBy(xpath = "//div[text()=\"Please select your categories\"]")
    private WebElement txtCategories;

    @FindBy(xpath = " //label[text()=\"Labels\"]")
    private WebElement labelLabels;

    @FindBy(xpath = "//div[text()=\"Please select your labels\"]")
    private WebElement txtLabels;

    @FindBy(xpath = " //label[text()=\"Catalogues\"]")
    private WebElement labelCatalogues;

    @FindBy(xpath = "//div[text()=\"Please select your catalogues\"]")
    private WebElement txtCatalogues;

    private By msgOnCreatingReward = By.xpath("//div[@class=\"ant-message-notice-content\"]");

    public rewardsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterRewardName(String name){
        txtFieldName.sendKeys(name);
    }

    public void clickOnCreateNewBtn()
    {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnCreateNew));
        btnCreateNew.click();
    }

    public void submitRewardWithoutEndDate(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnNext));
        btnNext.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("strong"),"Reward Mechanics"));
        wait.until(ExpectedConditions.elementToBeClickable(btnNext));
        btnNext.click();
    }

    public void fillEndDate() throws Throwable{
        String date = getNextDate();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calenderIconEndDate);
        txtEndDate.sendKeys(date);
        txtEndDate.sendKeys(Keys.RETURN);
        Thread.sleep(500);
    }

    public void fillStartDate() throws Throwable{
        String date = getCurrentDate();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calenderIconStartDate);
        txtStartDate.sendKeys(date);
        txtStartDate.sendKeys(Keys.RETURN);
        Thread.sleep(500);
    }

    private String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String getNextDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return dateFormat.format(calendar.getTime());
    }

    public void removeStartDate(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calenderIconStartDate);
    }

    public void clickNextButton(){
        btnNext.click();
    }

    public String launchReward(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnLaunchReward));
        btnLaunchReward.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(msgOnCreatingReward));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(msgOnCreatingReward));
        return driver.findElement(msgOnCreatingReward).getText();
    }

    public void selectRewardType(String rewardType){
        driver.findElement(By.xpath("//span[text()=\"" + rewardType + "\"]/..//input[@name=\"reward_publicity_type\"]")).click();
    }

    public boolean isFieldDisplayed(String text){
        String fieldName = text.toLowerCase();
        try{
            driver.findElement(By.xpath("//div[text()=\"Please select your " + fieldName + "\"]")).isDisplayed();
            return true;
        }
        catch(NoSuchElementException ex){
            return false;
        }
    }

    public boolean isLabelDisplayed(String text){
        try{
            driver.findElement(By.xpath("//label[text()=\"" + text + "\"]")).isDisplayed();
            return true;
        }
        catch(NoSuchElementException ex){
            return false;
        }
    }

}
