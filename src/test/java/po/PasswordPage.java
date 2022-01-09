package po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PasswordPage {

    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = "//*[text()='Войти']")
    private SelenideElement loginButton;

    //метод клика по кнопке Зарегистрироваться
    public LoginPage clickRegisterButton() {
        this.loginButton.scrollTo();
        this.loginButton.click();
        return page(LoginPage.class);
    }


}
