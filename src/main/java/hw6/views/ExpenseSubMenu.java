package hw6.views;
import org.openqa.selenium.WebDriver;
import hw6.base.BaseView;
import hw6.base.SubMenu;
import hw6.base.SubMenuButtons;
import hw6.enums.ExpenseSubMenuButtons;
import hw6.pages.AllExpensesPage;

public class ExpenseSubMenu extends SubMenu {

    public ExpenseSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ExpenseSubMenuButtons) {
            switch ((ExpenseSubMenuButtons) buttons) {
                case EXPENSE_REQUEST:
                    driver.findElement(((ExpenseSubMenuButtons) buttons).getBy()).click();
                    return new AllExpensesPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}
