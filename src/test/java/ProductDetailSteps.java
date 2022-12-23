import com.thoughtworks.gauge.Step;
import pages.ProductDetailPage;
import util.DataOps;
import static org.junit.jupiter.api.Assertions.*;

public class ProductDetailSteps extends BaseTest {

    ProductDetailPage productDetailPage = new ProductDetailPage(driver);

    @Step("Ürün detayı sayfasının açıldığının kontrolü")
    public void shouldProductDetailPageOpened() {
        assertTrue(productDetailPage.checkProductHeaderIsVisible());
        assertTrue(productDetailPage.checkAddToCartButIsVisible());
    }

    @Step("Ürün detayının dosyaya yazılması")
    public void writeProductDetailsToFile() {
        String dataTxt = productDetailPage.getProductNameTxt() + " - " + productDetailPage.getProductPriceTxt();
        DataOps dataOps = new DataOps();
        dataOps.writeDataToFile(dataTxt);
    }

    @Step("Sepete Ekle butonuna tıklanır")
    public void clickAddToCartButton()  {
        productDetailPage.clickAddToCartBut();
    }

    @Step("Ürün detayı dosyadan okunarak modal ekranda karşılaştırılır")
    public void shouldProductNameBeVisible() {
        DataOps dataOps = new DataOps();
        String productDetail = dataOps.readFile();
        String prodName = productDetail.split(" - ")[0];
        assertTrue(productDetailPage.checkProductNameOnHeaderIsVisible(prodName));
    }

    @Step("Ürün sepetinizde textinin görünür olduğunun kontrol edilmesi")
    public void shouldProductInBasketTxtBeVisible() {
        assertTrue(productDetailPage.checkProductInBasketTxtIsVisible());
    }

    @Step("Sepete git butonuna tıklanır")
    public void clickGoToBasketBut() {
        productDetailPage.clickGoToCartBut();
    }
}
