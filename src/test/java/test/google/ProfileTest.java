package test.google;

import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.LoginPage;
import po.MainPage;
import po.ProfilePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class ProfileTest {
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
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void exitFromProfile() {
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
        //клик по кнопке Личный кабинет
        ProfilePage profilePage = mainPage.clickProfileButton();
        //клик по кнопке Выход
        profilePage.clickExitButton();
        //проверяем, что перенаправились на страницу входа
        loginPage.checkLoginPage();
    }

    @Test
    @DisplayName("Проверка перехода на главную страницу по клику на «Конструктор»")
    public void goToMainPageFromConstructor() {
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
        //клик по кнопке Личный кабинет
        ProfilePage profilePage = mainPage.clickProfileButton();
        //клик по кнопке Конструктор
        profilePage.clickConstructorButton();
        //проверяем, что перенаправились на главную страницу
        mainPage.checkCreateOrderButton();
    }

    @Test
    @DisplayName("Проверка перехода на главную страницу по клику на логотип Stellar Burgers")
    public void goToMainPageFromLogo() {
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
        //клик по кнопке Личный кабинет
        ProfilePage profilePage = mainPage.clickProfileButton();
        //клик по логотипу
        profilePage.clickLogo();
        //проверяем, что перенаправились на главную страницу
        mainPage.checkCreateOrderButton();
    }
}