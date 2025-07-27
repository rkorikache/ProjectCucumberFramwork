package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    // WebDriver driver;
    // WebDriverWait wait;
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user leaves the username field empty")
    public void user_leaves_the_username_field_empty() {
        // WebElement usernameField = driver.findElement(By.id("txtUsername"));
        // usernameField.clear();
        loginPage.usernameField.clear();
        //loginPage.usernameField.sendKeys("");

    }

    @When("user enters a valid password")
    public void user_enters_a_valid_password() {
        // WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //passwordField.clear();
        // passwordField.sendKeys("Hum@nhrm123");

        loginPage.passwordField.clear();
        loginPage.passwordField.sendKeys(ConfigReader.read("password"));
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        // WebElement loginButton = driver.findElement(By.id("btnLogin"));
        // loginButton.click();
        click(loginPage.loginButton);
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //WebElement errorElement = driver.findElement(By.id("spanMessage"));
        //String actualMessage = errorElement.getText();
        //Assert.assertEquals(expectedMessage, actualMessage);
    }


    @When("user enters a valid username")
    public void userEntersAValidUsername() {
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        // WebElement usernameField = getwait().until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
        // usernameField.clear();
        // usernameField.sendKeys("Admin");
    }

    @And("user leaves the password field empty")
    public void userLeavesThePasswordFieldEmpty() {
        loginPage.passwordField.clear();
        // WebElement passwordField = driver.findElement(By.id("txtPassword"));
        // passwordField.clear();

    }

    @When("user enters an invalid username or password")
    public void userEntersAnInvalidUsernameOrPassword() {
        loginPage.usernameField.sendKeys("InvalidUser");
        loginPage.passwordField.sendKeys("WrongPass");
        //WebElement usernameField = driver.findElement(By.id("txtUsername"));
        // WebElement passwordField = driver.findElement(By.id("txtPassword"));
        // usernameField.clear();
        //usernameField.sendKeys("InvalidUser");
        // passwordField.clear();
        //passwordField.sendKeys("WrongPass");
    }


    @When("user attempts to login with invalid or empty credentials")
    public void userAttemptsToLoginWithInvalidOrEmptyCredentials() {
        loginPage.usernameField.clear();            // Leave username empty
        loginPage.passwordField.clear();            // Leave password empty
        loginPage.loginButton.click();         // Attempt login
        // WebElement usernameField = driver.findElement(By.id("txtUsername"));
        // WebElement passwordField = driver.findElement(By.id("txtPassword"));
        // usernameField.clear();
        // passwordField.clear();
        // driver.findElement(By.id("btnLogin")).click();

    }

    @Then("error messages should be visible near the respective input fields")
    public void errorMessagesShouldBeVisibleNearTheRespectiveInputFields() {
         Assert.assertTrue("Error message is not visible", loginPage.errorMessage.isDisplayed());
       // WebElement errorElement = driver.findElement(By.id("spanMessage"));  // Check your actual locator
       // Assert.assertTrue("Error message should be visible", errorElement.isDisplayed());
    }

    @Then("user should be able to correct input and try to log in again")
    public void userShouldBeAbleToCorrectInputAndTryToLogInAgain() {
        loginPage.usernameField.sendKeys(ConfigReader.read("userName"));
        loginPage.passwordField.sendKeys(ConfigReader.read("password"));
        loginPage.loginButton.click();
//        WebElement usernameField = driver.findElement(By.id("txtUsername"));
//        WebElement passwordField = driver.findElement(By.id("txtPassword"));
//        usernameField.clear();
//        usernameField.sendKeys("Admin");
//        passwordField.clear();
//        passwordField.sendKeys("Hum@nmhr123");
//        driver.findElement(By.id("btnLogin")).click();
    }
}
