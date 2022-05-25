package org.example.StepDefinition;

import org.example.Utilities.BrowserUtils;
import org.example.WebsitePages.P02_Login;
import org.example.WebsitePages.P05_AddToCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SD9_AddToCart {
    //create home Page Object
    public P05_AddToCart CartPage = new P05_AddToCart(Hooks.driver);
    public SoftAssert soft = new SoftAssert();

    //create login Page Object
    public P02_Login login = new P02_Login(Hooks.driver);

    int cartItems_Before;
    int cartListItems_After;
    String item_title_homePage ;


    // <editor-fold defaultstate="collapsed" desc="Background Steps">
    //Navigate to the WebSite
    @Given("user navigate Cart to url")
    public void user_navigate_Cart_to_url() {
        System.out.println("Navigate");
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @And("Cart user Click on Login Tab")
    public void Cart_user_Click_on_Login_Tab() {

        login.log_Click_tab().click();
    }

    @And("^Cart Enter valid \"(.*)\" and \"(.*)\"$")
    public  void cart_login_Data(String userEmail, String userPassword) throws InterruptedException {

        login.login_Function(userEmail,userPassword);
        Thread.sleep(3000);
        login. btn_log_elem().click();
        Thread.sleep(3000);
    }
    // </editor-fold>


    @Given("Cart My account tab isDisplayed")
    public  void accountTab_isDisplayed() throws InterruptedException {
        boolean actual_result = login.account_tab().isDisplayed();
        System.out.println(actual_result);
        soft.assertTrue(actual_result, "Account Tab is Displayed");
    }

    @When("^user click on product \"(.*)\" Add to Cart Button$")
    public void add_item_to_ShoppingCart(int item_num) throws InterruptedException {
        cartItems_Before = BrowserUtils.convertStringToInt(CartPage.cart_items_qty().getText());
        System.out.println(cartItems_Before);
        Thread.sleep(2000);
        item_title_homePage = CartPage.item_title_homePage().get(item_num).getText();
        System.out.println(item_title_homePage);
        CartPage.add_to_cart_btn().get(item_num).click();
        Thread.sleep(2000);
        cartListItems_After = BrowserUtils.convertStringToInt(CartPage.cart_items_qty().getText());
        System.out.println(cartListItems_After);

    }

    @Then("Shopping Cart notification msg of success is visible")
    public void shoppingCart_msg_Visible()  {

        //Check if the wishlist msg is visible (first assertion)
        boolean actual_result = CartPage.shoppingCart_msg_div().isDisplayed();
        System.out.println("Is Shopping cart notification msg of success is Displayed? " + actual_result);
        soft.assertTrue(actual_result, "Shopping cart notification msg of success is Displayed");

        //Check the success msg (second assertion)
        String expected_msg = "The product has been added to your Shopping cart";
        String actual_msg = CartPage.shoppingCart_msg_div().getText();
        System.out.println(expected_msg);
        System.out.println(actual_msg);
        soft.assertEquals(actual_msg.contains(expected_msg), true);

        //close message
        CartPage.shoppingCart_msg_close().click();

    }

    @And("the number of Shopping Cart items increased")
    public void shopping_Cart_item_increase() {
        System.out.println("Item added " + cartListItems_After + " > " + cartItems_Before + " "+ (cartListItems_After > cartItems_Before));
        soft.assertTrue(cartListItems_After > cartItems_Before,"Numbers of items in Shopping cart Increased!");

    }


    //Scenario 2
    @And("user go to Shopping Cart page")
    public void shopping_Cart_page() {
        //Go to wishList Page
        WebDriverWait cart_wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        //first method
        //cart_wait.until(ExpectedConditions.elementToBeClickable(CartPage.shoppingCart_lable())).click();

        //second method

        cart_wait.until(ExpectedConditions.invisibilityOf(CartPage.shoppingCart_msg_div()));
        CartPage.shoppingCart_lable().click();

    }

    @Then("quantity greater than 0")
    public void is_Quantity_increased_In_WishList_page()  {

        //quantity greater than 0
        int item_quan = BrowserUtils.convertStringToInt(CartPage.item_QTY().getAttribute("value"));
        System.out.println("Items in ShoppingCart count = " + item_quan + " " +(item_quan > 0));
        soft.assertTrue(item_quan > 0,"Numbers of items in Shopping cart page greater than 0!");


    }
    @And("item exist in the shopping cart")
    public void is_Item_Title_In_WishList_page()  {

        //item exist in the shopping cart
        String actual_item_inCart = CartPage.cart_item_title().getText();
        String expected_item_inCart = item_title_homePage;
        System.out.println("Item Expected title in shopping cart: "+expected_item_inCart);
        System.out.println("Item Actual title in shopping cart: " + actual_item_inCart);
        soft.assertTrue(actual_item_inCart.contains(expected_item_inCart), "Item added to Shopping cart");


    }
}
