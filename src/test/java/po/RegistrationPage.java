package po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    //локатор поля имя
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement nameField;
    //локатор поля Email
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;
    //локатор поля пароль
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")
    private SelenideElement passwordField;
    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registrationButton;
    //локатор ошибки Некорректный пароль
    @FindBy(how = How.XPATH, using = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement textError;
    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement loginButton;

    @Step
    //метод заполнения поля ввода имени
    public void setName(String name) {
        this.nameField.setValue(name);
    }

    @Step
    //метод заполнения поля ввода email
    public void setEmail(String email) {
        this.emailField.setValue(email);
    }

    @Step
    //метод заполнения поля ввода password
    public void setPassword(String password) {
        this.passwordField.setValue(password);
    }

    @Step
    //метод клика по кнопке Зарегистрироваться
    public void clickRegistrationButton() {
        registrationButton.scrollTo();
        registrationButton.click();
    }

    @Step
    //метод клика по кнопке Войти
    public LoginPage clickLoginButton() {
        loginButton.scrollTo();
        loginButton.click();
        return page(LoginPage.class);
    }

    @Step
    //метод регистрации пользователя
    public void registration(String name, String password, String email) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }

    @Step
    //метод проверки текста ошибки
    public void checkErrorText(String text) {
        textError.shouldHave(exactText(text));
    }
}