package com.coherent.finalTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.coherent.finalTask.utils.properties.PropertiesStorage.WISHLIST_URL;
import static org.openqa.selenium.By.*;

public class WishlistsPage extends BasePage {

    private static final By WISHLISTS = xpath("//div[@id='block-history']//tbody/tr");
    private static final By FIRST_PRODUCT_IN_RECOMMENDED = xpath("//li[@class='clearfix']/a");
    private static final By FIRST_WISHLIST = xpath("//div[@id='block-history']//tbody/tr/td[1]/a");
    private static final By WISH_PRODUCT_TITLE = xpath("//div[@class='product_infos']/p[@id='s_title']");
    private static final By DELETE_WISHLIST_BUTTON = xpath("//tr/td[last()]/a");
    private static final By WISHLIST_NAME = xpath("//tr/td/a");
    private static final By WISHLIST_NAME_INPUT = cssSelector("#name");
    private static final By SUBMIT_BUTTON = cssSelector("#submitWishlist");

    public WishlistsPage(WebDriver driver) {
        super(driver);
    }

    public WishlistsPage goToWishlist() {
        driver.get(WISHLIST_URL);
        return this;
    }

    public List<WebElement> getAllWishlists() {
        return driver.findElements(WISHLISTS);
    }

    public ProductPage goToTheFirstProduct() {
        driver.findElement(FIRST_PRODUCT_IN_RECOMMENDED).click();
        return new ProductPage(driver);
    }

    public WishlistsPage openFirstWishlist() {
        driver.findElement(FIRST_WISHLIST).click();
        return this;
    }

    public String getWishingProductsTitle() {
        return waitVisibilityOf(15, driver.findElement(WISH_PRODUCT_TITLE)).getText();
    }

    public void deleteAllWishlists() {
        List<WebElement> elements = driver.findElements(DELETE_WISHLIST_BUTTON);
        for (WebElement el : elements) {
            el.click();
            driver.switchTo().alert().accept();
        }
    }

    public void createWishlist(String name) {
        driver.findElement(WISHLIST_NAME_INPUT).sendKeys(name);
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getWishlistName() {
        return driver.findElement(WISHLIST_NAME).getText();
    }
}
