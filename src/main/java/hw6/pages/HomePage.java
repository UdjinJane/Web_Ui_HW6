package hw6.pages;

import hw6.base.BaseView;
import org.openqa.selenium.WebDriver;

import hw6.views.NavigationBar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BaseView {

    private NavigationBar navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public void checkUrl(String url) {
        assertEquals(driver.getCurrentUrl(), url);
    }

    public NavigationBar getPageNavigation() {
        return navigationBar;
    }
}

