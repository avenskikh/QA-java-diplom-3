package test.yandex;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import po.LoginPage;
import po.MainPage;
import po.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {
    String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
    String password = RandomStringUtils.randomAlphabetic(10);
    String name = RandomStringUtils.randomAlphabetic(10);
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Test
    public void registration() {
        System.setProperty("webdriver.chrome.driver", "C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe");
        //открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        //клик по кнопке Войти в аккаунт
        LoginPage loginPage = mainPage.clickEnterButton();
        //клик по кнопке Зарегистрироваться
        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        //заполняем информацию по регистрации нового пользователя
        registrationPage.registration(name, password, email);
        //проверяем, что перенапривились на страницу Входа
        loginPage.checkLoginPage();
    }

    @Test
    public void registrationWithIncorrectPass() {
        System.setProperty("webdriver.chrome.driver", "C:/yandexdriver-22.1.0.2410-win/yandexdriver.exe");
        //открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage =
                open(BASE_URL,
                        MainPage.class);
        //клик по кнопке Войти в аккаунт
        LoginPage loginPage = mainPage.clickEnterButton();
        //клик по кнопке Зарегистрироваться
        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        //заполняем информацию по регистрации нового пользователя
        registrationPage.registration(name, "23454", email);
        registrationPage.checkErrorText("Некорректный пароль");
    }
}