package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    // Локаторы
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.className("select-search__input");
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");
    private final By orderButton = By.xpath("//button[text()='Заказать']");
    private final By confirmYesButton = By.xpath("//button[text()='Да']");
    private final By orderConfirmationWindow = By.className("Order_Modal__YZ-d3");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Заполнение формы
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void selectMetro(String metro) {
        driver.findElement(metroField).sendKeys(metro);
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroField).sendKeys(Keys.ENTER);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void confirmOrder() {
        driver.findElement(confirmYesButton).click();
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(orderConfirmationWindow).isDisplayed();
    }

    // 🔹 Метод "заполнить и отправить заказ"
    public void fillAndSubmitOrder(String name, String surname, String address, String metro, String phone) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        selectMetro(metro);
        enterPhone(phone);
        clickNextButton();
        clickOrderButton();
        confirmOrder();
    }
}