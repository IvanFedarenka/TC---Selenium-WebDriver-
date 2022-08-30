package com.coherent.finalTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class ProductPage extends BasePage {

    private static final By ADD_TO_THE_WISHLIST_BUTTON = cssSelector("a#wishlist_button");
    private static final By PRODUCT_NAME = xpath("//h1[@itemprop='name']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addToTheWishlist() {
        driver.findElement(ADD_TO_THE_WISHLIST_BUTTON).click();
        return this;
    }

    public String getCurrentProductName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }
}
