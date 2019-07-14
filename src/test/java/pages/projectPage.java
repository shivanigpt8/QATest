package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class projectPage extends basePage {

    @AndroidFindBy(id = "com.todoist:id/fab")
    private WebElement btnAddTask;

    @AndroidFindBy(id = "android:id/message")
    private WebElement txtFieldTaskName;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement btnEnterTaskName;

    @AndroidFindBy(id = "com.todoist:id/action_mode_close_button")
    private WebElement btnBack;

    @AndroidFindBy(id = "com.todoist:id/menu_item_complete")
    private WebElement btnCompleteTask;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
    private WebElement moreOptions;

    @AndroidFindBy(xpath = "//com.todoist:id/title[@content-desc=\"More options\"]")
    private WebElement completedTasks;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Uncomplete\"]")
    private WebElement btnUnCompleteTask;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement btnNavigateBack;

    public projectPage(AndroidDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void createTask(String taskName)
    {
        btnAddTask.click();
        txtFieldTaskName.sendKeys(taskName);
        btnEnterTaskName.click();
        btnBack.click();
    }

    public void completeOpenedTask()
    {
        btnCompleteTask.click();
    }

    public void selectTask(String taskName)
    {
        int noOfTasks = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout")).size();
        for(int i = 1; i <= noOfTasks; i++)
        {
            WebElement ele = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[" + i + "]//android.widget.TextView"));
            System.out.println("Task name is: " + ele.getText());
            if(ele.getText().equals(taskName))
            {
                ele.click();
                System.out.println("Task found and selected successfully");
                return;
            }
        }
        Assert.fail("Task not found or not able to be selected");
    }
}
