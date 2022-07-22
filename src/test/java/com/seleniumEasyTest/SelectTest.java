package com.seleniumEasyTest;

import com.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

import static com.coherent.task.locators.seleniumEasy.SelectLocators.*;
import static com.coherent.task.utils.storage.PropertiesStorage.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.*;

public class SelectTest extends BaseTest {

    @Test(description = "Testing multiselect functional. First of all checking is the list is multiple" +
                        "then, choosing three random elements and ensure they where selected")
    public void testMultiSelectList() {
        driver.get(SELECT_BASE_URL);
        Select select = new Select(driver.findElement(MULTI_SELECT_LIST));
        assertTrue(select.isMultiple(), "List isn't multiple");

        List<WebElement> rowElements = driver.findElements(LIST_ELEMENTS);
        Integer[] randomIndexes = getThreeRandomIndexes(rowElements.size());

        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL)
                .click(rowElements.get(randomIndexes[0]))
                .click(rowElements.get(randomIndexes[1]))
                .click(rowElements.get(randomIndexes[2]))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        driver.findElement(PRINT_ALL_BUTTON).click();
        driverManager.getWaiter(2).until(visibilityOf(driver.findElement(SELECTED_ITEMS_LINE)));
        String resultLine = driver.findElement(SELECTED_ITEMS_LINE).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(3, select.getAllSelectedOptions().size(), "Wrong number of selected elements");
        softAssert.assertTrue(resultLine.contains(select.getAllSelectedOptions().get(0).getText()), "Result line doesn't contain selected item #1");
        softAssert.assertTrue(resultLine.contains(select.getAllSelectedOptions().get(1).getText()), "Result line doesn't contain selected item #2");
        softAssert.assertTrue(resultLine.contains(select.getAllSelectedOptions().get(2).getText()), "Result line doesn't contain selected item #3");
        softAssert.assertAll();
    }

    private Integer[] getThreeRandomIndexes(int max) {
        Set<Integer> set = new HashSet<>();
        while (set.size() != 3) {
            set.add(new Random().nextInt(0, max));
        }
        return set.toArray(new Integer[3]);
    }
}
