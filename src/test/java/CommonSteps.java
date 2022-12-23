import com.thoughtworks.gauge.Step;
import pages.BasePage;

import java.util.ArrayList;

public class CommonSteps extends BaseTest {

    BasePage basePage = new BasePage(driver);

    @Step("Sayfadaki ajax çağrıları tamamlanıncaya kadar beklenilir")
    public void waitUntilAjaxCallsEnd() {
        basePage.waitForAjaxLoad();
    }

    @Step("<tabNo> nolu tab ekranına geçiş yapılır")
    public void switchToTab(String tabNo) {
        ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(Integer.parseInt(tabNo) - 1));
    }

    @Step("Sayfada refresh işlemi uygulanır")
    public void refreshPage() {
        driver.navigate().refresh();
    }
}
