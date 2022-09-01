package com.coherent.finalTask.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.*;
import static java.lang.String.*;
import static org.openqa.selenium.By.*;

public class CatalogPage extends BasePage {

    private static final By CONTINUE_BUTTON = cssSelector("span.continue");
    private static final By PRODUCT = cssSelector("li.ajax_block_product");
    private static final By CART = xpath("//a[@title='View my shopping cart']");
    private static final By PRODUCT_NAME = cssSelector("a.product-name");
    private static final By SWITCHER = cssSelector("i.icon-th-list");
    private static final String PRICE = "//a[@title='%s']/../../following-sibling::div//span[@itemprop='price']";
    private static final String ADD_BUTTON = "//a[@title='%s']/../../following-sibling::div//a[@title='Add to cart']";

    private double totalPrice;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public List<String> getFirstThreeGoodsInCart() {
        List<WebElement> products = driver.findElements(PRODUCT).stream().limit(3).toList();
        List<String> names = new ArrayList<>();
        for (WebElement product : products) {
            driver.findElement(SWITCHER).click();

            String productName = product.findElement(PRODUCT_NAME).getText();
            names.add(productName);
            totalPrice += parseDouble(driver.findElement(xpath(format(PRICE, productName))).getText().replace('$', ' ').trim());
            driver.findElement(xpath(format(ADD_BUTTON, productName))).click();

            waitVisibilityOf(10, driver.findElement(CONTINUE_BUTTON)).click();
        }
        return names;
    }

    public CartPage goToCart() {
        driver.findElement(CART).click();
        return new CartPage(driver);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
