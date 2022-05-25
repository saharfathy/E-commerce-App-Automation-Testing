package org.example.StepDefinition;

import org.example.WebsitePages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class SD05_Search {

    //create search Page Object
   public P03_HomePage search = new P03_HomePage(Hooks.driver);;
    public SoftAssert soft  = new SoftAssert();;

    //Navigate to the WebSite

    @Given("user navigate to url")
    public void user_navigate_to_url() {
        System.out.println("Navigate");
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }


    @Given("click on search field")
    public void click_on_search_field() {

        search.search_field().click();
    }

    //Search with name
    @When("^search for any product name like \"(.*)\"$")
    public void search_name(String productName) {

        search.search_field().sendKeys(productName);

    }

    @And("Click on Search Button")
    public void search_button_Click() {

        search.search_btn().click();

    }


    //Search with Serial number
    @When("^search for any product SKU like \"(.*)\"$")
    public void search_SKU(String productSKU) {

        search.search_field().sendKeys(productSKU);

    }

    @Then("verify the result")
    public void search_result()  {

        String expected_url = "https://demo.nopcommerce.com/search";
        String actual_url = Hooks.driver.getCurrentUrl();
        System.out.println(expected_url);
        System.out.println(actual_url);
        //Url Assertion
        soft.assertTrue(actual_url.contains(expected_url), "Search Done Successfully!");

        //Size Assertion
        int result_size = Hooks.driver.findElements(By.cssSelector("div[class=\"item-box\"]")).size();
        soft.assertTrue(result_size > 0);
        System.out.println("Result Size "+result_size);

        //Assert All
        soft.assertAll();
    }

}
