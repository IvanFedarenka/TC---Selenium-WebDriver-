package com.seleniumEasyTest;

import com.BaseTest;
import com.coherent.task.tableElements.TableElement;
import com.coherent.task.utils.tableParser.TableParser;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

import static com.coherent.task.locators.seleniumEasy.TableLocators.*;
import static com.coherent.task.utils.storage.PropertiesStorage.*;
import static org.testng.Assert.*;

public class TableTest extends BaseTest {

    private static final String EXPECTED_FIRST_USER_NAME = "A. Cox";
    private static final String EXPECTED_LAST_USER_NAME = "T. Nixon";
    private static final String ENTRIES_COUNT = "10";

    @BeforeMethod
    public void setEntriesCount(){
        driver.get(TABLE_BASE_URL);
        new Select(driver.findElement(SELECT_NUM_OF_ENTRIES)).selectByValue(ENTRIES_COUNT);
    }

    @Test(description = "Testing the table data")
    public void testTables() {
        int x = 30;
        int y = 400_000;

        TableParser tableParser = new TableParser(driver, driver.findElement(TABLE));
        List<TableElement> list = tableParser.collectElements(x, y);

        String firstElementName = list.get(0).getName();
        String lastElementName = list.get(list.size() - 1).getName();

        assertEquals(EXPECTED_FIRST_USER_NAME, firstElementName, "First element names not matches");
        assertEquals(EXPECTED_LAST_USER_NAME, lastElementName, "Last element names not matches");
    }
}
