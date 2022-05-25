package org.example.WebsitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P04_WishList {

    WebDriver driver;
    public P04_WishList(WebDriver driver) {
        this.driver = driver ;
    }

    // <editor-fold defaultstate="collapsed" desc="home page Slider Web elements">

    public List<WebElement> wishList_Icon()
    {
        List<WebElement> wishListIcon = driver.findElements(By.xpath("//div[@class=\"product-item\"]//button[@class=\"button-2 add-to-wishlist-button\"]"));
                //By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
                //By.xpath("//div[@data-productid=\"18\"]//button[@title=\"Add to wishlist\"]"));
        return wishListIcon;
    }



    public WebElement wishList_msg_div()
    {
        WebElement wishList_msg_div = driver.findElement(By.id("bar-notification"));
        return wishList_msg_div;
    }


    public WebElement wishList_msg_close()
    {
        WebElement wishList_msg_close = driver.findElement(By.xpath
                ("//div[@id=\"bar-notification\"]//span[@class=\"close\"]"));
        return wishList_msg_close;
    }

    public WebElement wishList_items_qty()
    {
        WebElement wishList_items = driver.findElement(By.className("wishlist-qty"));
        return wishList_items;
    }

      public WebElement wishList_lable()
    {
        WebElement wishList_lable = driver.findElement(By.className("wishlist-label"));
        return wishList_lable;
    }

    public WebElement item_QTY()
    {
        WebElement item_QTY = driver.findElement(By.xpath("//table[@class=\"cart\"]//input[@class=\"qty-input\"]"));
        return item_QTY;
    }
    // </editor-fold>
}
