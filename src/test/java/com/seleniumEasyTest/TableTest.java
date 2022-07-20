package com.seleniumEasyTest;

import com.BaseTest;
import com.coherent.task.tableElements.TableElement;
import com.coherent.task.tableParser.TableParser;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static com.coherent.task.propertyManager.PropertyManager.*;
import static com.coherent.task.seleniumEasy.locators.TableLocators.*;
import static org.testng.Assert.*;

public class TableTest extends BaseTest {

    @Test
    public void testTables() {
        int x = 30;
        int y = 400_000;

        driver.get(property("table_url"));
        new Select(driver.findElement(SELECT_NUM_OF_ENTRIES)).selectByValue("10");

        TableParser tableParser = new TableParser(driver, driver.findElement(TABLE));
        List<TableElement> list = tableParser.collectElements(x, y);
        String firstElementName = list.get(0).getName();
        String lastElementName = list.get(list.size() - 1).getName();

        assertEquals("A. Cox", firstElementName, "first element names not matches");
        assertEquals("T. Nixon", lastElementName, "last element names not matches");
    }
}
