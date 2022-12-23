import com.thoughtworks.gauge.Step;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);

    @Step("Sayfa url değerinin kontrol edilmesi")
    public void shouldActivePageUrlBeValid() {
        assertTrue(driver.getCurrentUrl().contains("giris.hepsiburada.com/"));
    }

    @Step("Giriş sayfasındaki elementlerin görünür olduklarının kontrol edilmesi")
    public void shouldLoginPageElementsBeVisible() {
        assertTrue(loginPage.checkLoginTabIsVisible());
        assertTrue(loginPage.checkUserNameInputIsVisible());
        assertTrue(loginPage.checkLoginButIsVisible());
    }
}
