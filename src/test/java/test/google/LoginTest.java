package test.google;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.LoginPage;
import po.MainPage;
import po.PasswordPage;
import po.RegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    private UserOperations userOperations;
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @After
    public void deleteUser() {
        userOperations.delete();
    }

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPage() {
        //регистрация нового пользователя
        Map<String, String> credentials = userOperations.register();
        //открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        //клик по кнопке Войти в аккаунт на главной
        LoginPage loginPage = mainPage.clickEnterButton();
        //заполняем креды для входа
        loginPage.login(credentials.get("email"), credentials.get("password"));
        //проверяем, что после Входа перенаправляемся на Главную страницу
        mainPage.checkCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void loginFromPersonArea() {
        //регистрация нового пользователя
        Map<String, String> credentials = userOperations.register();
        //открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        //клик по кнопке Личный кабинет
        LoginPage loginPage = mainPage.clickPersonButton();
        //заполняем креды для входа
        loginPage.login(credentials.get("email"), credentials.get("password"));
        //проверяем, что после Входа перенаправляемся на Главную страницу
        mainPage.checkCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void loginFromRegistrationForm() {
        //регистрация нового пользователя
        Map<String, String> credentials = userOperations.register();
        //открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        //клик по кнопке Войти в аккаунт
        LoginPage loginPage = mainPage.clickEnterButton();
        //клик по кнопке Зарегистрироваться
        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        //клик по кнопке Войти, когда уже есть аккаунт
        LoginPage loginPage1 = registrationPage.clickLoginButton();
        //заполняем креды для входа
        loginPage1.login(credentials.get("email"), credentials.get("password"));
        //проверяем, что после Входа перенаправляемся на Главную страницу
        mainPage.checkCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void loginFromRefreshPasswordForm() {
        //регистрация нового пользователя
        Map<String, String> credentials = userOperations.register();
        //открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        //клик по кнопке Войти в аккаунт на главной
        LoginPage loginPage = mainPage.clickEnterButton();
        //клик по кнопке Восстановить пароль
        PasswordPage passwordPage = loginPage.clickRefreshPasswordButton();
        //клик по кнопке Войти, если вспомнили пароль
        LoginPage loginPage1 = passwordPage.clickRegisterButton();
        //заполняем креды для входа
        loginPage1.login(credentials.get("email"), credentials.get("password"));
        //проверяем, что после Входа перенаправляемся на Главную страницу
        mainPage.checkCreateOrderButton();
    }
}