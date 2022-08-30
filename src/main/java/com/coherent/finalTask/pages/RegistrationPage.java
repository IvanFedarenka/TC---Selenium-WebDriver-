package com.coherent.finalTask.pages;

import com.coherent.finalTask.DataObjects.NewUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class RegistrationPage extends BasePage {

    private static final By MALE_GENDER_SELECTOR = cssSelector("#uniform-id_gender1");
    private static final By FIRST_NAME_INPUT = xpath("//label[@for='customer_firstname']/following-sibling::input");
    private static final By ADDRESS_FIRST_NAME_INPUT = xpath("//label[@for='customer_firstname']/following-sibling::input");
    private static final By ADDRESS_LAST_NAME_INPUT = xpath("//label[@for='customer_lastname']/following-sibling::input");
    private static final By LAST_NAME_INPUT = xpath("//label[@for='customer_lastname']/following-sibling::input");
    private static final By PASSWORD_INPUT = xpath("//label[@for='passwd']/following-sibling::input");
    private static final By ADDRESS_FIRST = xpath("//label[@for='address1']/following-sibling::input");
    private static final By CITY_INPUT = xpath("//label[@for='city']/following-sibling::input");
    private static final By POSTCODE_INPUT = xpath("//label[@for='postcode']/following-sibling::input");
    private static final By MOBILE_PHONE_NUMBER_INPUT = xpath("//label[@for='phone_mobile']/following-sibling::input");
    private static final By ALIAS_ADDRESS = xpath("//label[@for='alias']/following-sibling::input");
    private static final By SELECT_STATE = cssSelector("select#id_state");
    private static final By PAGE_HEADER = xpath("//h1[text()='Create an account']");
    private static final By SUBMIT = cssSelector("button#submitAccount");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage clickMaleRadioButton() {
        driver.findElement(MALE_GENDER_SELECTOR).click();
        return this;
    }

    public RegistrationPage sentFirstName(String str) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(str);
        driver.findElement(ADDRESS_FIRST_NAME_INPUT).sendKeys(str);
        return this;
    }

    public RegistrationPage sentLastName(String str) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(str);
        driver.findElement(ADDRESS_LAST_NAME_INPUT).sendKeys(str);
        return this;
    }

    public RegistrationPage sentPassword(String str) {
        driver.findElement(PASSWORD_INPUT).sendKeys(str);
        return this;
    }

    public RegistrationPage sentAddress(String address) {
        driver.findElement(ADDRESS_FIRST).sendKeys(address);
        return this;
    }

    public RegistrationPage sentCity(String str) {
        driver.findElement(CITY_INPUT).sendKeys(str);
        return this;
    }

    public RegistrationPage selectState(String str) {
        driver.findElement(SELECT_STATE).click();
        driver.findElement(xpath("//option[text() = '" + str + "']")).click();
        return this;
    }

    public RegistrationPage sentPostcode(String str) {
        driver.findElement(POSTCODE_INPUT).sendKeys(str);
        return this;
    }

    public RegistrationPage sentMobilePhoneNumber(String str) {
        driver.findElement(MOBILE_PHONE_NUMBER_INPUT).sendKeys(str);
        return this;
    }

    public RegistrationPage sentAliasAddress(String str) {
        driver.findElement(ALIAS_ADDRESS).sendKeys(str);
        return this;
    }

    public MyAccountPage submitRegistration() {
        driver.findElement(SUBMIT).click();
        return new MyAccountPage(driver);
    }

    public boolean isPageHeaderDisplayed() {
        return waitVisibilityOf(15, driver.findElement(PAGE_HEADER)).isDisplayed();
    }

    public RegistrationPage fillAllRequiredFields(NewUser user) {
        clickMaleRadioButton()
                .sentFirstName(user.getFirstName())
                .sentLastName(user.getLastName())
                .sentPassword(user.getPassword())
                .sentAddress(user.getAddress())
                .sentCity(user.getCity())
                .selectState(user.getState())
                .sentPostcode(user.getPostalCode())
                .sentMobilePhoneNumber(user.getMobilePhone())
                .sentAliasAddress(user.getAddress());
        return this;
    }
}
