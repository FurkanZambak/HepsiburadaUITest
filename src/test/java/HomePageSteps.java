import com.thoughtworks.gauge.Step;
import pages.HomePage;
import util.PropertyManager;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageSteps extends BaseTest {

    HomePage homePage = new HomePage(driver);

    @Step("Anasayfa açılır")
    public void navigateHomePage() {
        driver.get(PropertyManager.getInstance().getAppURL());
    }

    @Step("Logonun sayfada göründüğü kontrol edilir")
    public void shouldLogoBeVisible() {
        assertTrue(homePage.checkLogoVisibility());
    }

    @Step("Sayfa url değerinin valid olduğu kontrol edilir")
    public void shouldCurrentUrlBeValid() {
        assertTrue(homePage.checkCurrentPageIsHomePage());
    }

    @Step("Header alanında <mainCategory> kategorisinin üzerine hover işlemi yapılır")
    public void hoverToMainCatItem(String mainCategory) {
        homePage.hoverToMainCategory(mainCategory);
    }

    @Step("Açılan listede <subCategory> alt kategorisinin üzerine hover işlemi yapılır")
    public void hoverToSubCatItem(String subCategory) {
        homePage.hoverToSubCategory(subCategory);
    }

    @Step("Açılan listede <category> kategorisine tıklanır")
    public void clickCategoryItem(String category) {
        homePage.clickCategory(category);
    }

    @Step("Cookies için Kabul Et butonuna tıklanır")
    public void clickAcceptCookiesBut() {
        homePage.clickAcceptCookiesBut();
    }
}
