package com.avinashsinha.SN24_Cucumber.stepDefinations;

import com.avinashsinha.SN24_Cucumber.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

import java.util.List;

public class Ecommerce {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User logged in with {string} and {string}")
    public void user_logged_in(String username, String password) {

        driver = Hooks.driver;
        wait = Hooks.wait;

        By usernameTextBoxLocator = By.id("userEmail");
        WebElement usernameTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBoxLocator));
        usernameTextBox.sendKeys(username);

        By passwordTextBoxLocator = By.id("userPassword");
        WebElement passwordTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));
        passwordTextBox.sendKeys(password);

        By loginButtonLocator = By.id("login");
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        loginButton.click();

        By productPageLocator = By.cssSelector(".card-body");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPageLocator));

    }

    @When("User adds product {string} to cart")
    public void user_adds_product_to_cart(String productName) {

        driver = Hooks.driver;
        wait = Hooks.wait;

        By productsLocator = By.cssSelector(".card-body");

        List<WebElement> products = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productsLocator));

        for (WebElement product : products) {

            String name = product.findElement(By.tagName("b")).getText();

            if (name.equalsIgnoreCase(productName)) {
                wait.until(ExpectedConditions.elementToBeClickable(
                        product.findElement(By.xpath(".//button[contains(text(),'Add To Cart')]"))
                )).click();
                break;
            }
        }

    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {

        driver = Hooks.driver;
        wait = Hooks.wait;

        By toastContainerLocator = By.cssSelector("#toast-container");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastContainerLocator));

        By cartButtonLocator = By.xpath("//button[@routerlink='/dashboard/cart']");
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartButtonLocator));
        cartButton.click();

        By productListedLocator = By.cssSelector("div li");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productListedLocator));

        By checkoutButtonLocator = By.xpath("//button[contains(text(),'Checkout')]");
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonLocator));
        checkoutButton.click();

    }

    @When("User submits the order for {string}")
    public void user_submits_the_order_for(String productName) {

        driver = Hooks.driver;
        wait = Hooks.wait;

        By nameOnCardLocator = By.xpath("//div[contains(text(),'Name on Card')]/parent::div//input");
        WebElement nameOnCard = wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCardLocator));
        nameOnCard.sendKeys("1234");

        By applyCouponLocator = By.xpath("//input[@name='coupon']");
        WebElement applyCoupon = wait.until(ExpectedConditions.visibilityOfElementLocated(applyCouponLocator));
        applyCoupon.sendKeys("Rahul Shetty");

        By selectCountryLocator = By.xpath("//input[@placeholder='Select Country']");
        WebElement selectCountry = wait.until(ExpectedConditions.elementToBeClickable(selectCountryLocator));
        selectCountry.sendKeys("ind");

        By listOfCountryLocator = By.cssSelector(".ta-results");
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOfCountryLocator));

        By countriesLocator = By.cssSelector(".ta-item");
        List<WebElement> countries = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(countriesLocator));

        for (WebElement country : countries) {
            if (country.getText().equalsIgnoreCase("India")) {
                country.click();
                break;
            }
        }

        By placeOrderButtonLocator = By.xpath("//a[contains(text(),'Place Order')]");
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButtonLocator));
        placeOrderButton.click();

    }

    @Then("User sees {string} message on confirmation page")
    public void user_sees_message_on_confirmation_page(String message) {

        driver = Hooks.driver;
        wait = Hooks.wait;

        By confirmationTextMessageLocator = By.cssSelector(".hero-primary");
        WebElement confirmationTextMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationTextMessageLocator));

        assertEquals(message, confirmationTextMessage.getText());

    }
}