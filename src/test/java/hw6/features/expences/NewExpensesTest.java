package hw6.features.expences;

import org.junit.jupiter.api.Test;
import hw6.base.BaseUITest;
import hw6.common.Configuration;
import hw6.enums.ExpenseSubMenuButtons;
import hw6.enums.NavigationBarTabs;
import hw6.pages.AllExpensesPage;
import hw6.pages.LoginPage;

public class NewExpensesTest extends BaseUITest {

    private static final int EXPENSE_SUM = 10000;

    @Test
    public void createNewExpensePositiveTest() {
        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        expensesScreen
                .clickOnCreateNewExpenseButton()
                .enterDescription("test 1234")
                .selectBusinessUnit(1)
                .selectExpenditure(87)
                .setExpenseSum(EXPENSE_SUM)
                .clickNotifyDateChangedCheckBox()
                .selectDateInDatePicker(20)
                .clickSubmit()
                .checkNewExpensePopUp();
    }
}