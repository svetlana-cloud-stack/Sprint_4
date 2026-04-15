import Page.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUITest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @Before
    public void startBrowser() {
       String browser = System.getProperty("browser","chrome");
        if ("firefox".equals(browser)) {
            startBrowserFirefox();
        } else {
            startBrowserChrome();
        }

        mainPage = new MainPage(driver);
    }

    public void startBrowserChrome() {
        driver = new ChromeDriver();
    }

    public void startBrowserFirefox() {
        driver = new FirefoxDriver();
    }


    @After
    public void tearDown() {
        if (driver != null){
            driver.quit();
        }
    }
}