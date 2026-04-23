package ru.yandex.praktikum.page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
   public WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    // ЛОКАТОРЫ
    // лого "Яндекс"
    private By yandexLogo = By.xpath("//img[@alt='Yandex']");
    // лого "Самокат"
    private By logoScooter = By.xpath("//img[@alt='Scooter']");
    // верхняя кнопка "Заказать"
    private By topOrderBtn = By.cssSelector("button[class='Button_Button__ra12g']");
    // нижняя кнопка "Заказать"
    private  By bottomOrderBtn = By.xpath("//div[contains(@class,'Home_FinishButton')]//button[text()='Заказать']");
    // вопросы о важном
    private By questionIndex(int index) {
        return By.id("accordion__heading-" + index);
    }
    //ответы
    private By ansIndex(int index) {
        return By.id("accordion__panel-" + index);
    }
    private By cookieBtn = By.id("rcc-confirm-button");


    // МЕТОДЫ

    //  метод для перехода на страницу

    public void openPage(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // метод для принятия куков
    public void acceptCookies() {
        if(driver.findElements(cookieBtn).size()>0) {
            driver.findElement(cookieBtn).click();
        }
    }

    // метод для получения текста вопроса
    public String getQuestionText(int index) {
    WebElement question = driver.findElement(questionIndex(index));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
    return question.getText();
}
    // метод для клика по вопросу
    public void clickQuestion(int index){
        WebElement question = driver.findElement(questionIndex(index));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
    }
    // метод для получения текста ответа
    public String getAnswerText(int index){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ansIndex(index)));
        return driver.findElement(ansIndex(index)).getText();
    }
    // метод для клика на верхнюю кнопку "Заказать"
    public void topOrderButtonClick() {
        driver.findElement(topOrderBtn).click();
    }

    // метод для скрола до нижней кнопки
    private void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // метод для клика на нижнюю кнопку "Заказать"
    public void bottomOrderButtonClick() {
        scrollToElement(bottomOrderBtn);
        driver.findElement(bottomOrderBtn).click();
    }
        // метод для клика на лого "Самокат"
     public void scooterLogoClick(){
        driver.findElement(logoScooter).click();
     }
    // метод для клика на лого "Яндекс"
     public void yandexLogoClick(){
        driver.findElement(yandexLogo).click();
     }
}

