package StepDefinitions;
import PageObjects.LoginPage;
import BaseClass.BaseClass;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class LoginSteps extends LoginPage{

    public LoginSteps(BaseClass base) {
        super(base);
    }

    @Given("^Login page is open$")
    public void loginPage(){
        super.loginPage();
    }

    @Given("^User is logged in$")
    public void loggedIn(){
        super.loginPage();
        super.fillUsernameField("standard_user");
        super.fillPasswordField("secret_sauce");
        super.clickLoginBtn();
    }

    @When("^I enter valid credentials$")
    public void fillInFields(){
        super.fillUsernameField("standard_user");
        super.fillPasswordField("secret_sauce");
    }

    @When("^I type \"([^\"]*)\" as username$")
    public void enterUsername(String username){
        super.fillUsernameField(username);
    }

    @When("^I type \"([^\"]*)\" as password")
    public void enterPassword(String password){
        super.fillPasswordField(password);
    }

    @And("I click on Login button")
    public void clickLoginBtn(){
        super.clickLoginBtn();
    }

    @Then("^URL should contain \"([^\"]*)\"$")
    public void urlContains(String str) {
        super.urlContains(str);
    }

    @Then("I should see error message \"([^\"]*)\"$")
    public void iShouldSeeErrorMessage(String msg) {
        Assertions.assertEquals(msg, super.errorMsg());
    }

    @When("^I click on \"([^\"]*)\" button from sidebar menu$")
    public void clickBtnSidebarMenu(String name) {
        super.clickBtnSidebarMenu(name);
    }

    @Then("I should be redirected to login page")
    public void iShouldBeRedirectedToLoginPage() {
        Assertions.assertTrue(super.loginPageOpens());
    }
}
