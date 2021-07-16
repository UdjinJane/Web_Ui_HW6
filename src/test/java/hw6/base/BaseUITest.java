package hw6.base;

import hw6.pages.HomePage;
import hw6.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import hw6.listener.CustomLogger;

import java.util.concurrent.TimeUnit;

import static hw6.common.Configuration.BASE_URL;
import static hw6.common.Configuration.LOGIN_PATH;
import static hw6.common.Configuration.BAPID_VALUE;
import  static hw6.common.Configuration.cookie;
import  static hw6.common.Configuration.COOKIE_NAME;



public abstract class BaseUITest {

    protected WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        //стенд тормозит, лучше использовать стратегию NORMAL
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_PATH);

    }

    @AfterEach

    public void tearDown() {

        driver.quit();
    }
}