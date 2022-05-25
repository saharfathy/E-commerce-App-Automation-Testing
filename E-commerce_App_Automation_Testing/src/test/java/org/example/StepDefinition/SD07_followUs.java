package org.example.StepDefinition;

import org.example.WebsitePages.P03_HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;

public class SD07_followUs {

    //create home Page Object
    public P03_HomePage follow = new P03_HomePage(Hooks.driver);


    // <editor-fold defaultstate="collapsed" desc="Background Steps">
    //Navigate to the WebSite
    @Given("user navigate followUs to url")
    public void user_navigate_slider_to_url() {
        System.out.println("Navigate");
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FaceBook Scenario">
    //Scenario 1
    @When("user click on facebook Icon")
    public void facebook_opened() {

        follow.facebook_Icon().click();
    }

    @Then("verify that facebook url opened")
    public void facebook_url_result() throws InterruptedException {

        Thread.sleep(2000);   //to give opportunity to the driver to open the second tab after click on facebook icon
        //now I have two tabs One for (tab"0"--> nopcommerce website) the other for the (tab"1"-->facebook) I will add array list to handle them
        // getWindowHandles() method to be to switch between tabs
        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        //Switch to tab 1 facebook url
        System.out.println("Number of items in the array List:"+ Tabs.size());
        if(Tabs.size() > 1){
            Hooks.driver.switchTo().window(Tabs.get(1));
        } else if (Tabs.size() == 1) {
            Hooks.driver.switchTo().window(Tabs.get(0));
        }

        String expected_url = "https://www.facebook.com/nopCommerce";
        String actual_url = Hooks.driver.getCurrentUrl();
        System.out.println(expected_url);
        System.out.println(actual_url);
        //Url Assertion
        Assert.assertEquals(actual_url,expected_url);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
        String tab0url = Hooks.driver.getCurrentUrl();
        System.out.println(tab0url);

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Twitter Scenario">
    //Scenario 2
    @When("user click on twitter Icon")
    public void twitter_opened() {

        follow.twitter_Icon().click();
    }

    @Then("verify that twitter url opened")
    public void twitter_url_result() throws InterruptedException {


        Thread.sleep(2000);   //to give opportunity to the driver to open the second tab after click on facebook icon
        //now I have two tabs One for (tab"0"--> nopcommerce website) the other for the (tab"1"-->facebook) I will add array list to handle them
        // getWindowHandles() method to be to switch between tabs
        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        //Switch to tab 1 facebook url
        System.out.println("Number of items in the array List:"+ Tabs.size());
        if(Tabs.size() > 1){
            Hooks.driver.switchTo().window(Tabs.get(1));
        } else if (Tabs.size() == 1) {
            Hooks.driver.switchTo().window(Tabs.get(0));
        }

        String expected_url = "https://twitter.com/nopCommerce";
        String actual_url = Hooks.driver.getCurrentUrl();
        System.out.println(expected_url);
        System.out.println(actual_url);
        //Url Assertion
        Assert.assertEquals(actual_url,expected_url);
        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
        String tab0url = Hooks.driver.getCurrentUrl();
        System.out.println(tab0url);

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="RSS Scenario">
    //Scenario 3
    @When("user click on rss Icon")
    public void rss_opened() {

        follow.rss_Icon().click();
    }

    @Then("verify that rss url opened")
    public void rss_url_result() throws InterruptedException {

        Thread.sleep(2000);   //to give opportunity to the driver to open the second tab after click on facebook icon
        //now I have two tabs One for (tab"0"--> nopcommerce website) the other for the (tab"1"-->facebook) I will add array list to handle them
        // getWindowHandles() method to be to switch between tabs
        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        //Switch to tab 1 facebook url
        System.out.println("Number of items in the array List:"+ Tabs.size());
        if(Tabs.size() > 1){
            Hooks.driver.switchTo().window(Tabs.get(1));
        } else if (Tabs.size() == 1) {
            Hooks.driver.switchTo().window(Tabs.get(0));
        }


        String expected_url = "https://demo.nopcommerce.com/new-online-store-is-open";
        String actual_url = Hooks.driver.getCurrentUrl();
        System.out.println(expected_url);
        System.out.println(actual_url);
        //Url Assertion
        Assert.assertEquals(actual_url,expected_url);
        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
        String tab0url = Hooks.driver.getCurrentUrl();
        System.out.println(tab0url);

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Youtube Scenario">
    //Scenario 4
    @When("user click on youtube Icon")
    public void youtube_opened() {

        follow.youtube_Icon().click();
    }

    @Then("verify that youtube url opened")
    public void youtube_url_result() throws InterruptedException {

        Thread.sleep(2000);   //to give opportunity to the driver to open the second tab after click on facebook icon
        //now I have two tabs One for (tab"0"--> nopcommerce website) the other for the (tab"1"-->facebook) I will add array list to handle them
        // getWindowHandles() method to be to switch between tabs
        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        //Switch to tab 1 facebook url
        System.out.println("Number of items in the array List:"+ Tabs.size());
        if(Tabs.size() > 1){
            Hooks.driver.switchTo().window(Tabs.get(1));
        } else if (Tabs.size() == 1) {
            Hooks.driver.switchTo().window(Tabs.get(0));
        }

        String expected_url = "https://www.youtube.com/user/nopCommerce";
        String actual_url = Hooks.driver.getCurrentUrl();
        System.out.println(expected_url);
        System.out.println(actual_url);
        //Url Assertion
        Assert.assertEquals(actual_url,expected_url);
        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
        String tab0url = Hooks.driver.getCurrentUrl();
        System.out.println(tab0url);

    }
    // </editor-fold>
}
