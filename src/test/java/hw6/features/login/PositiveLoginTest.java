package hw6.features.login;

import hw6.pages.HomePage;
import org.junit.jupiter.api.Test;
import hw6.base.BaseUITest;
import hw6.pages.LoginPage;

import static hw6.common.Configuration.BASE_URL;
import static hw6.common.Configuration.STUDENT_LOGIN;
import static hw6.common.Configuration.STUDENT_PASSWORD;

public class PositiveLoginTest extends BaseUITest {

    @Test
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl(BASE_URL);

    }
}