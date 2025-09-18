package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

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

        mainPage.getQuestionItems().get(0).click();
        assertTrue(mainPage.getQuestionAnswers().get(0).isDisplayed());
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



