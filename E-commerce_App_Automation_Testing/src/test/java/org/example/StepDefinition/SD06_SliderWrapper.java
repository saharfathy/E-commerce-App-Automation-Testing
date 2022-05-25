package org.example.StepDefinition;

import org.example.WebsitePages.P02_Login;
import org.example.WebsitePages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SD06_SliderWrapper {

    //create homePage Object
    public P03_HomePage homeSlider = new P03_HomePage(Hooks.driver);

    //create login Page Object
    public P02_Login login = new P02_Login(Hooks.driver);

  // <editor-fold defaultstate="collapsed" desc="Background Steps">
    //Navigate to the WebSite
    @Given("user navigate slider to url")
    public void user_navigate_slider_to_url() {
        System.out.println("Navigate");
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @And("slider user Click on Login Tab")
    public void hover_user_Click_on_Login_Tab() {

        login.log_Click_tab().click();
    }

    @And("^slider Enter valid \"(.*)\" and \"(.*)\"$")
    public  void hover_login_Data(String userEmail, String userPassword) throws InterruptedException {

        login.login_Function(userEmail,userPassword);
        Thread.sleep(3000);
        login. btn_log_elem().click();
        Thread.sleep(3000);
    }
  // </editor-fold>

    @Given("slider My account tab isDisplayed")
    public  void account_tab_isDisplayed() throws InterruptedException {
        boolean actual_result = login.account_tab().isDisplayed();
        System.out.println(actual_result);
        Assert.assertTrue(actual_result, "Account Tab is Displayed");
    }

    @When("user click on first slider")
    public void first_slider() throws InterruptedException {
        Thread.sleep(2000);
        homeSlider.sliders("1").click();
    }

    @When("user click on second slider")
    public void second_slider() throws InterruptedException {

        Thread.sleep(2000);
        homeSlider.sliders("2").click();

    }

    @Then("verify clicking on home slider1 result")
    public void slider1_result() throws InterruptedException {

        Thread.sleep(2000);
        String expected_url = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actual_url = Hooks.driver.getCurrentUrl();
        System.out.println(expected_url);
        System.out.println(actual_url);
        //Url Assertion
        Assert.assertEquals(actual_url.contains(expected_url), true);

    }

    @Then("verify clicking on home slider2 result")
    public void slider2_result() throws InterruptedException {

        Thread.sleep(2000);
        String expected_url = "https://demo.nopcommerce.com/iphone-6";
        String actual_url = Hooks.driver.getCurrentUrl();
        System.out.println(expected_url);
        System.out.println(actual_url);
        //Url Assertion
        Assert.assertEquals(actual_url.contains(expected_url), true);

    }

}
