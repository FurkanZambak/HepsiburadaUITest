package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListPage extends BasePage {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sorting [data-test-id = 'dropdown-toggle']")
    private WebElement sortingDropdown;

    @FindBy(css = ".sorting [data-test-id = 'dropdown-content']")
    private WebElement sortingList;

    @FindBy(css = "input[placeholder = 'Filtrele']")
    private WebElement filterInput;

    @FindBy(css = "h1.title")
    private WebElement titleHeader;

    @FindBy(css = ".ProductList a")
    private List<WebElement> productList;

    @FindBy(css = ".tippy-box svg")
    private WebElement closeTooltipField;



    public void typeFilterInput(String brand) {
        scrollIntoView(this.filterInput);
        this.filterInput.click();
        this.filterInput.sendKeys(brand);
    }
    public WebElement getBrandCheckboxInput(String brand) {
        WebElement element = driver.findElement(By.xpath("//input[@name =  'markalar' and @value = '" + brand.toLowerCase() + "']"));
        return waitElementToBeClickable(element);
    }

    public void checkBrandCheckbox(String brand) {
        getBrandCheckboxInput(brand).click();
        refreshPage();
    }

    public boolean checkBrandCheckboxIsChecked(String brand) {
        return waitElementToBeVisible(getBrandCheckboxInput(brand)).isSelected();
    }

    public boolean checkTitleHeaderTxt(String contentTxt) {
        return this.titleHeader.getText().contains(contentTxt);
    }

    public WebElement getSortingTypeItem(String sortingType) {
        WebElement element = this.sortingList.findElement(By.xpath(".//div[text() = '" + sortingType + "']"));
        return element;
    }

    public void selectASortingType(String sortingType) {
        waitElementToBeClickable(getSortingTypeItem(sortingType)).click();
    }

    public boolean checkSortingTypeIsSelected(String sortingType) {
        WebElement element = getSortingTypeItem(sortingType).findElement(By.xpath(".//following-sibling::i"));
        return waitElementToBeVisible(element).isDisplayed();
    }

    public void clickSortingList() {
        this.sortingDropdown.click();
    }

    public void selectAProduct(int index) {
        WebElement element = this.productList.get(index - 1);
        scrollIntoView(element);
        Click(waitElementToBeVisible(element));
    }

    public void clickCloseTooltip() {
        waitElementToBeClickable(this.closeTooltipField).click();
    }
}
