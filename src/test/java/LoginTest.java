import com.coherent.task.driver.DriverRunner;
import com.coherent.task.pages.YandexMail.LoginPage;
import com.coherent.task.pages.YandexMail.MainPage;
import com.coherent.task.pages.YandexMail.StartPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.coherent.task.driver.DriverRunner.getInstance;
import static com.coherent.task.utils.PropertiesStorage.*;
import static org.openqa.selenium.support.PageFactory.*;
import static org.testng.Assert.*;

public class LoginTest {

    private final DriverRunner driverRunner = getInstance();
    private WebDriver driver;
    private static final String EXPECTED_PAGE_TITLE = "Authorization";

    @BeforeGroups(groups = "logIn")
    public void initDriver() {
        driver = driverRunner.getDriver();
    }

    @BeforeGroups(groups = "logOut")
    public void prepareAccount() {
        initDriver();
        initElements(driver, LoginPage.class).logIn(VALID_LOGIN, VALID_PASSWORD);
    }

    @Test(groups = "logIn",
            description = "Testing logIn functional with valid credentials")
    public void testLogin() {
        MainPage mainPage = initElements(driver, StartPage.class)
                .goToStartPage()
                .startLogin()
                .sentLogin(VALID_LOGIN)
                .sentPassword(VALID_PASSWORD);
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
        MainPage mainPage = initElements(driver, MainPage.class);
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
