package org.example.StepDefinition;

import org.example.WebsitePages.P02_Login;
import org.example.WebsitePages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SD04_hoverCategories {


    //create homePage Page Object
    public P03_HomePage hover = new P03_HomePage(Hooks.driver);

    //create login Page Object
    public P02_Login login = new P02_Login(Hooks.driver);;

    String subCategoryName;

    // <editor-fold defaultstate="collapsed" desc="Background Steps">
    //Navigate to the WebSite
    @Given("user navigate2 to url")
    public void hover_user_navigate2_to_url() {
        System.out.println("Navigate");
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @And("user Click on Login Tab hover")
    public void hover_user_Click_on_Login_Tab() {

        login.log_Click_tab().click();
    }

    @And("^hover Enter valid \"(.*)\" and \"(.*)\"$")
    public  void hover_login_Data(String userEmail, String userPassword) throws InterruptedException {

        login.login_Function(userEmail,userPassword);
        Thread.sleep(3000);
        login. btn_log_elem().click();
        Thread.sleep(3000);
    }

// </editor-fold>


    @Given("hover My account tab isDisplayed")
    public  void account_tab_isDisplayed() throws InterruptedException {
        boolean actual_result = login.account_tab().isDisplayed();
        System.out.println(actual_result);
        Assert.assertTrue(actual_result, "Account Tab is Displayed");
    }
    //hover
    @When("user hover category and select subcategory")
    public void hover_category() throws InterruptedException {

        Thread.sleep(3000);
        Actions action = new Actions(Hooks.driver);
        // hover on "Computers"
        action.moveToElement(hover.category_hover()).perform();
        Thread.sleep(1000);

        // getText() of subCategory before click on it
        subCategoryName = hover.sub_category_hover().getText().toLowerCase().trim();		// this will change "Desktops " to "desktops"
        System.out.println(subCategoryName);

        // click on "Desktops"
        hover.sub_category_hover().click();
        Thread.sleep(1000);

    }


    //Check Result
    @Then("verify hover the result")
    public void search_result()  {
        //getText for this element div[class="page-title"] and make it lower case using  	.toLowerCase()
       // 2.2- Compare between the text and the String you get it from the previous step subCategoryName


        String expected_sub_category = hover.sub_category_title().getText().toLowerCase();
        String actual_sub_category = subCategoryName;
        System.out.println(expected_sub_category);
        System.out.println(actual_sub_category);
        //Url Assertion
        Assert.assertTrue(actual_sub_category.contains(expected_sub_category), "hover and select sub category Done Successfully!");

    }

}
