package hw6.pages;

import hw6.base.BaseView;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import hw6.base.BaseView;


public class LoginPage extends BaseView {

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@name='_submit']")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Ввести логин {login}")
    public LoginPage enterLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }
    @Step(value = "Ввести пароль {password}")
    public LoginPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }
    @Step(value = "Click кнопка входа.")
    public HomePage clickLoginButton() {
        buttonSignIn.click();
        return new HomePage(driver);
    }

    // Для использования в других тестах
    @Step(value = "Use =+authoriseScenario+= with login = {login}, password = {password}")

    public HomePage authoriseScenario(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new HomePage(driver);
    }
}
