import Page.MainPage;
import Page.OrderPage1;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BottomOrderBtnTest extends BaseUITest {

    @Test
    public void OpenOrderFormFromBottomButton() {
        MainPage mainPage = new MainPage(driver);
        OrderPage1 orderPage1 = new OrderPage1(driver);

        mainPage.openPage();
        mainPage.BottomOrderButtonClick();

        assertTrue(orderPage1.isOrderPage1Opened());
    }
}
