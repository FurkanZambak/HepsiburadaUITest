package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertyManager;
import java.time.Duration;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitElementToBeClickable(WebElement element, int sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        return waitElementToBeClickable(element, 5);
    }

    public WebElement waitElementToBeVisible(WebElement element, int sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementToBeVisible(WebElement element) {
        return waitElementToBeVisible(element, 5);
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void Click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void hoverToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void waitForAjaxLoad() {
        int waitTime = PropertyManager.getInstance().getAjaxLoadWaitLimit();
        int count = 0;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        if((Boolean) ((JavascriptExecutor) driver).executeScript("return window.jQuery != null"))
        {
            while(!(Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0"))
            {
                try {
                    Thread.sleep(4000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(count > 4) break; count++;
            }
        }
    }
}
