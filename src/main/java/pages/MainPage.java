package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHeader() {
        return driver.findElement(By.className("Header_Header__21I2w"));
    }

    public WebElement getOrderTopButton() {
        return driver.findElement(By.className("Button_Button__ra12g"));
    }

    public WebElement getOrderBottomButton() {
        return driver.findElement(By.xpath("//div[contains(@class,'Home_FinishButton')]//button"));
    }

    public List<WebElement> getQuestionItems() {
        return driver.findElements(By.className("accordion__button"));
    }

    public List<WebElement> getQuestionAnswers() {
        return driver.findElements(By.className("accordion__panel"));
    }
}

