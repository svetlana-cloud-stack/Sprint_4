package ru.yandex.praktikum.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderPageCustomerData {
    private final WebDriver driver;

    public OrderPageCustomerData(WebDriver driver) {
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
    private By telNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // ошибки полей формы заказа
    private By nameFieldError = By.xpath("//input[@placeholder='* Имя']/following-sibling::div");
    private By lastNameError = By.xpath("//input[@placeholder='* Фамилия']/following-sibling::div");
    private By addressError = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']/following-sibling::div");
    private By telNumberError = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']/following-sibling::div");


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

    // метод для поля "Станция метро"
    private By stationOption(String stationName) {
        return By.xpath("//*[contains(text(),'" + stationName + "')]");
    }
    public void selectStation(String station){
        driver.findElement(stationField).click();
        driver.findElement(stationField).sendKeys(station);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(stationOption(station)));
        driver.findElement(stationOption(station)).click();
    }

    // метод для поля "Телефон"
    public void setTelNumberField(String telNumber){
        driver.findElement(telNumberField).sendKeys(telNumber);
    }
    // метод для кнопки "Далее"
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }

    // метод для заполения первой формы
    public void fillInOrderPage1(String name, String lastname, String address, String station, String telNumber){
        setNameField(name);
        setLastNameField(lastname);
        setAddressField(address);
        selectStation(station);
        setTelNumberField(telNumber);
    }

    // методы для получения текста ошибок
    public String getNameErrorText() {
        return driver.findElement(nameFieldError).getText();
    }

    public String getLastNameErrorText() {
        return driver.findElement(lastNameError).getText();
    }

    public String getAddressErrorText() {
        return driver.findElement(addressError).getText();
    }

    public String getTelNumberErrorText() {
        return driver.findElement(telNumberError).getText();
    }
}
