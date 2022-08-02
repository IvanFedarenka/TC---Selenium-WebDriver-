
import com.coherent.task.pages.YandexMail.LoginPage;
import com.coherent.task.pages.YandexMail.MainPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.coherent.task.utils.properties.PropertiesStorage.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private static final String EXPECTED_PAGE_TITLE = "Authorization";

    @Test(groups = "logIn",
            description = "Testing logIn functional with valid credentials")
    public void testLogin() {
        LoginPage loginPage = startPage.startLogin();
        assertTrue(loginPage.isForgotLoginLinkPresented(), "Link 'I forgot login' is missing");

        loginPage.sentLogin(VALID_LOGIN);
        assertTrue(loginPage.isForgotPasswordLinkPresented(), "Link 'I forgot password' is missing");

        MainPage mainPage = loginPage.sentPassword(VALID_PASSWORD);
        mainPage.waitVisibilityOfAccountName();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.isAccountNameDisplayed(), "Account name on the main page is missing");
        softAssert.assertTrue(mainPage.isSettingsButtonDisplayed(), "Settings button on the main page is missing");
        softAssert.assertTrue(mainPage.isAccountIconDisplayed(), "Account icon on the main page is missing");
        softAssert.assertAll();
    }

    @Test(groups = "logOut",
            description = "Testing leaving current account functional")
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

        assertEquals(EXPECTED_PAGE_TITLE, mainPage.getPageTitle(), "Test logout fail");
    }

    @AfterMethod
    public void close() {
        driverRunner.close();
    }
}
