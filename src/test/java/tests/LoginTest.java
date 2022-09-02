package tests;

import com.coherent.finalTask.pages.MyAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.*;
import static io.qameta.allure.SeverityLevel.*;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @Description("Testing login process with valid credentials")
    @Severity(CRITICAL)
    public void testLogin() {
        MyAccountPage accountPage = openLoginPage()
                .sentCredentials(EMAIL, PASSWORD)
                .clickSignInButton();

        new WebDriverWait(driver, ofSeconds(15)).until(titleIs(EXPECTED_TITLE));
        assertEquals(driver.getTitle(), EXPECTED_TITLE, "Page's title is wrong after login");
        assertTrue(accountPage.isWishlistDisplayed(), "Wishlist is missing on the account page");
    }
}
