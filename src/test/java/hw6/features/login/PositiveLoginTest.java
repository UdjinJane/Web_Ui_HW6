package hw6.features.login;


import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import hw6.base.BaseUITest;
import hw6.pages.HomePage;
import hw6.pages.LoginPage;
import hw6.helpers.ScreenshotMaker;
import org.openqa.selenium.Cookie;

import static hw6.common.Configuration.*;


@Feature("Login")
@Severity(SeverityLevel.BLOCKER) // Приоритезация.

public class PositiveLoginTest extends BaseUITest {



    @Test
    @Description("Логин сущесвующим пользователем")
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl(BASE_URL);
        cookie = driver.manage().getCookieNamed(COOKIE_NAME);
        BAPID_VALUE = cookie.getValue();
        System.out.println("SAVED cn " + COOKIE_NAME + " BPV " + BAPID_VALUE);
    }
    @Test
    @Description("Логин с помощью cookie")
    public void loginWithCookieTest() {
        driver.get(BASE_URL);
        System.out.println("SET cn " + COOKIE_NAME + " BPV " + BAPID_VALUE);
        driver
                .manage()
                .addCookie(new Cookie(COOKIE_NAME, "c0e70e37868a035a3f7f4e9e1e3d8426"));

        driver.get(BASE_URL);

        new HomePage(driver)
                .checkUrl(BASE_URL);
    }

}
