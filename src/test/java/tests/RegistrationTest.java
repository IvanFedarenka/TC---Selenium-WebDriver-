package tests;

import ch.qos.logback.classic.Logger;
import com.coherent.finalTask.DataObjects.NewUser;
import com.coherent.finalTask.pages.MyAccountPage;
import com.coherent.finalTask.pages.RegistrationPage;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.EXPECTED_TITLE;
import static com.coherent.finalTask.utils.properties.PropertiesStorage.FAKE_USER_DATA;
import static io.qameta.allure.SeverityLevel.*;
import static org.testng.Assert.*;

public class RegistrationTest extends BaseTest {

    private Logger log = (Logger) LoggerFactory.getLogger(RegistrationTest.class);
    private String randomEmail;
    private NewUser newUser;

    @BeforeClass
    public void initTestData() {
        Faker faker = new Faker();
        randomEmail = faker.name().firstName() + faker.name().lastName() + "@mail.com";
        log.info("Fake user data created.");

        try {
            newUser = new Gson().fromJson(new FileReader(FAKE_USER_DATA), NewUser.class);
        } catch (FileNotFoundException e) {
            log.error("Failed reading json", e);
        }
    }

    @Test
    @Description("Testing registration functional with valid data")
    @Severity(CRITICAL)
    public void testEnterEmail() {

        RegistrationPage registrationPage = openLoginPage()
                .sentNewEmail(randomEmail)
                .clickCreationButton();
        assertTrue(registrationPage.isPageHeaderDisplayed(), "Registration page header is missing");
        log.info("Entered registration page");

        MyAccountPage accountPage = registrationPage
                .fillAllRequiredFields(newUser)
                .submitRegistration();
        log.info("Sent valid data");

        accountPage.waitTitle(15, EXPECTED_TITLE);
        assertEquals(driver.getTitle(), EXPECTED_TITLE, "Account page title doesn't matches with expected");
        assertTrue(accountPage.isWishlistDisplayed(), "Wishlist is missing on the Account page after registration");
    }
}
