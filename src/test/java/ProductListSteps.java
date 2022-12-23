import com.thoughtworks.gauge.Step;
import pages.ProductListPage;
import static org.junit.jupiter.api.Assertions.*;

public class ProductListSteps extends BaseTest {

    ProductListPage productListPage = new ProductListPage(driver);

    @Step("<brand> marka filtresi değeri için arama yapılır")
    public void typeBrandName(String brand) {
        productListPage.typeFilterInput(brand);
    }

    @Step("<brand> marka filtresine göre filtreleme işlemi yapılır")
    public void checkBrandCheckboxField(String brand) {
        productListPage.checkBrandCheckbox(brand);
    }

    @Step("<brand> marka filtresinin seçilmiş olduğu kontrol edilir")
    public void shouldBrandCheckboxBeChecked(String brand) {
        productListPage.checkBrandCheckboxIsChecked(brand);
    }

    @Step("Sayfadaki title elementinin içeriğinde <text> yazısının görülmesi")
    public void shouldTitleHeaderContainsTxt(String text) {
        productListPage.checkTitleHeaderTxt(text);
    }

    @Step("Sıralama listesine tıklanır")
    public void clickSortingDropdown() {
        productListPage.clickSortingList();
    }

    @Step("Sıralama listesinden <sortingType> değeri seçilir")
    public void selectSortingType(String sortingType) {
        productListPage.selectASortingType(sortingType);
    }

    @Step("Sıralama listesinde <sortingType> değerinin seçilmiş olduğunun görülmesi")
    public void shouldSortingTypeBeSelected(String sortingType) {
        assertTrue(productListPage.checkSortingTypeIsSelected(sortingType));
    }

    @Step("Ürün listesinden <no> numaralı ürünün seçilmesi")
    public void selectAProduct(String no) {
        productListPage.selectAProduct(Integer.parseInt(no));
    }

    @Step("Hızlı teslim tooltip kapatılır")
    public void closeTooltip() {
        productListPage.clickCloseTooltip();
    }
}
