package tests;

import com.coherent.finalTask.pages.CartPage;
import com.coherent.finalTask.pages.CatalogPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.testng.annotations.Test;

import java.util.List;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.EMAIL;
import static com.coherent.finalTask.utils.properties.PropertiesStorage.PASSWORD;
import static io.qameta.allure.SeverityLevel.*;
import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test
    @Description("Testing add to cart functional with 3 products")
    @Severity(NORMAL)
    public void testCart() {
        CatalogPage catalogPage = openLoginPage()
                .sentCredentials(EMAIL, PASSWORD)
                .clickSignInButton().goToCatalog();
        log.info("Entered account");

        catalogPage.addFirstThreeGoodsInCart();
        List<String> productNames = catalogPage.getNames();
        double total = catalogPage.getTotalPrice();
        log.info("Products added to the cart. Total price expected: " + total);
        CartPage cartPage = catalogPage.goToCart();

        assertEquals(cartPage.getCartSize(), 3, "Wrong cart size");
        assertEquals(cartPage.getNamesFromCart(), productNames, "Wrong product's names");
        assertEquals(cartPage.getTotalPrice(), total, "Wrong total price statement");
    }
}
