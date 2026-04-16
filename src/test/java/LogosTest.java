import Page.MainPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LogosTest extends BaseUITest {

    @Test
    public void OpenScooterPage() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();
        mainPage.ScooterLogoClick();

        assertTrue(driver.getCurrentUrl().contains("scooter"));
    }

    @Test
    public void OpenYandexPage() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openPage();

        String originalWindow = driver.getWindowHandle();

        mainPage.YandexLogoClick();

        // переключаемся на новую вкладку
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        assertTrue(driver.getCurrentUrl().contains("ya")
                || driver.getCurrentUrl().contains("yandex")
                || driver.getCurrentUrl().contains("dzen"));
    }
}
