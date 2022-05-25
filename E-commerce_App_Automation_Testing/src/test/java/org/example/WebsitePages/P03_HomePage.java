package org.example.WebsitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_HomePage {

    WebDriver driver;
    public P03_HomePage(WebDriver driver) {
        this.driver = driver ;
    }

    // <editor-fold defaultstate="collapsed" desc="Switch Currency Web elements">
    //Select List
    public WebElement select_list(){
        WebElement sel_list = driver.findElement(By.id("customerCurrency"));
        return sel_list;
    }

    //Check Product 1 currency
    public WebElement check_product_one(){
        WebElement product1 = driver.findElement(By.xpath("//div [@data-productid=\"1\"]//span"));
                //RelativeLocator.with(By.className("price")).below(By.cssSelector("//a[href = \"https://demo.nopcommerce.com/build-your-own-computer\"]")));
                //
        return product1;
    }

    //Check Product 2 currency
    public WebElement check_product_two(){
        WebElement product2 = driver.findElement(By.xpath("//div [@data-productid=\"4\"]//span"));
        return product2;
    }

    //Check Product 3 currency
    public WebElement check_product_three(){
        WebElement product3 = driver.findElement(By.xpath("//div [@data-productid=\"18\"]//span"));
        return product3;
    }

    //Check Product 4 currency
    public WebElement check_product_four(){
        WebElement product4 = driver.findElement(By.xpath("//div [@data-productid=\"43\"]//span"));
        return product4;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Search Web elements">
    //get On search field
    public WebElement search_field(){
        WebElement search_field = driver.findElement(By.id("small-searchterms"));
        return search_field;
    }

     //get Search Button
    public WebElement search_btn(){
        WebElement search_btn = driver.findElement(By.xpath
                ("//form[@id=\"small-search-box-form\"]//button[@type=\"submit\"]"));
        return search_btn;
    }

    //Enter any password
    public WebElement user_Password_elem(){
        WebElement password = driver.findElement(By.id("Password"));
        return password;
    }

// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="hover categories and select sup category Web elements">

    public WebElement category_hover(){
        WebElement category = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]"));
        return category;
    }

    public WebElement sub_category_hover(){
        WebElement sub_category = driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]"));
        return sub_category;
    }
    public WebElement sub_category_title(){
        WebElement title = driver.findElement(By.className("page-title"));
        return title;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="home page Slider Web elements">

    public WebElement sliders(String num)
    {
        WebElement slider = driver.findElement(By.xpath("//a[@href=\"http://demo.nopcommerce.com/\"]["+num+"]")); ;
        return slider;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FollowUS Web elements">

    //Facebook Icon Web element
    public WebElement facebook_Icon(){
        WebElement facebookWE = driver.findElement(By.className("facebook"));

        return facebookWE;
    }
    //Twitter Icon Web element
    public WebElement twitter_Icon(){
        WebElement twitterWE = driver.findElement(By.className("twitter"));

        return twitterWE;
    }
    //RSS Icon Web element
    public WebElement rss_Icon(){
        WebElement rssWE = driver.findElement(By.className("rss"));

        return rssWE;
    }
    //Youtube Icon Web element
    public WebElement youtube_Icon(){
        WebElement youtubeWE = driver.findElement(By.className("youtube"));

        return youtubeWE;
    }
    // </editor-fold>


}
