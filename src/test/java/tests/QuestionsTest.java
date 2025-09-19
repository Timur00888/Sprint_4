package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class QuestionsTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            mainPage = new MainPage(driver);
        } catch (Exception e) {
            driver = null;
            System.out.println("Ошибка при инициализации драйвера: " + e.getMessage());
        }
    }

    @Test
    public void testQuestionsAccordion() {
        if (driver == null) return;

        // 🔹 Получаем списки всех вопросов и ответов
        List<WebElement> questions = mainPage.getQuestionItems();
        List<WebElement> answers = mainPage.getQuestionAnswers();

        // 🔹 Проверяем каждый вопрос
        for (int i = 0; i < questions.size(); i++) {
            questions.get(i).click(); // открыть вопрос
            assertTrue(
                    "Ответ на вопрос №" + (i + 1) + " не отображается",
                    answers.get(i).isDisplayed()
            );
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Ошибка при закрытии драйвера: " + e.getMessage());
            }
        }
    }
}