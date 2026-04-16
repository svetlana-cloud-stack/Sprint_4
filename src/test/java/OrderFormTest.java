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
                {"Дина", "Омарова", "Москвская, 13", "Лубянка", "+99988877766", "26.04.2026", "black", "Позвонить по номеру +95468176231"},
                {"Галина", "Кузнецрва", "Зубарева, 37", "Кропоткинская", "+95556664443", "28.04.2026", "null"},
        };
    }


}
