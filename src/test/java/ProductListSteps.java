import com.thoughtworks.gauge.Step;
import pages.ProductListPage;

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
}
