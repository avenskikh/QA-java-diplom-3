package po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    //локатор кнопки Выход
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Выход')]")
    private SelenideElement exitButton;

    //локатор кнопки Конструктор
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;

    //локатор кнопки логотипа
    @FindBy(how = How.XPATH, using = ".//*[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logo;

    //метод клика по кнопке Выход
    public MainPage clickExitButton() {
        this.exitButton.scrollTo();
        this.exitButton.click();
        return page(MainPage.class);
    }

    //метод клика по кнопке Конструктор
    public MainPage clickConstructorButton() {
        this.constructorButton.scrollTo();
        this.constructorButton.click();
        return page(MainPage.class);
    }

    //метод клика по логотипу
    public MainPage clickLogo() {
        this.logo.scrollTo();
        this.logo.click();
        return page(MainPage.class);
    }
}
