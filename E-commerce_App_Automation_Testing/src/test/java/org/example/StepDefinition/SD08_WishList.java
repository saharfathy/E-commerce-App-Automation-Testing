package org.example.StepDefinition;

import org.example.Utilities.BrowserUtils;
import org.example.WebsitePages.P04_WishList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SD08_WishList {

    //create home Page Object
    public P04_WishList wishListP = new P04_WishList(Hooks.driver);
    int wishListItems_Before;
    int wishListItems_After;
    String item_title ;


    // <editor-fold defaultstate="collapsed" desc="Background Steps">
    //Navigate to the WebSite
    @Given("user navigate wishList to url")
    public void user_navigate_slider_to_url() {
        System.out.println("Navigate");
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }
    // </editor-fold>

    @When("^user click on product \"(.*)\" wishList Icon$")
    public void add_item_to_wishList(int item_num) throws InterruptedException {
        // = 2;
        wishListItems_Before = BrowserUtils.convertStringToInt(wishListP.wishList_items_qty().getText());
        System.out.println(wishListItems_Before);
        Thread.sleep(2000);
        wishListP.wishList_Icon().get(item_num).click();
        Thread.sleep(2000);
        wishListItems_After = BrowserUtils.convertStringToInt(wishListP.wishList_items_qty().getText());
        System.out.println(wishListItems_After);

    }

    @Then("wishList notification msg of success is visible")
    public void wishList_msg_Visible()  {

        //Check if the wishlist msg is visible (first assertion)
        boolean actual_result = wishListP.wishList_msg_div().isDisplayed();
        System.out.println("Is WishList notification msg of success is Displayed? " + actual_result);
        Assert.assertTrue(actual_result, "WishList notification msg of success is Displayed");

        //Check the success msg (second assertion)
        String expected_msg = "The product has been added to your wishlist";
        String actual_msg = wishListP.wishList_msg_div().getText();
        System.out.println(expected_msg);
        System.out.println(actual_msg);
        Assert.assertTrue(actual_msg.contains(expected_msg), "Item added to wishlist");

        //close message
        wishListP.wishList_msg_close().click();

    }

    @And("the number of wishList items increased")
    public void wishlist_item_increase() {
        System.out.println("Item added " + wishListItems_After + " > " + wishListItems_Before +" "+ (wishListItems_After > wishListItems_Before));
        Assert.assertTrue(wishListItems_After > wishListItems_Before,"Numbers of items in WishList Increased!");

    }

    @And("user go to wishlist page")
    public void go_wishlist_page() {

        //Go to wishList Page
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
       //first method
        wait.until(ExpectedConditions.elementToBeClickable(wishListP.wishList_lable())).click();

        //second method
        /*
        wait.until(ExpectedConditions.invisibilityOf(wishListP.wishList_msg_div()));
        wishListP.wishList_lable().click();
       */
    }


    @Then("number of quantities are greater than zero in wishlist page")
    public void is_Quantity_increased_In_WishList_page()  {

        int item_quan = BrowserUtils.convertStringToInt(wishListP.item_QTY().getAttribute("value"));
        System.out.println("Items in WishList count = " + item_quan +" "+(item_quan > 0));
        Assert.assertTrue(item_quan > 0,"Numbers of items in WishList page greater than 0!");

    }

}
