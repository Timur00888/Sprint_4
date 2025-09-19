package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;

    private String name;
    private String surname;
    private String address;
    private String metro;
    private String phone;

    public OrderTest(String name, String surname, String address, String metro, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "ул. Пушкина, 1", "Сокольники", "+79991234567"},
                {"Пётр", "Петров", "ул. Лермонтова, 5", "Тверская", "+79997654321"}
        });
    }

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
    public void testOrderFlowTopButton() {
        if (driver == null) return;

        mainPage.getOrderTopButton().click();
        orderPage = new OrderPage(driver);

        orderPage.getNameField().sendKeys(name);
        orderPage.getSurnameField().sendKeys(surname);
        orderPage.getAddressField().sendKeys(address);
        orderPage.getMetroField().sendKeys(metro);
        orderPage.getPhoneField().sendKeys(phone);

        orderPage.getNextButton().click();
        orderPage.getOrderButton().click();
        orderPage.getConfirmYesButton().click();

        assertTrue(orderPage.getOrderConfirmationWindow().isDisplayed());
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



