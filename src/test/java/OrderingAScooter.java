import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.Order;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderingAScooter {
    private final String name;
    private final String surname;
    private final String address;
    private final int metroStationIdx;
    private final String phoneNumber;
    private final int orderDateIdx;
    private final int rentalPeriodIdx;
    private final int colorOfTheScooterIdx;
    private final String comment;
    private final boolean expected;

    private WebDriver driver;

    public OrderingAScooter(String name, String surname, String address, int metroStationIdx, String phoneNumber, int orderDateIdx, int rentalPeriodIdx, int colorOfTheScooterIdx, String comment, boolean expected) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationIdx = metroStationIdx;
        this.phoneNumber = phoneNumber;
        this.orderDateIdx = orderDateIdx;
        this.rentalPeriodIdx = rentalPeriodIdx;
        this.colorOfTheScooterIdx = colorOfTheScooterIdx;
        this.comment = comment;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSuccessfulOrder() {
        return new Object[][]{
                {"Вероника", "Балтина", "Москва, Ивантеевская улица, 25", 1, "89999999999", 1, 2, 0, "домофон работает", true},
                {"Кирилл", "Балтин", "Москва", 2, "+79999999991", 0, 1, 1, "домофон не работает", true},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void orderAScooterUsingTheOrderButtonAtTheBottom() {
        Order page = new Order(driver);
        page.openAWebsiteToOrderAScooter();
        page.clickOnTheOrderButtonAtTheBottom();
        page.fillInTheNameField(name);
        page.fillInTheLastNameField(surname);
        page.fillInTheAddressField(address);
        page.chooseAMetroStation(metroStationIdx);
        page.fillInThePhoneNumberField(phoneNumber);
        page.clickOnTheNextButton();
        page.selectTheOrderDate(orderDateIdx);
        page.selectTheRentalPeriod(rentalPeriodIdx);
        page.chooseTheColorOfTheScooter(colorOfTheScooterIdx);
        page.leaveACommentToTheCourier(comment);
        page.clickTheOrderButtonOnTheOrderPage();
        page.confirmTheOrder();
        boolean actual = page.isSuccessfulMessageAppeared();
        assertEquals(expected, actual);
    }

    @Test
    public void orderAScooterUsingTheOrderButtonOnTop() {
        Order page = new Order(driver);
        page.openAWebsiteToOrderAScooter();
        page.clickOnTheOrderButtonAtTheTop();
        page.fillInTheNameField(name);
        page.fillInTheLastNameField(surname);
        page.fillInTheAddressField(address);
        page.chooseAMetroStation(metroStationIdx);
        page.fillInThePhoneNumberField(phoneNumber);
        page.clickOnTheNextButton();
        page.selectTheOrderDate(orderDateIdx);
        page.selectTheRentalPeriod(rentalPeriodIdx);
        page.chooseTheColorOfTheScooter(colorOfTheScooterIdx);
        page.leaveACommentToTheCourier(comment);
        page.clickTheOrderButtonOnTheOrderPage();
        page.confirmTheOrder();
        boolean actual = page.isSuccessfulMessageAppeared();
        assertEquals(expected, actual);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}