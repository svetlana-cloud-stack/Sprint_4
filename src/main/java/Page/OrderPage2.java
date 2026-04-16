package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderPage2 {
    private final WebDriver driver;

    public OrderPage2(WebDriver driver) {
        this.driver = driver;
    }

    // ЛОКАТОРЫ
    // дата аренды
    private By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // срок аренды
    private By rentField = By.xpath("//div[@class='Dropdown-control']");
    // цвета самоката
    private By blackColourCheckbox = By.xpath("//label[@for='black']");
    private By greyColourCheckbox = By.xpath("//label[@for='grey']");
    // поле для комментария
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // кнопка заказать
    private By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // подтверждение заказа
    private By confirmOrderBtn = By.xpath("//button[contains(text(),'Да')]");
    private By cancelOrderBtn = By.xpath("//button[contains(text(),'Нет')]");
    private By orderPlacedInfo = By.className("Order_Modal__YZ-d3");



    //МЕТОДЫ
    // мнтод для выбора дня
    public void selectDate(String day){
        driver.findElement(dateField).click();
        By dayLocator = By.xpath(
                "//div[contains(@class,'react-datepicker__day') and " +
                        "not(contains(@class,'outside-month')) and text()='" + day + "']"
        );
        driver.findElement(dayLocator).click();
    }
    // метод для выбора срока аренды
    private By rentOption(String value){
        return By.xpath("//div[contains(@class,'Dropdown-option') and text()='" + value + "']");
    }
    public void setRentPeriod(String value){
        driver.findElement(rentField).click();
        driver.findElement(rentOption(value)).click();
    }
    // методы для выбора цвета самоката
    public void selectBlackColour(){
        driver.findElement(blackColourCheckbox).click();
    }
    public void selectGreyColour(){
        driver.findElement(greyColourCheckbox).click();
    }
    // метод для написнаия комментария
    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    // метод для кнопки "Заказать"
    public void clickOrderBtn() {
        driver.findElement(orderButton).click();
    }
        // методы подтверждения заказа
     public void confirmOrder(){
        driver.findElement(confirmOrderBtn).click();
     }
    public void cancelOrder(){
        driver.findElement(cancelOrderBtn).click();
    }
    public boolean isOrderPlaced() {
        return driver.findElement(orderPlacedInfo).isDisplayed();
    }
        // метод для заполнения второй формы
    public void fillInOrderPage2(String date, String rentPeriod, String comment) {
        selectDate(date);
        setRentPeriod(rentPeriod);
        setComment(comment);

    }

}
