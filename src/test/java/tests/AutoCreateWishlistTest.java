package tests;

import com.coherent.finalTask.pages.MyAccountPage;
import com.coherent.finalTask.pages.ProductPage;
import com.coherent.finalTask.pages.WishlistsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.*;
import static io.qameta.allure.SeverityLevel.*;
import static org.testng.Assert.*;

public class AutoCreateWishlistTest extends BaseTest {

    @Test
    @Description("Testing auto creation of wishlist")
    @Severity(NORMAL)
    public void testNewWishlistCreation() {
        MyAccountPage accountPage = openLoginPage()
                .sentCredentials(WISHLIST_LOGIN, WISHLIST_PASSWORD)
                .clickSignInButton();
        log.info("Enter account");

        WishlistsPage wishlistsPage = accountPage
                .goToWishlist();
        assertEquals(wishlistsPage.getAllWishlists().size(), 0, "Wishlist should be empty before starting test");
        log.info("Wishlist size checked before starting");

        ProductPage productPage = wishlistsPage
                .goToTheFirstProduct()
                .addToTheWishlist();
        log.info("Product added to the wishlist");

        String productName = productPage.getCurrentProductName();
        wishlistsPage.goToWishlist().openFirstWishlist();

        assertEquals(wishlistsPage.getAllWishlists().size(), 1, "New wishlist was not created");
        assertTrue(wishlistsPage.getWishingProductsTitle().startsWith(productName), "Wrong product's name in new wishlist");
    }

    @AfterMethod
    public void cleanUp() {
        new WishlistsPage(driver).deleteAllWishlists();
        log.info("Wishlist was cleaned after test");
    }
}
