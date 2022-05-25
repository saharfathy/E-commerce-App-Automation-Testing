package org.example.WebsitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class P02_Login {

    WebDriver driver;
    public P02_Login(WebDriver driver) {
        this.driver = driver ;
    }


    //Click On Register Tab
    public WebElement log_Click_tab(){
        WebElement log_tab =
                driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
        return log_tab;
    }

    //Enter email address
    public WebElement user_Email_elem(){
        WebElement email = driver.findElement(By.id("Email"));
        return email;
    }

    //Enter any password
    public WebElement user_Password_elem(){
        WebElement password = driver.findElement(By.id("Password"));
        return password;
    }

    //LOG IN button
    public WebElement btn_log_elem(){
        WebElement loginButton =
                driver.findElement(By.xpath
               ("//div[@class=\"buttons\"]//button[@type=\"submit\"]"));
        return loginButton;
    }

    //MY account Tab is displayed
    public WebElement account_tab(){
        WebElement account_tab =
                driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));
        return account_tab;
    }

    //Login Function
    public void login_Function(String userEmail, String password){

        //Enter User Email
        user_Email_elem().clear();
        user_Email_elem().sendKeys(userEmail);

        //EnterUser Password
        user_Password_elem().sendKeys(password);

    }
}
