package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text() = 'Giriş yap']")
    private WebElement loginTab;

    @FindBy(id = "txtUserName")
    private WebElement userNameInput;

    @FindBy(id = "btnLogin")
    private WebElement loginBut;

    public boolean checkLoginTabIsVisible() {
        return waitElementToBeVisible(this.loginTab).isDisplayed();
    }

    public boolean checkUserNameInputIsVisible() {
        return this.userNameInput.isDisplayed();
    }

    public boolean checkLoginButIsVisible() {
        return this.loginBut.isDisplayed();
    }
}
