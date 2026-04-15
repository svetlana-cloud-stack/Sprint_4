package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage1 {
    private WebDriver driver;

    public OrderPage1(WebDriver driver) {
        this.driver = driver;
    }
    //ЛОКАТОРЫ

    // заголовок формы заказа
    private By orderHeader = By.xpath("//div[@class='Order_Header__BZXOb']");

    // поля формы заказа
    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    private By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By stationField = By.xpath("//input[@placeholder='* Станция метро']");
    private By telNumberFiled = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка далее
    private By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // МЕТОДЫ
    // метод для проверки открытия формы
    public boolean isOrderPage1Opened() {
        return driver.findElement(orderHeader).isDisplayed();
    }
    // метод для поля "Имя"
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    // метод для поля "Фамилия""
    public void setLastNameField(String lastname) {
        driver.findElement(lastNameField).sendKeys(lastname);
    }
    // метод для поля "Адрес"
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    // метод для поля "Телефон"
    public void setTelNumberFiled(String telNumber){
        driver.findElement(telNumberFiled).sendKeys(telNumber);
    }
    // метод для поля "Станция метро"
    public void selectStation(String station){
        driver.findElement(stationField).click();
        driver.findElement(stationField).sendKeys(station);
        driver.findElement(By.xpath("//*[text()='" + station + "']")).click();
    }
    // метод для кнопки "Далее"
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
}
