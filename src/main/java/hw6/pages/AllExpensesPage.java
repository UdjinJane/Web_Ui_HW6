package hw6.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import hw6.base.BaseView;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllExpensesPage extends BaseView {

    @FindBy(css = "div[class='pull-left btn-group icons-holder']")
    private WebElement createNewExpenseButton;

    public AllExpensesPage(WebDriver driver) {
        super(driver);
    }

    public NewExpensePage clickOnCreateNewExpenseButton() {
        createNewExpenseButton.click();
        return new NewExpensePage(driver);
    }

    public AllExpensesPage checkNewExpensePopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Заявка на расход сохранена"));
        return this;
    }

}