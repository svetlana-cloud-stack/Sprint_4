import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPageCustomerData;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BottomOrderBtnTest extends BaseUITest {

    @Test
    public void openOrderFormFromBottomButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPageCustomerData orderPage1 = new OrderPageCustomerData(driver);

        mainPage.openPage();
        mainPage.bottomOrderButtonClick();

        assertTrue(orderPage1.isOrderPage1Opened());
    }
}
