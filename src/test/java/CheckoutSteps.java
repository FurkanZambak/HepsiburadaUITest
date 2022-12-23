import com.thoughtworks.gauge.Step;
import pages.CheckoutPage;
import util.DataOps;
import static org.junit.jupiter.api.Assertions.*;

public class CheckoutSteps extends BaseTest {

    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Step("Sepetim header alanının sayfada gözüktüğünün kontrolü")
    public void shouldMyBasketHeaderBeVisible() {
        assertTrue(checkoutPage.checkMyBasketHeaderIsVisible());
    }

    @Step("Sepetteki ürünün verileri ile dosyadaki veriler karşılaştırılır")
    public void shouldProductDataBeValid() {
        DataOps dataOps = new DataOps();
        String productDetail = dataOps.readFile();
        String prodName = productDetail.split(" - ")[0];
        String prodPrice = productDetail.split(" - ")[1];
        assertEquals(prodName, checkoutPage.getProductName());
        assertEquals(prodPrice, checkoutPage.getProductPrice());
        assertEquals("1", checkoutPage.getProductQuantityValue());
    }

    @Step("Alışverişi tamamla butonuna tıklanır")
    public void clickContinueShoppingBut() {
        checkoutPage.clickContinueShoppingBut();
    }
}
