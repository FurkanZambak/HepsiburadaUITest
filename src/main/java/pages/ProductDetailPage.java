package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "product-name")
    private WebElement productNameHeader;

    @FindBy(id = "offering-price")
    private WebElement priceField;

    @FindBy(id = "addToCart")
    private WebElement addToCartBut;

    @FindBy(xpath = "//span[contains(text(), 'Ürün sepetinizde')]")
    private WebElement productInBasketTxt;

    @FindBy(xpath = "//button[text() = 'Sepete git']")
    private WebElement goToBasketBut;

    public boolean checkProductHeaderIsVisible() {
        return waitElementToBeVisible(this.productNameHeader).isDisplayed();
    }

    public boolean checkAddToCartButIsVisible() {
        return this.addToCartBut.isDisplayed();
    }

    public String getProductNameTxt() {
        return this.productNameHeader.getText();
    }

    public String getProductPriceTxt() {
        return this.priceField.getText();
    }

    public void clickAddToCartBut() {
        this.addToCartBut.click();
    }

    public boolean checkProductNameOnHeaderIsVisible(String productName) {
        WebElement element = driver.findElement(By.xpath("//h6[text() = '" + productName + "']"));
        return element.isDisplayed();
    }

    public boolean checkProductInBasketTxtIsVisible() {
        return waitElementToBeVisible(this.productInBasketTxt, 15).isDisplayed();
    }

    public void clickGoToCartBut() {
        this.goToBasketBut.click();
    }
}
