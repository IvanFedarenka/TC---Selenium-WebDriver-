package com.coherent.task.utils.tableParser;

import com.coherent.task.tableElements.TableElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.coherent.task.locators.seleniumEasy.TableLocators.*;

public class TableParser {

    private final WebDriver driver;
    private final WebElement table;
    private List<TableElement> employeesList = new ArrayList<>();

    public TableParser(WebDriver driver, WebElement table) {
        this.driver = driver;
        this.table = table;
    }

    public void addEmployeesToList(int x, int y) {
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));

        List<TableElement> tableElements = tableRows.stream()
                .map(r -> r.findElements(By.tagName("td")))
                .filter(we -> (isAgeValid(we.get(3).getText(), x)))
                .filter(we -> isSalaryValid(we.get(5).getText(), y))
                .map(we -> new TableElement(we.get(0).getText(), we.get(1).getText(), we.get(2).getText()))
                .toList();

        employeesList.addAll(tableElements);
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

    private boolean isAgeValid(String age, int x) {
        return Integer.parseInt(age) > x;
    }

    private boolean isSalaryValid(String salary, int y) {
        String temp = salary.replace('$', ' ')
                .replaceAll(",", "")
                .replace('/', ' ')
                .replace('y', ' ')
                .trim();
        return Integer.parseInt(temp) <= y;
    }
}
