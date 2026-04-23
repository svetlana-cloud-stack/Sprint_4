import ru.yandex.praktikum.page.OrderPageCustomerData;
import ru.yandex.praktikum.page.OrderPageRentData;
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
                {"Галина", "Кузнецова", "Зубарева, 37", "Кропоткинская", "+95556664443", "28", "двое суток", "grey","не звонить"},
        };
    }
@Test
    public void createOrder() {
    OrderPageCustomerData orderPageCustomer = new OrderPageCustomerData(driver);
    OrderPageRentData orderPageRent = new OrderPageRentData(driver);


        mainPage.openPage();
        mainPage.acceptCookies();
        mainPage.topOrderButtonClick();

        assertTrue(orderPageCustomer.isCustomerDataPageOpened());

        orderPageCustomer.fillInCustomerDataPage( name, lastName, address, station, telNumber);
        orderPageCustomer.clickNextButton();

        assertTrue(orderPageRent.isRentPageOpened());

        orderPageRent.fillInRentPage(date, rentPeriod,comment);

        if(colour.equals("black")) {
            orderPageRent.selectBlackColour();
        } else if (colour.equals("grey")) {
            orderPageRent.selectGreyColour();
        }
        orderPageRent.clickOrderBtn();
        orderPageRent.confirmOrder();
        assertTrue(orderPageRent.isOrderPlaced());

}
}


