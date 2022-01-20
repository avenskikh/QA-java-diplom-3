package po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    //локатор кнопки Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement enterButton;

    //локатор кнопки Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    //локатор кнопки Личный кабинет
    @FindBy(how = How.XPATH, using = "//*[text()='Личный Кабинет']")
    private SelenideElement personButton;

    //локатор кнопки Начинки
    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement stuffingButton;

    //локатор раздела Начинки
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement stuffingSection;

    //локатор кнопки Соусы
    @FindBy(how = How.XPATH, using = "//*[text()='Соусы']")
    private SelenideElement saucesButton;

    //локатор раздела Соусы
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']")
    private SelenideElement saucesSection;

    //локатор кнопки Булки
    @FindBy(how = How.XPATH, using = ".//*[//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]/span]")
    private SelenideElement breadsButton;

    //локатор раздела Булки
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement breadsSection;

    @Step
    //метод клика по кнопке Войти в аккаунт
    public LoginPage clickEnterButton() {
        enterButton.scrollTo();
        enterButton.click();
        return page(LoginPage.class);
    }

    @Step
    //метод клика по кнопке Личный кабинет незалогиненного пользователя
    public LoginPage clickPersonButton() {
        personButton.scrollTo();
        personButton.click();
        return page(LoginPage.class);
    }

    @Step
    //метод клика по кнопке Личный кабинет залогиненного пользователя
    public ProfilePage clickProfileButton() {
        personButton.scrollTo();
        personButton.click();
        return page(ProfilePage.class);
    }

    @Step
    //метод проверки наличия кнопки Оформить заказ
    public LoginPage checkCreateOrderButton() {
        this.createOrderButton.scrollTo();
        return page(LoginPage.class);
    }

    @Step
    //метод клика по кнопке Начинки
    public void clickStuffingButton() {
        stuffingButton.scrollTo();
        stuffingButton.click();
    }

    @Step
    //метод проверки корректности отображения раздела Начинки
    public void checkStuffingSectionText() {
        stuffingSection.shouldHave(exactText("Начинки"));
    }

    @Step
    //метод клика по кнопке Соусы
    public void clickSaucesButton() {
        saucesButton.scrollTo();
        saucesButton.click();
    }

    @Step
    //метод проверки корректности отображения раздела Соусы
    public void checkSaucesSectionText() {
        saucesSection.shouldHave(exactText("Соусы"));
    }

    @Step
    //метод клика по кнопке Булки
    public void clickBreadsButton() {
        breadsButton.scrollTo();
        breadsButton.click();
    }

    @Step
    //метод проверки корректности отображения раздела Булки
    public void checkBreadsSectionText() {
        breadsSection.shouldHave(exactText("Булки"));
    }

    @Step
    //метод проверки перехода между разделами
    public void checkSections() {
        clickStuffingButton();
        checkStuffingSectionText();
        clickSaucesButton();
        checkSaucesSectionText();
        clickBreadsButton();
        checkBreadsSectionText();
    }
}

