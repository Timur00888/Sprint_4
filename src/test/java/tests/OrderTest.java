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

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}, метро {3}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "ул. Пушкина, 1", "Сокольники", "+79991234567"},
                {"Пётр", "Петров", "ул. Лермонтова, 5", "Тверская", "+79997654321"}
        });
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testOrderFlowTopButton() {
        mainPage.getOrderTopButton().click();
        orderPage.fillAndSubmitOrder(name, surname, address, metro, phone);
        assertTrue(orderPage.isOrderConfirmed());
    }

    @Test
    public void testOrderFlowBottomButton() {
        mainPage.getOrderBottomButton().click();
        orderPage.fillAndSubmitOrder(name, surname, address, metro, phone);
        assertTrue(orderPage.isOrderConfirmed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}