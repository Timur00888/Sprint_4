package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameField() {
        return driver.findElement(By.xpath("//input[@placeholder='* Имя']"));
    }

    public WebElement getSurnameField() {
        return driver.findElement(By.xpath("//input[@placeholder='* Фамилия']"));
    }

    public WebElement getAddressField() {
        return driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"));
    }

    public WebElement getMetroField() {
        return driver.findElement(By.className("select-search__input"));
    }

    public WebElement getPhoneField() {
        return driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"));
    }

    public WebElement getNextButton() {
        return driver.findElement(By.xpath("//button[text()='Далее']"));
    }

    public WebElement getOrderButton() {
        return driver.findElement(By.xpath("//button[text()='Заказать']"));
    }

    public WebElement getConfirmYesButton() {
        return driver.findElement(By.xpath("//button[text()='Да']"));
    }

    public WebElement getOrderConfirmationWindow() {
        return driver.findElement(By.className("Order_Modal__YZ-d3"));
    }
}

