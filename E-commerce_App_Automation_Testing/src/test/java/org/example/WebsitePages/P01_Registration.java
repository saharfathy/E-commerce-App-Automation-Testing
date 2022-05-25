package org.example.WebsitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class P01_Registration {
    WebDriver driver;
    public P01_Registration(WebDriver driver) {
        this.driver = driver ;
    }


    //Click On Register Tab
    public WebElement register_Click_tab(){
        WebElement reg_tab =
                driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
        return reg_tab;
    }

    //Select Gender Element
    public WebElement gender(char c){
        WebElement gender = null;
        if (c =='M'){
            gender = driver.findElement(By.id("gender-male"));

        } else if (c =='F') {
            gender = driver.findElement(By.id("gender-female"));
        }
        return gender;
    }

    //Enter First Name
    public WebElement user_FirstName_elem(){
        WebElement first_Name = driver.findElement(By.id("FirstName"));
        return first_Name;
    }

    //Enter Last Name
    public WebElement user_LastName_elem(){
        WebElement last_Name = driver.findElement(By.id("LastName"));
        return last_Name;
    }

    //Select Day
    public WebElement birth_Day_elem(){
        WebElement day = driver.findElement(By.name("DateOfBirthDay"));
        return day;
    }

    //Select Month
    public WebElement birth_Month_elem(){
        WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
        return month;
    }

    //Select Year
    public WebElement birth_Year_elem(){
        WebElement year = driver.findElement(By.name("DateOfBirthYear"));
        return year;
    }

    //Enter email address
    public WebElement user_Email_elem(){
        WebElement email = driver.findElement(By.id("Email"));
        return email;
    }
    //Function to generate random email
    public String Generate_Random_Email(){
        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 3;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        String generatedString = sb.toString();
        return generatedString;
    }

    //Enter any company name
    public WebElement user_CompanyName_elem(){
        WebElement company = driver.findElement(By.id("Company"));
        return company;
    }

    //Enter any password
    public WebElement user_Password_elem(){
        WebElement password = driver.findElement(By.id("Password"));
        return password;
    }

    //Enter same password in Confirm password field
    public WebElement user_Confirm_password_elem(){
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        return confirmPassword;
    }

    //REGISTER button
    public WebElement btn_register_elem(){
        WebElement registerButton = driver.findElement(By.id("register-button"));
        return registerButton;
    }

    //Success message “Your registration completed”
    public WebElement msg_Success_elem(){
        WebElement msgSuccess = driver.findElement(By.cssSelector("div[class=\"result\"]"));
                //className("result"));
        return msgSuccess;
    }
}
