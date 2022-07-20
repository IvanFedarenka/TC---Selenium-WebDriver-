package com.coherent.task.tableParser;

import com.coherent.task.tableElements.TableElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.coherent.task.seleniumEasy.locators.TableLocators.*;

public class TableParser {

    private final WebDriver driver;
    private final WebElement table;
    private List<TableElement> employeesList = new ArrayList<>();

    public TableParser(WebDriver driver, WebElement table) {
        this.driver = driver;
        this.table = table;
    }

    public void addEmployeesToList(int x, int y) {
        List<WebElement> tableRows = table.findElements(By.
                tagName("tr"));

        for (WebElement row : tableRows) {
            List<WebElement> tableCols = row.findElements(By.
                    tagName("td"));

            WebElement ageCell = tableCols.get(3);
            boolean ageIsOk = checkAge(ageCell.getText(), x);

            WebElement salaryCell = tableCols.get(5);
            boolean salaryIsOk = checkSalary(salaryCell.getText(), y);

            if (ageIsOk && salaryIsOk) {
                TableElement employee = new TableElement();
                employee.setName(tableCols.get(0).getText());
                employee.setPosition(tableCols.get(1).getText());
                employee.setOffice(tableCols.get(2).getText());
                employeesList.add(employee);
            }
        }
    }

    public List<TableElement> collectElements(int x, int y) {
        boolean hasNextPage;
        do {
            addEmployeesToList(x, y);
            hasNextPage = !driver.findElement(NEXT_BUTTON).getAttribute("Class").contains("disabled");
            driver.findElement(NEXT_BUTTON).click();
        }
        while (hasNextPage);
        return employeesList;
    }

    private boolean checkAge(String age, int x) {
        return Integer.parseInt(age) > x;
    }

    private boolean checkSalary(String salary, int y) {
        String temp = salary.replace('$', ' ')
                .replaceAll(",", "")
                .replace('/', ' ')
                .replace('y', ' ')
                .trim();
        return Integer.parseInt(temp) <= y;
    }
}
