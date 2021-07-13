package hw6.pages;
import hw6.base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewProjectPage extends BaseView{

    // Наименование проекта.
    @FindBy(xpath = ".//input[@data-ftid='crm_project_name']")
    private WebElement shortProjName;

    // Контейнер поиска компании.
    @FindBy(xpath = ".//div[@class='company-container']/div/a/span[1]")
    private WebElement companyContainer;

    // Компания в листинге.
    @FindBy(xpath = ".//div[@id='select2-drop']/ul[2]/li[5]/div")
    private WebElement companyInList;

    // Комментарий к проекту.
    @FindBy(xpath = ".//textarea[@data-name='field__unique-description']")
    private WebElement commentToProj;

    // Выбор поля контактного лица
    @FindBy(xpath = ".//div[@class='select2-container select2']/a")
    private WebElement contactPersonField;

    // Выбор значения "Контактное лицо".
    @FindBy(xpath = ".//div[@id='select2-drop']/ul[2]/li[3]/div")
    private WebElement contactPersonValue;

    // Радиокнопки CRM proj type.
    @FindBy(xpath = ".//div[@class='controls']/div/div/label")
    private WebElement projTypeRadio;

    // Приоритет по значению.
    @FindBy(name = "crm_project[priority]")
    private WebElement projPriority;

    // Финансирование (2).
    @FindBy(name = "crm_project[financeSource]")
    private WebElement projFinance;

    // Подразделение по индексу (1). Ищем илемент по имени и проставляем индекс!
    @FindBy(name = "crm_project[businessUnit]" )
    private WebElement projUnit;

    //Куратор проекта по индексу (1). Ищем илемент по имени и проставляем индекс!
    @FindBy(name = "crm_project[curator]" )
    private WebElement projCurator;

    //Руководитель проекта по индексу (1). Ищем илемент по имени и проставляем индекс!
    @FindBy(name = "crm_project[rp]" )
    private WebElement projRp;

    //Менеджер проекта по индексу (3). Ищем илемент по имени и проставляем индекс!
    @FindBy(name = "crm_project[manager]" )
    private WebElement projManager;

    @FindBy(xpath = ".//button[@class='btn btn-success main-group action-button'][1]")
    private WebElement buttonApply;

    public NewProjectPage(WebDriver driver) { super(driver); }

    public NewProjectPage shortProjName (String description) {
        shortProjName.sendKeys(description);
        return this;
    }

    public NewProjectPage companyContainer () {
       companyContainer.click();
        return this;
    }

    public NewProjectPage companyInList() {
        companyInList.click();
        return this;
    }

    public NewProjectPage commentToProj (String description) {
        commentToProj.sendKeys(description);
        return this;
    }

    public NewProjectPage contactPersonField() {
        contactPersonField.click();
        return this;
    }

    public NewProjectPage contactPersonValue() {
        contactPersonValue.click();
        return this;
    }

    public NewProjectPage projTypeRadio() {
        projTypeRadio.click();
        return this;
    }

    public NewProjectPage projPriority(int priority) {
        Select selectProjPriority = new Select(projPriority);
        selectProjPriority.selectByValue(String.valueOf(priority));
        return this;
    }

    public NewProjectPage projFinance(int priority) {
        Select selectProjFinance = new Select(projFinance);
        selectProjFinance.selectByValue(String.valueOf(priority));
        return this;
    }

    public NewProjectPage projUnit(int index) {
        Select selectProjUnit = new Select(projUnit);
        selectProjUnit.selectByIndex(index);
        return this;
    }
    public NewProjectPage  projCurator(int index) {
        Select selectProjCurator = new Select( projCurator);
        selectProjCurator.selectByIndex(index);
        return this;
    }
    public NewProjectPage  projRp(int index) {
        Select selectProjRp = new Select( projRp);
        selectProjRp.selectByIndex(index);
        return this;
    }


    public NewProjectPage  projManager(int index) {
        Select selectProjManager = new Select(projManager);
        selectProjManager.selectByIndex(index);
        return this;
    }

    public NewProjectPage buttonApply() {
        buttonApply.click();
        return this;
    }

    // Этот метод реализован через CSS.
    public NewProjectPage checkNewExpensePopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Проект сохранен"));
        return this;
    }

}
