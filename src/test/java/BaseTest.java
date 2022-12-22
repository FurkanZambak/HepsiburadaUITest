import com.thoughtworks.gauge.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.PropertyManager;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        if(PropertyManager.getInstance().getBrowserType().equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(PropertyManager.getInstance().getBrowserType().equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(PropertyManager.getInstance().getBrowserType().equals("MSEdge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertyManager.getInstance().getImplicitWaitDuration()));
    }

    @AfterSuite
    public void tearDown() {
        //driver.quit();
    }

    /*public WebDriver getDriver() {
        return driver;
    }*/
}
