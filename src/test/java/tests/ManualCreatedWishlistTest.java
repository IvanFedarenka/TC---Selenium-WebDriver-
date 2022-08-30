package tests;

import com.coherent.finalTask.pages.MyAccountPage;
import com.coherent.finalTask.pages.ProductPage;
import com.coherent.finalTask.pages.WishlistsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.EMAIL;
import static com.coherent.finalTask.utils.properties.PropertiesStorage.PASSWORD;
import static io.qameta.allure.SeverityLevel.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ManualCreatedWishlistTest extends BaseTest {

    private final String wishlistName = "My new List";

    @Test
    @Description("Testing manual wishlist creating")
    @Severity(NORMAL)
    public void testManualWishlistCreation() {
        MyAccountPage accountPage = openLoginPage()
                .sentCredentials(EMAIL, PASSWORD)
                .clickSignInButton();
        log.info("Enter account");

        WishlistsPage wishlistsPage = accountPage.goToWishlist();
        assertEquals(wishlistsPage.getAllWishlists().size(), 0, "Wishlist is not empty before test start");
        log.info("Wishlist size checked before starting");

        wishlistsPage.createWishlist(wishlistName);
        assertEquals(wishlistsPage.getAllWishlists().size(), 1, "New wishlist was not created");
        assertEquals(wishlistsPage.getWishlistName(), wishlistName, "Wrong new wishlist's name");

        ProductPage productPage = wishlistsPage
                .goToTheFirstProduct()
                .addToTheWishlist();
        log.info("Product added to the wishlist");

        String productName = productPage.getCurrentProductName();
        wishlistsPage.goToWishlist().openFirstWishlist();

        assertTrue(wishlistsPage.getWishingProductsTitle().startsWith(productName), "Wrong product's name in new wishlist");
    }

    @AfterMethod
    public void cleanUp() {
        new WishlistsPage(driver).deleteAllWishlists();
        log.info("Wishlist was cleaned after test");
    }
}
