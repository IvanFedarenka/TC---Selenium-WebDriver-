package com.coherent.finalTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class MyAccountPage extends BasePage {

    private static final By WISHLIST_BUTTON = xpath("//span[text()='My wishlists']");
    private static final By TO_WOMEN_LINK = xpath("//a[text()='Women']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWishlistDisplayed() {
        return waitVisibilityOf(15, driver.findElement(WISHLIST_BUTTON)).isDisplayed();
    }

    public WishlistsPage goToWishlist() {
        waitVisibilityOf(10, driver.findElement(WISHLIST_BUTTON)).click();
        return new WishlistsPage(driver);
    }

    public CatalogPage goToCatalog() {
        waitVisibilityOf(10, driver.findElement(TO_WOMEN_LINK)).click();
        return new CatalogPage(driver);
    }
}
