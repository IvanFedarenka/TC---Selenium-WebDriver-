package tests;

import com.coherent.task.pages.YandexMail.LoginPage;
import com.coherent.task.pages.YandexMail.MainPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.coherent.task.utils.properties.PropertiesStorage.*;
import static io.qameta.allure.SeverityLevel.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Feature("Account enter / exit functional")
public class LoginTest extends BaseTest {

    private static final String INCORRECT_PAGE_TITLE = "NEAuthorization";

    @Test
    @Description("SHOULD PASS, DATA IS CORRECT")
    @TmsLink("1L")
    @Severity(CRITICAL)
    public void testLogin() {
        LoginPage loginPage = openStartPage().startLogin();
        assertTrue(loginPage.isForgotLoginLinkPresented(), "Link 'I forgot login' is missing");
        log.info(" -first assert passed");

        loginPage.sentLogin(VALID_LOGIN);
        assertTrue(loginPage.isForgotPasswordLinkPresented(), "Link 'I forgot password' is missing");
        log.info(" -second assert passed");

        MainPage mainPage = loginPage.sentPassword(VALID_PASSWORD);
        mainPage.waitVisibilityOfAccountName();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.isAccountNameDisplayed(), "Account name on the main page is missing");
        softAssert.assertTrue(mainPage.isSettingsButtonDisplayed(), "Settings button on the main page is missing");
        softAssert.assertTrue(mainPage.isAccountIconDisplayed(), "Account icon on the main page is missing");
        softAssert.assertAll();
    }

    @Test
    @Description("SHOULD FAIL, INCORRECT DATA")
    @TmsLink("2L")
    @Severity(NORMAL)
    public void testLogout() {
        MainPage mainPage = openStartPage()
                .startLogin()
                .sentLogin(VALID_LOGIN)
                .sentPassword(VALID_PASSWORD);

        assertTrue(mainPage.isSettingsButtonDisplayed(), "Settings button on the main page is missing");
        assertTrue(mainPage.isAccountIconDisplayed(), "Account icon on the main page is missing");

        mainPage.waitVisibilityOfAccountName();
        mainPage.clickAccountName()
                .clickLogoutButton();

        assertEquals(INCORRECT_PAGE_TITLE, mainPage.getPageTitle(), "Test logout fail");
    }
}
