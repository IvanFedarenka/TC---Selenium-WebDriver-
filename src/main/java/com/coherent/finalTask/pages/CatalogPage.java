package com.coherent.finalTask.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.*;
import static org.openqa.selenium.By.*;

public class CatalogPage extends BasePage {

    private static final By CONTINUE_BUTTON = cssSelector("span.continue");
    private static final By PRODUCT = cssSelector("li.ajax_block_product");
    private static final By CART = xpath("//a[@title='View my shopping cart']");
    private static final By PRODUCT_NAME = cssSelector("a.product-name");
    private List<String> names = new ArrayList<>();
    private double totalPrice;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public CatalogPage addFirstThreeGoodsInCart() {
        List<WebElement> products = driver.findElements(PRODUCT).stream().limit(3).toList();

        for (WebElement product : products) {
            driver.findElement(By.cssSelector("i.icon-th-list")).click();

            String productName = product.findElement(PRODUCT_NAME).getText();
            names.add(productName);
            totalPrice += parseDouble(driver.findElement(xpath("//a[@title='" + productName + "']/../../following-sibling::div//span[@itemprop='price']")).getText().replace('$', ' ').trim());
            driver.findElement(xpath("//a[@title='" + productName + "']/../../following-sibling::div//a[@title='Add to cart']")).click();

            waitVisibilityOf(10, driver.findElement(CONTINUE_BUTTON)).click();
        }
        return this;
    }

    public CartPage goToCart() {
        driver.findElement(CART).click();
        return new CartPage(driver);
    }

    public List<String> getNames() {
        return names;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
