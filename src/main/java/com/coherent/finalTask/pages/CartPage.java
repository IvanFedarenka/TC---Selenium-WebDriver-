package com.coherent.finalTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Double.*;
import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.By.*;

public class CartPage extends BasePage {

    private static final By PRODUCT_NAMES = cssSelector("table p.product-name>a");
    private static final By TOTAL_PRICE = cssSelector("td#total_product");
    private static final By ADDED_PRODUCTS = cssSelector("tbody>tr");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNamesFromCart() {
        return driver.findElements(PRODUCT_NAMES).stream()
                .map(WebElement::getText).collect(toList());
    }

    public int getCartSize() {
        return driver.findElements(ADDED_PRODUCTS).size();
    }

    public double getTotalPrice() {
        return parseDouble(driver.findElement(TOTAL_PRICE).getText().replace('$', ' ').trim());
    }
}
