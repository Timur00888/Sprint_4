package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    private final By header = By.className("Header_Header__21I2w");
    private final By orderTopButton = By.className("Button_Button__ra12g");
    private final By orderBottomButton = By.xpath("//div[contains(@class,'Home_FinishButton')]//button");
    private final By questionItems = By.className("accordion__button");
    private final By questionAnswers = By.className("accordion__panel");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHeader() {
        return driver.findElement(header);
    }

    public WebElement getOrderTopButton() {
        return driver.findElement(orderTopButton);
    }

    public WebElement getOrderBottomButton() {
        return driver.findElement(orderBottomButton);
    }

    public List<WebElement> getQuestionItems() {
        return driver.findElements(questionItems);
    }

    public List<WebElement> getQuestionAnswers() {
        return driver.findElements(questionAnswers);
    }
}