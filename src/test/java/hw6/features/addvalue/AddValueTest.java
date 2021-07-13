package hw6.features.addvalue;

import hw6.pages.NewProjectPage;
import org.junit.jupiter.api.Test;
import hw6.base.BaseUITest;
import hw6.pages.LoginPage;
import org.openqa.selenium.Cookie;

import java.util.UUID;

import static hw6.common.Configuration.*;

public class AddValueTest extends BaseUITest {
    private static String desc = "Sample Proj " + UUID.randomUUID().toString();

    @Test
    public void addNewProjectTest() {
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl(BASE_URL);
        // Сохранить Куку
        cookie = driver.manage().getCookieNamed(COOKIE_NAME);
        // Сохраняем куку как переменную. Пусть болтается, потом придумаю как ее заюзать.
        BAPID_VALUE = cookie.getValue();

        NewProjectPage newProjScreen =  new NewProjectPage(driver);
        driver.get(BASE_URL + PROJECT_PATH);
        driver.manage().addCookie(new Cookie(COOKIE_NAME, BAPID_VALUE));

        newProjScreen
                .shortProjName(desc)
                .commentToProj(desc)
                .companyContainer()
                .companyInList()
                .contactPersonField()
                .contactPersonValue()
                .projPriority(3)
                .projFinance(2)
                .projUnit(1)
                .projCurator(1)
                .projRp(3)
        .projManager(3)
        .buttonApply()
        .checkNewExpensePopUp()
        ;

    }
}
