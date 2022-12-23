package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PropertyManager;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//a[@title = 'Hepsiburada' and @href = '/']")
    private WebElement logoLink;

    @FindBy(xpath = "//div[contains(@id, 'NavigationDesktop')]")
    private WebElement categoryDiv;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesBut;


    public boolean checkLogoVisibility() {
        return waitElementToBeVisible(this.logoLink).isDisplayed();
    }

    public boolean checkCurrentPageIsHomePage() {
        return driver.getCurrentUrl().equals(PropertyManager.getInstance().getAppURL());
    }

    public void hoverToMainCategory(String mainCategory) {
        WebElement element = this.categoryDiv.findElement(By.xpath(".//span[text() = '" + mainCategory + "']"));
        hoverToElement(element);
    }

    public void hoverToSubCategory(String subCategory) {
        WebElement element = this.categoryDiv.findElement(By.xpath(".//a[text() = '" + subCategory + "']"));
        waitElementToBeClickable(element);
        hoverToElement(element);
    }

    public void clickCategory(String category) {
        WebElement element = this.categoryDiv.findElement(By.xpath(".//span[text() = '" + category + "']"));
        Click(waitElementToBeClickable(element.findElement(By.xpath("./.."))));
    }

    public void clickAcceptCookiesBut() {
        this.acceptCookiesBut.click();
    }
}
