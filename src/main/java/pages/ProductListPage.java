package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-test-id = 'dropdown-toggle'")
    private WebElement sortingDropdown;

    @FindBy(xpath = "//input[@placeholder = 'Filtrele']")
    private WebElement filterInput;

    public void typeFilterInput(String brand) {
        scrollIntoView(this.filterInput);
        this.filterInput.click();
        this.filterInput.sendKeys(brand);
    }
    public WebElement getBrandCheckboxInput(String brand) {
        WebElement element = driver.findElement(By.xpath("//input[@name =  'markalar' and @value = '" + brand.toLowerCase() + "']"));
        return element;
    }

    public void checkBrandCheckbox(String brand) {
        waitElementToBeClickable(getBrandCheckboxInput(brand)).click();
    }

    public boolean checkBrandCheckboxIsChecked(String brand) {
        return getBrandCheckboxInput(brand).isSelected();
    }
}
