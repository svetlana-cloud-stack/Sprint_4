import Page.MainPage;
import Page.OrderPage1;
import Page.OrderPage2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderFormTest extends BaseUITest {
    private final String name;
    private final String lastName;
    private final String address;
    private final String station;
    private final String telNumber;
    private final String date;
    private final String rentPeriod;
    private final String colour;
    private final String comment;

    public OrderFormTest(String name, String lastName, String address, String station, String telNumber,
                         String date, String rentPeriod, String colour, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.station = station;
        this.telNumber = telNumber;
        this.date = date;
        this.rentPeriod = rentPeriod;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Дина", "Омарова", "Москвская, 13", "Лубянка", "+99988877766", "26", "сутки", "black", "Позвонить по номеру +95468176231"},
                {"Галина", "Кузнецрва", "Зубарева, 37", "Кропоткинская", "+95556664443", "28", "двое суток", "grey","не звонить"},
        };
    }
@Test
    public void createOrder(){
        MainPage mainPage1 = new MainPage(driver);
        OrderPage1 orderPage1 = new OrderPage1(driver);
        OrderPage2 orderPage2 = new OrderPage2(driver);

        mainPage.openPage();
        mainPage.acceptCookies();
        mainPage.TopOrderButtonClick();

        assertTrue(orderPage1.isOrderPage1Opened());

        orderPage1.fillInOrderPage1( name, lastName, address, station, telNumber);
        orderPage1.clickNextButton();

        assertTrue(orderPage2.isOrderPage2Opened());

        orderPage2.fillInOrderPage2(date, rentPeriod,comment);

        if(colour.equals("black")) {
            orderPage2.selectBlackColour();
        } else if (colour.equals("grey")) {
            orderPage2.selectGreyColour();
        }
        orderPage2.clickOrderBtn();
        orderPage2.confirmOrder();

        assertTrue(orderPage2.isOrderPlaced());

}
}


