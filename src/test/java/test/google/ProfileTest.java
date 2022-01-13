package test.google;

import com.UserOperations;
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

    @After
    public void deleteUser() {
        new UserOperations().delete();
    }

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @Test
    public void exitFromProfile() {
        //регистрация нового пользователя
        Map<String, String> credentials = userOperations.register();
        //открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site",
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
    public void goToMainPageFromConstructor() {
        //регистрация нового пользователя
        Map<String, String> credentials = userOperations.register();
        //открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site",
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
    public void goToMainPageFromLogo() {
        //регистрация нового пользователя
        Map<String, String> credentials = userOperations.register();
        //открывается страница и создаётся экземпляр класса страницы
        MainPage mainPage =
                open("https://stellarburgers.nomoreparties.site",
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
