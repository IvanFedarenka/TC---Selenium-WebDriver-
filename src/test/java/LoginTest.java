import com.coherent.task.driver.DriverRunner;
import com.coherent.task.pages.YandexMail.LoginPage;
import com.coherent.task.pages.YandexMail.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.coherent.task.driver.DriverRunner.*;
import static com.coherent.task.utils.properties.PropertiesStorage.*;
import static org.testng.Assert.assertEquals;

public class LoginTest {

    private DriverRunner driverRunner = getInstance();
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private static final String PAGE_TITLE = "Authorization";

    @BeforeGroups(groups = {"login"})
    public void initDriver() {
        driver = driverRunner.getDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @BeforeGroups(groups = {"logout"})
    public void prepareAccount() {
        initDriver();
        loginPage.goTo().logIn(VALID_LOGIN, VALID_PASSWORD);
    }

    @Test(groups = {"login"})
    public void testLogin() {
        loginPage.goTo()
                .sentLogin(VALID_LOGIN)
                .sentPassword(VALID_PASSWORD);
        driverRunner.getWaiter(5).until(ExpectedConditions.visibilityOf(mainPage.getAccountName()));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mainPage.getAccountName().isDisplayed(), "Account name on the main page is missing");
        softAssert.assertTrue(mainPage.getSettingsButton().isDisplayed(), "Settings button on the main page is missing");
        softAssert.assertTrue(mainPage.getAccountIcon().isDisplayed(), "Account icon on the main page is missing");
        softAssert.assertAll();
    }

    @Test(groups = "logout")
    public void testLogout() {
        mainPage.getAccountName().click();
        mainPage.getLogoutButton().click();

        assertEquals(PAGE_TITLE, driver.getTitle(), "Test logout fail");
    }

    @AfterMethod
    public void close() {
        driverRunner.close();
    }
}
