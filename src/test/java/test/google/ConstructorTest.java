package test.google;

import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import po.LoginPage;
import po.MainPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
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
    public void checkJumpBetweenSections() {
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
        //проверяем, что на главной странице правильно работает переход между разделами
        mainPage.checkSections();
    }
}