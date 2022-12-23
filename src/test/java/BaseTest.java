import com.thoughtworks.gauge.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.PropertyManager;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        if(PropertyManager.getInstance().getBrowserType().equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions p = new ChromeOptions();
            p.addArguments("--disable-notifications");
            driver = new ChromeDriver(p);
        }
        else if(PropertyManager.getInstance().getBrowserType().equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions p = new FirefoxOptions();
            p.addPreference("dom.webnotifications.enabled", false);
            driver = new FirefoxDriver(p);
        }
        else if(PropertyManager.getInstance().getBrowserType().equals("MSEdge")) {
            WebDriverManager.edgedriver().setup();
            HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
            edgePrefs.put("profile.default_content_settings.popups", 0);
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setExperimentalOption("prefs",edgePrefs);
            driver = new EdgeDriver(edgeOptions);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertyManager.getInstance().getImplicitWaitDuration()));
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
