package com.seleniumEasyTest;

import com.BaseTest;
import com.coherent.task.propertyManager.PropertyManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.coherent.task.seleniumEasy.locators.RandomUserLocator.*;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class RandomUserTest extends BaseTest {

    @Test
    public void testRandomUserLoad(){
        driver.get(PropertyManager.property("random_user_url"));
        driver.findElement(GET_USER_BUTTON).click();
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));
        WebElement usersPlace = driver.findElement(USERS_PLACE);
        wait.until(not(textToBePresentInElement(usersPlace, "loading...")));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(usersPlace.getText().contains("First Name :"));
        softAssert.assertTrue(usersPlace.getText().contains("Last Name :"));
        softAssert.assertAll();
    }
}
