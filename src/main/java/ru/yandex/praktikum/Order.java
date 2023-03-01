package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Order {
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    // локатор кнопок Заказать на главной странице
    private static final By ORDER_BUTTON_LIST = By.xpath(".//button[text() = 'Заказать']");
    // локатор поля Имя
    private static final By FIELD_FOR_ENTERING_THE_NAME_IN_THE_ORDER = By.xpath(".//input[@placeholder = '* Имя']");
    // локатор поля Фамилия
    private static final By THE_FIELD_FOR_ENTERING_THE_LAST_NAME_IN_THE_ORDER = By.xpath(".//input[@placeholder = '* Фамилия']");
    // локатор поля Адрес
    private static final By FIELD_FOR_ENTERING_THE_ADDRESS_IN_THE_ORDER = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // локатор поля Станция метро
    private static final By METRO_SELECTION_FIELD_IN_THE_ORDER = By.xpath(".//input[@placeholder = '* Станция метро']");
    // локатор поля Телефон
    private static final By PHONE_ENTRY_FIELD_IN_THE_ORDER = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // локатор кнопки Далее
    private static final By NEXT_BUTTON = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text() = 'Далее']");
    // локатор поля Когда привезти самокат
    private static final By DATE_SELECTION_FIELD_IN_THE_ORDER = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    // локатор дней в календаре
    private static final By DATE_SELECTION = By.xpath(".//div[@class='react-datepicker__week']");
    // локатор поля Срок аренды
    private static final By FIELD_FOR_CHOOSING_THE_RENTAL_PERIOD = By.xpath(".//div[@class='Dropdown-placeholder']");
    // локатор меню Срока аренды
    private static final By CHOOSING_THE_RENTAL_PERIOD = By.xpath(".//div[@class='Dropdown-option']");
    // локатор поля Цвет скутера
    private static final By SCOOTER_COLOR_SELECTION_FIELD = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']");
    // локатор цвета скутера
    private static final By CHOOSE_THE_COLOR_OF_THE_SCOOTER = By.xpath(".//input[@class='Checkbox_Input__14A2w']");
    // локатор поля Комментарий для курьера
    private static final By A_COMMENT_FIELD_FOR_THE_COURIER = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    // локатор кнопки Заказать на странице заказа
    private static final By THE_ORDER_BUTTON_ON_THE_ORDER_PAGE = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    // локатор кнопки Да в окне подтверждения заказа
    private static final By ORDER_CONFIRMATION = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Да']");
    // локатор окна с сообением об заказе
    private static final By SUCCESSFUL_ORDER_MESSAGE = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");
    // локатор списка метро
    private static final By METRO_LIST = By.xpath(".//li[@class='select-search__row']");
    private final WebDriver driver;

    public Order(WebDriver driver) {
        this.driver = driver;
    }
    // открыть стр сайта
    public void openAWebsiteToOrderAScooter() {
        driver.get(PAGE_URL);
    }
    // Ввести в поле "Имя" имя
    public void fillInTheNameField(String name) {
        driver.findElement(FIELD_FOR_ENTERING_THE_NAME_IN_THE_ORDER).clear();
        driver.findElement(FIELD_FOR_ENTERING_THE_NAME_IN_THE_ORDER).sendKeys(name);
    }
    // Ввести в поле "Фамилия" фамилию
    public void fillInTheLastNameField(String surname) {
        driver.findElement(THE_FIELD_FOR_ENTERING_THE_LAST_NAME_IN_THE_ORDER).clear();
        driver.findElement(THE_FIELD_FOR_ENTERING_THE_LAST_NAME_IN_THE_ORDER).sendKeys(surname);
    }
    // Ввести в поле "Адрес" адрес
    public void fillInTheAddressField(String address) {
        driver.findElement(FIELD_FOR_ENTERING_THE_ADDRESS_IN_THE_ORDER).clear();
        driver.findElement(FIELD_FOR_ENTERING_THE_ADDRESS_IN_THE_ORDER).sendKeys(address);
    }
    // Выбрать станцию метро
    public void chooseAMetroStation(int metroStationIdx) {
        driver.findElement(METRO_SELECTION_FIELD_IN_THE_ORDER).click();
        List<WebElement> list = driver.findElements(METRO_LIST);
        WebElement e = list.get(metroStationIdx);
        e.click();
    }
    // Ввести в поле "Телефон" телефон
    public void fillInThePhoneNumberField(String phoneNumber) {
        driver.findElement(PHONE_ENTRY_FIELD_IN_THE_ORDER).clear();
        driver.findElement(PHONE_ENTRY_FIELD_IN_THE_ORDER).sendKeys(phoneNumber);
    }
    // Нажать на кнопку "Далее"
    public void clickOnTheNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }
    // Выбрать дату заказа
    public void selectTheOrderDate(int orderDateIdx) {
        driver.findElement(DATE_SELECTION_FIELD_IN_THE_ORDER).click();
        List<WebElement> list = driver.findElements(DATE_SELECTION);
        WebElement a = list.get(orderDateIdx);
        a.click();
    }
    // Выбрать срок аренды
    public void selectTheRentalPeriod(int rentalPeriodIdx) {
        driver.findElement(FIELD_FOR_CHOOSING_THE_RENTAL_PERIOD).click();
        List<WebElement> list = driver.findElements(CHOOSING_THE_RENTAL_PERIOD);
        WebElement b = list.get(rentalPeriodIdx);
        b.click();
    }
    // Выбрать цвет самоката
    public void chooseTheColorOfTheScooter(int colorOfTheScooterIdx) {
        driver.findElement(SCOOTER_COLOR_SELECTION_FIELD).click();
        List<WebElement> list = driver.findElements(CHOOSE_THE_COLOR_OF_THE_SCOOTER);
        WebElement c = list.get(colorOfTheScooterIdx);
        c.click();
    }
    // Оставить комментарий для курьера
    public void leaveACommentToTheCourier(String comment) {
        driver.findElement(A_COMMENT_FIELD_FOR_THE_COURIER).clear();
        driver.findElement(A_COMMENT_FIELD_FOR_THE_COURIER).sendKeys(comment);

    }
    // Нажать на кнопку "Заказать" на странице заказа
    public void clickTheOrderButtonOnTheOrderPage() {
        driver.findElement(THE_ORDER_BUTTON_ON_THE_ORDER_PAGE).click();

    }
    // Подтвердить заказ
    public void confirmTheOrder() {
        driver.findElement(ORDER_CONFIRMATION).click();

    }
    // Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа
    public boolean isSuccessfulMessageAppeared() {
        return driver.findElement(SUCCESSFUL_ORDER_MESSAGE).isDisplayed();
    }

    // Нажать на кнопку Заказать
    public void clickOrderButton(int orderButtonIdx) {
        List<WebElement> list = driver.findElements(ORDER_BUTTON_LIST);
        WebElement button = list.get(orderButtonIdx);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }
}
