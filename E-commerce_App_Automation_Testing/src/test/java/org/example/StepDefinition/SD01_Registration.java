package org.example.StepDefinition;

import org.example.WebsitePages.P01_Registration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class SD01_Registration {

    //create RegistrationPage Object
    public P01_Registration register = new P01_Registration(Hooks.driver);;
    public SoftAssert soft  = new SoftAssert();

    @Given("user Navigate to url")
    public void user_navigate_to_url() {
        System.out.println("Navigate");

        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user Click on Register Tab")
    public void user_Click_on_Register_Tab() {
       // Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click();
        register.register_Click_tab().click();
    }
    @When("Click on any Gender Option")
    public  void enter_Gender() {

        register.gender('F').click();
    }
    @And("Fill First Name")
    public  void enter_FirstName()  {
        register.user_FirstName_elem().sendKeys("First");
    }


    @And("Fill Last Name")
    public  void enter_LastName()  {
        register.user_LastName_elem().sendKeys("last Name");
    }


    @And("Select Day")
    public  void select_Day()  {

        register.birth_Day_elem().sendKeys("8");
    }


    @And("Select Month")
    public  void select_Month()  {
        register.birth_Month_elem().sendKeys("May");
    }


    @And("Select Year")
    public  void select_Year() {
        register.birth_Year_elem().sendKeys("1993");
    }


    @And("Enter email address")
    public  void enter_Email()  {

       // String generatedString = register.Generate_Random_Email();
      // System.out.println("Random String is: " + generatedString + "@example.com" );

        register.user_Email_elem().sendKeys("ABCD@example.com");
    }


    @And("Enter any company name")
    public  void enter_CompanyName(){
        register.user_CompanyName_elem().sendKeys("Automation Company");
    }


    @And("Enter any password")
    public  void enter_Password() {

        register.user_Password_elem().sendKeys("Pass123456");
    }


    @And("Enter same password in Confirm password field")
    public  void re_enter_Password() {
        register.user_Confirm_password_elem().sendKeys("Pass123456");
    }


    @And("Click on REGISTER button")
    public  void register_button() throws InterruptedException {
        Thread.sleep(3000);
        register.btn_register_elem().click();
    }


    @Then("Success message is displayed Your registration completed")
    public  void success_Message()  {

        String expected_msg = "Your registration completed";
        String actual_msg = register.msg_Success_elem().getText();
        System.out.println(expected_msg);
        System.out.println(actual_msg);
        soft.assertEquals(actual_msg.contains(expected_msg), true);
    }


    @And("the color of this message is green")
    //the color of this message is green rgba(76, 177, 124, 1)
    public  void success_Message_color() throws InterruptedException {
        String expected_color = "rgba(76, 177, 124, 1)";
        String actual_color = register.msg_Success_elem().getCssValue("color");
        System.out.println(expected_color);
        System.out.println(actual_color);
        soft.assertEquals(actual_color.contains(expected_color), true);
    }
}
