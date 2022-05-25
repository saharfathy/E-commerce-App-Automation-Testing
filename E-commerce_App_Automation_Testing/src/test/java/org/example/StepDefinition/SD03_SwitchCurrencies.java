package org.example.StepDefinition;

import org.example.WebsitePages.P03_HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class SD03_SwitchCurrencies {

    //create SwitchCurrencyPage Object
    public P03_HomePage SwitchCurrency  = new P03_HomePage(Hooks.driver);;
    public SoftAssert soft  = new SoftAssert();;

    //Navigate to the WebSite
    @Given("user Navigate to The url")
    public void user_navigate_to_the_url() {
        System.out.println("Navigate");

        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @When("^user switch currencies to \"(.*)\"$")
    public  void switch_currencies(String currency) {

        Select dropdown = new Select(SwitchCurrency.select_list());
        if(currency.equals("US Dollar"))
        {
            dropdown.selectByVisibleText("US Dollar");

        } else if (currency.equals("Euro")) {
            dropdown.selectByVisibleText("Euro");
        }
    }


    @Then("Products display salary with Euro")
    public  void check_currency()  {

        String expected_currency = "€";
        String actual_currency="";
        for (int i = 1; i<=4;i++) {

            if(i == 1){
                //get first product
                actual_currency = SwitchCurrency.check_product_one().getText();
                System.out.println(actual_currency);
                soft.assertEquals(actual_currency.contains(expected_currency), true,"product"+i+"true");
            }
            else if(i == 2){
                //get second product
                actual_currency = SwitchCurrency.check_product_two().getText();

                System.out.println(actual_currency);
                soft.assertEquals(actual_currency.contains(expected_currency), true,"product"+i+"true");
            }
            else if(i == 3){
                //get second product
                actual_currency = SwitchCurrency.check_product_three().getText();

                System.out.println(actual_currency);
                soft.assertEquals(actual_currency.contains(expected_currency), true,"product"+i+"true");
            }
            else if(i == 4){
                //get second product
                actual_currency = SwitchCurrency.check_product_four().getText();

                System.out.println(actual_currency);
                soft.assertEquals(actual_currency.contains(expected_currency), true,"product"+i+"true");
            }

        }
    }

}
