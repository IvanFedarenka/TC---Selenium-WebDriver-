package com.seleniumEasyTest;

import com.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.coherent.task.locators.seleniumEasy.RandomUserLocator.*;
import static com.coherent.task.utils.storage.PropertiesStorage.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class RandomUserTest extends BaseTest {

    @Test(description = "Testing data loading, using explicit waiter")
    public void testRandomUserLoad(){
        driver.get(RANDOM_USER_BASE_URL);
        driver.findElement(GET_USER_BUTTON).click();
        WebElement usersPlace = driver.findElement(USERS_PLACE);
        driverManager.getWaiter(20).until(not(textToBePresentInElement(usersPlace, "loading...")));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(usersPlace.getText().contains("First Name :"), "user's first name is missing");
        softAssert.assertTrue(usersPlace.getText().contains("Last Name :"), "user's last name is missing");
        softAssert.assertAll();
    }
}
