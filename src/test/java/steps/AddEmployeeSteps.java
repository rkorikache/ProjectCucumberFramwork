package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {

   // AddEmployeePage addEmployeePage = new AddEmployeePage();
   @When("user enters username and password")
   public void user_enters_username_and_password() {
       //  WebElement usernameField = driver.findElement(By.id("txtUsername"));
       loginPage.usernameField.sendKeys("admin");

       //  WebElement passwordField = driver.findElement(By.id("txtPassword"));
       loginPage.passwordField.sendKeys("Hum@nhrm123");

   }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //  WebElement loginButton = driver.findElement(By.id("btnLogin"));
        //loginButton.click();
        click(loginPage.loginButton);

    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        //validating the existence of the element
        Assert.assertTrue(loginPage.welcomeMessageLoc.isDisplayed());

        String value = loginPage.welcomeMessageLoc.getText();
        //validating the exact message on the element
        Assert.assertEquals("Welcome Admin", value);
        System.out.println("Test passed");
    }
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        //the benefit of using this method is to get extra facilities available in it.
        //it will wait first for the element to be clickable
        click(pimOption);
    }
    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmployeeButton);
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //  WebElement saveButton = driver.findElement(By.id("btnSave"));
        click(addEmployeePage.saveButton);

    }
    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("employee added");
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstname, String middlename, String lastname) {
        //order of the parameter is imp bcz it will fetch the values in the order from feature
        //  WebElement firstNameLoc = driver.findElement(By.id("firstName"));
        sendText(firstname, addEmployeePage.firstNameLoc);

        //   WebElement middleNameLoc = driver.findElement(By.id("middleName"));
        sendText(middlename, addEmployeePage.middleNameLoc);

        // WebElement lastNameLoc = driver.findElement(By.id("lastName"));
        sendText(lastname, addEmployeePage.lastNameLoc);
    }
    @When("user enters {string} and {string} and {string} and {string}")
    public void user_enters_and_and(String firstname, String middlename, String lastname, String id) {
        //order of the parameter is imp bcz it will fetch the values in the order from feature
        //  WebElement firstNameLoc = driver.findElement(By.id("firstName"));
       this.user_enters_and_and(firstname,middlename,lastname);

        String dateTime = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        sendText(id+dateTime, addEmployeePage.idLoc);

    }
    @When("user leaves the firstname and lastname fields empty")
    public void user_leaves_the_firstname_and_lastname_fields_empty() {
       addEmployeePage.firstNameLoc.clear();
       addEmployeePage.lastNameLoc.clear();
    }
    @Then("an error message {string} should be displayed in add employee form")
    public void an_error_message_should_be_displayed_in_add_employee_form(String expectedMessage) {
      Assert.assertEquals(expectedMessage,addEmployeePage.fnErrMsg.getText());
      Assert.assertEquals(expectedMessage,addEmployeePage.lnErrMsg.getText());
    }

    @And("error messages should be visible near the respective input")
    public void errorMessagesShouldBeVisibleNearTheRespectiveInput() {
       Assert.assertTrue("error message should be displayed",addEmployeePage.fnErrMsg.isDisplayed());
       Assert.assertTrue("error message should be displayed",addEmployeePage.lnErrMsg.isDisplayed());
    }
}