package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class MyStepdefs {


    @Given("^I Open the browser and enter the valid url$")
    public void i_Open_the_browser_and_enter_the_valid_url()  {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverTestBase().getDriver().get("https://www53.v1host.com/CGIinfo/Account.mvc/LogIn");
    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_enter_valid_and(String inputusername, String inputpassword)  {
        // Write code here that turns the phrase above into concrete actions
        QAFWebElement username= new QAFExtendedWebElement("login.user.txt");
        QAFWebElement password= new QAFExtendedWebElement("login.password.txt");
        QAFWebElement login= new QAFExtendedWebElement("login.login.btn");
        username.sendKeys(inputusername);
        password.sendKeys(inputpassword);
        login.click();




    }

    @Then("^I Landed on default page\\.$")
    public void i_Landed_on_default_page()  {
        // Write code here that turns the phrase above into concrete actions

    }

}
