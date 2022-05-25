package org.example.StepDefinition;


import org.example.WebsitePages.P02_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class SD02_Login {

    //create Login Page Object
    public P02_Login login = new P02_Login(Hooks.driver);;
    public SoftAssert soft  = new SoftAssert();;

    //Navigate to the WebSite
    @Given("user Navigate to website url")
    public void user_navigate_to_website_url() {
        System.out.println("Navigate");

        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @And("user Click on Login Tab")
    public void user_Click_on_Login_Tab() {

        login.log_Click_tab().click();
    }

    @When("^Enter valid \"(.*)\" and \"(.*)\"$")
    public  void login_Data(String userEmail, String userPassword) {

        login.login_Function(userEmail,userPassword);
    }

    @And("Click on LOG IN button")
    public  void login_button() throws InterruptedException {
        Thread.sleep(3000);
        login.btn_log_elem().click();
    }


    @Then("website opens")
    public  void website_Open()  {

            String expected_url = "https://demo.nopcommerce.com/";
            String actual_url = Hooks.driver.getCurrentUrl();
            System.out.println(expected_url);
            System.out.println(actual_url);
            soft.assertEquals(actual_url.contains(expected_url), true);
    }


    @And("My account tab isDisplayed")
    public  void account_tab_isDisplayed() throws InterruptedException {
        boolean actual_result = login.account_tab().isDisplayed();
        System.out.println(actual_result);
        soft.assertTrue(actual_result, "Account Tab is Displayed");
    }
}
