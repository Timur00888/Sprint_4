package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By questionItems = By.className("accordion__button");
    private By answerItems = By.className("accordion__panel");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public void clickQuestion(int index) {
        driver.findElements(questionItems).get(index).click();
    }


    public String getAnswerText(int index) {
        WebElement answer = driver.findElements(answerItems).get(index);
        wait.until(ExpectedConditions.visibilityOf(answer));
        return answer.getText();
    }
}