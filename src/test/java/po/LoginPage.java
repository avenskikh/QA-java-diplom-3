package po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerButton;

    //локатор страницы Входа после регистрации
    @FindBy(how = How.XPATH, using = ".//*[@class='Auth_login__3hAey']")
    private SelenideElement loginPage;

    //локатор поля Email
    @FindBy(how = How.XPATH, using =  "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private SelenideElement email;

    //локатор поля Пароль
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement password;

    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    //локатор кнопки Восстановить пароль
    @FindBy(how = How.XPATH, using = "//*[text()='Восстановить пароль']")
    private SelenideElement refreshPasswordButton;

    //метод клика по кнопке Зарегистрироваться
    public RegistrationPage clickRegisterButton() {
        this.registerButton.scrollTo();
        this.registerButton.click();
        return page(RegistrationPage.class);
    }

    //метод проверки перенаправления на страницу Входа
    public RegistrationPage checkLoginPage() {
        this.loginPage.scrollTo();
        return page(RegistrationPage.class);
    }

    //метод заполнения поля ввода email
    public void setEmail(String email) {
        this.email.setValue(email);
    }

    //метод заполнения поля ввода password
    public void setPassword(String password) {
        this.password.setValue(password);
    }

    //метод клика по кнопке Войти
    public void clickLoginButton() {
        this.loginButton.scrollTo();
        this.loginButton.click();
    }

    //метод клика по кнопке Восстановить пароль
    public PasswordPage clickRefreshPasswordButton() {
        this.refreshPasswordButton.scrollTo();
        this.refreshPasswordButton.click();
        return page(PasswordPage.class);
    }

    //метод логина пользователя
    public void login( String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }
}