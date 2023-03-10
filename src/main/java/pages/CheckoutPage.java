package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class *= 'product_name'] > a")
    private WebElement productNameField;

    @FindBy(css = "[data-test-id = 'price-current-price']")
    private WebElement priceField;

    @FindBy(id = "continue_step_btn")
    private WebElement continueShoppingBut;

    @FindBy(css = "[name = 'quantity']")
    private WebElement quantityInput;

    @FindBy(xpath = "//h1[text() = 'Sepetim']")
    private WebElement myBasketHeader;

    public String getProductName() {
        return waitElementToBeVisible(this.productNameField).getText();
    }

    public String getProductPrice() {
        return this.priceField.getText();
    }

    public void clickContinueShoppingBut() {
        this.continueShoppingBut.click();
    }

    public String getProductQuantityValue() {
        return this.quantityInput.getAttribute("value");
    }

    public boolean checkMyBasketHeaderIsVisible() {
        return waitElementToBeVisible(this.myBasketHeader).isDisplayed();
    }
}
