package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class homePage extends basePage{

    @AndroidFindBy(id = "Change the current view")
    private WebElement btnMenu;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.TextView")
    private WebElement projects;

    public homePage(AndroidDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public WebElement getProject(String projectName)
    {
        btnMenu.click();
        projects.click();
        List<WebElement> projects = driver.findElements(By.id("android:id/content"));
        for(int i=1 ; i <  projects.size(); i++)
        {
            WebElement project = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout["+i+"]/android.widget.TextView[1]"));
            String name = project.getText();
            if(name.equals(projectName))
            {
                System.out.println("Project: " + name + " found");
                return project;
            }
                    }
        return null;

    }
}
