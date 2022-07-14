import com.Coherent.Mail.Driver.DriverRunner;
import com.Coherent.Mail.Pages.LoginPage;
import com.Coherent.Mail.Pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MailTest {

    private static final DriverRunner DRIVER_RUNNER = new DriverRunner();
    private final WebDriver driver = DRIVER_RUNNER.getDriver();
    private final LoginPage loginPage = new LoginPage(driver);
    private final MainPage mainPage = new MainPage(driver);

    @Test
    public void test1() {
        loginPage.openMainPage().login();
        DRIVER_RUNNER.getWaiter(5).until(visibilityOfAllElements(mainPage.getAllElements()));

        assertAll(
                () -> assertTrue(mainPage.getAddAccountButton().isDisplayed()),
                () -> assertTrue(mainPage.getLightVersionSwitcher().isDisplayed()),
                () -> assertTrue(mainPage.getHeaderLogo().isDisplayed()),
                () -> assertTrue(mainPage.getAllButtons().get(0).isDisplayed()),
                () -> assertTrue(mainPage.getSettingsButton().isDisplayed()),
                () -> assertTrue(mainPage.getCollapsedMenu().isDisplayed())
        );
    }

    @AfterAll
    public static void stop() {
        DRIVER_RUNNER.close();
    }
}
