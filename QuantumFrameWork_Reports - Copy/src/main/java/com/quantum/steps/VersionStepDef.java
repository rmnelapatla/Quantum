package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@QAFTestStepProvider
public class VersionStepDef {


    @Given("^Login Version application with valid username and password$")
    public void login_Version_application_with_valid_username_and_password()  {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverTestBase().getDriver().get("https://www53.v1host.com/CGIinfo/Account.mvc/LogIn");
    }

    @When("^Verify landing page$")
    public void verify_landing_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(5000);
        QAFExtendedWebElement txt_username = new QAFExtendedWebElement("//input[@id='username']");
        QAFExtendedWebElement txt_pssword = new QAFExtendedWebElement("//input[@id='password']");
        QAFExtendedWebElement btn_login = new QAFExtendedWebElement("//button[1]");

        txt_username.sendKeys("admin");
        txt_pssword.sendKeys("@Lt12345");
        btn_login.click();
        Thread.sleep(3000);
    }

    @Then("^Logout from Application$")
    public void logout_from_Application() {
        // Write code here that turns the phrase above into concrete actions

        QAFExtendedWebElement imgadmin= new QAFExtendedWebElement("//img[@src='/s/18.2.5.14/css/images/no_avatar.png']");
        QAFExtendedWebElement lnklogout= new QAFExtendedWebElement("css=a.logout.rich-menu-item  > span.content > span.title");


    }


}













