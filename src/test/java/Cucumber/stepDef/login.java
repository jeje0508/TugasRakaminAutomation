package Cucumber.stepDef;

import com.sun.deploy.net.DownloadException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user open swag labs website")
    public void user_open_swag_labs_website() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().window();//
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @Then("user should see login Page")
    public void userShouldSeeLoginPage() {
        driver.findElement(By.id("login-button"));
        driver.findElement(By.id("user-name"));
        driver.findElement(By.id("password"));
    }

    @And("user input registered user")
    public void userInputRegisteredUser() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input unregistered user")
    public void user_input_unregistered_user() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out");
    }

    @And("user input valid password")
    public void userInputValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user click the login button")
    public void userClickTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should see Product Page")
    public void userShouldSeePage() {
        String loginPageAssert1 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div[contains(text(), 'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(loginPageAssert1, "Sauce Labs Backpack");
    }

    @Then("user should see error message bellow the password field")
    public void user_should_see_error_message_bellow_the_password_field() {
        String ErrorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
      }

    @And("user input locked user")
    public void userInputLockedUser() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }

    @Then("user should see locked message bellow the password field")
    public void userShouldSeeLockedMessageBellowThePasswordField() {
        String ErrorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Sorry, this user has been locked out.");
    }

    @And("user not input password")
    public void userNotInputPassword() {
        driver.findElement(By.id("password")).sendKeys("");
    }

    @Then("user should see error pass message bellow the password field")
    public void userShouldSeeErrorPassMessageBellowThePasswordField() {
        String ErrorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Password is required')]")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Password is required");
    }

    @And("user click add to cart button")
    public void user_click_add_to_cart_button() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    @And("user click cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }


    @And("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }


    @Then("user should see Checkout Your Information page")
    public void userShouldSeeCheckoutYourInformationPage() {
        String Cekot = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span[contains(text(),'Checkout: Your Information')]")).getText();
        Assert.assertEquals(Cekot, "Checkout: Your Information");
    }

    @And("user input on first name field")
    public void userInputOnFirstNameField() {
        driver.findElement(By.id("first-name")).sendKeys("Jessica");
    }

    @And("user input last name field")
    public void userInputLastNameField() {
        driver.findElement(By.id("last-name")).sendKeys("Widyadhana I");
    }

    @And("user input Zip or Postal Code field")
    public void userInputZipPostalCodeField() {
        driver.findElement(By.id("postal-code")).sendKeys("14045");
    }

    @When("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("user directed to checkout overview section")
    public void userDirectedToCheckoutOverviewSection() {
        String CekotOverview = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span[contains(text(),'Checkout: Overview')]")).getText();
        Assert.assertEquals(CekotOverview, "Checkout: Overview");
    }

    @And("user click Finish button")
    public void userClickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user directed to checkout complete section")
    public void userDirectedToCheckoutCompleteSection() {
        String thankyu = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]")).getText();
        Assert.assertEquals(thankyu,"Thank you for your order!");
    }

    @When("user click back home button")
    public void userClickBackHomeButton() {
        driver.findElement(By.id("back-to-products")).click();
    }

    @And("user click burger button")
    public void userClickBurgerButton() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("user click logout menu")
    public void userClickLogoutMenu() {
        //driver.findElement(By.id("logout_sidebar_link")).click();
        new WebDriverWait(driver, Duration.ofMinutes(2)).until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
    }

    @Then("user should see error message bellow the Zip or Postal Code field")
    public void userShouldSeeErrorMessageBellowTheZipOrPostalCodeField() {
        String ErrorZipCode = driver.findElement(By.xpath("//h3[contains(text(),'Error: Postal Code is required')]")).getText();
        Assert.assertEquals(ErrorZipCode, "Error: Postal Code is required");
    }

    @When("i input (.*) as username$")
    public void i_input_standard_user_as_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("i input (.*) as password$")
    public void i_input_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user verify (.*) login$")
    public void user_verify_success_login(String status) {
        switch (status) {
            case "success":  //Jika success
                String loginPageAssert1 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div[contains(text(), 'Sauce Labs Backpack')]")).getText();
                Assert.assertEquals(loginPageAssert1, "Sauce Labs Backpack");
                break;
            case "locked": { // Jika akun terkunci
                String ErrorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]")).getText();
                Assert.assertEquals(ErrorLogin, "Epic sadface: Sorry, this user has been locked out.");
                break;
            }
            case "failed": {  // Jika password dikosongkan
                String ErrorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Password is required')]")).getText();
                Assert.assertEquals(ErrorLogin, "Epic sadface: Password is required");
                break;
            }
            case "wrongusername": {  // Jika akun salah username or password
                String ErrorLogin = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")).getText();
                Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
                break;
            }
        }
        driver.close();
    }

    @And("user click (.*) item from pdp$")
    public void user_click_true_item_from_pdp(String remove) {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        if (remove.equals("true")){
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed();
        } else {
            driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
        }
        driver.close();
    }
}

