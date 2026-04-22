import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPageCustomerData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class FieldErrorTest extends BaseUITest {

    private final String fieldName;
    private final String invalidValue;
    private final String expectedError;

    public FieldErrorTest(String fieldName, String invalidValue, String expectedError) {
        this.fieldName = fieldName;
        this.invalidValue = invalidValue;
        this.expectedError = expectedError;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"name", "adf88", "Введите корректное имя"},
                {"lastName", "qwer567", "Введите корректную фамилию"},
                {"address", "AQid12349", "Введите корректный адрес"},
                {"phone", "12312qwe", "Введите корректный номер"}
        };
    }

    @Test
    public void showErrorMessage() {
        MainPage mainPage = new MainPage(driver);
        OrderPageCustomerData orderPageCustomerData = new OrderPageCustomerData(driver);

        mainPage.openPage();
        mainPage.acceptCookies();
        mainPage.topOrderButtonClick();

        assertTrue(orderPageCustomerData.isCustomerDataPageOpened());

        if (fieldName.equals("name")) {
            orderPageCustomerData.setNameField(invalidValue);
            orderPageCustomerData.clickNextButton();
            assertEquals(expectedError, orderPageCustomerData.getNameErrorText());

        } else if (fieldName.equals("lastName")) {
            orderPageCustomerData.setLastNameField(invalidValue);
            orderPageCustomerData.clickNextButton();
            assertEquals(expectedError, orderPageCustomerData.getLastNameErrorText());

        } else if (fieldName.equals("address")) {
            orderPageCustomerData.setAddressField(invalidValue);
            orderPageCustomerData.clickNextButton();
                assertEquals(expectedError, orderPageCustomerData.getAddressErrorText());

        } else if (fieldName.equals("phone")) {
            orderPageCustomerData.setTelNumberField(invalidValue);
            orderPageCustomerData.clickNextButton();
            assertEquals(expectedError, orderPageCustomerData.getTelNumberErrorText());
        }
    }
}