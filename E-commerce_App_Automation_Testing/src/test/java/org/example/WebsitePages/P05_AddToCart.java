package org.example.WebsitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P05_AddToCart {
    WebDriver driver;
    public P05_AddToCart(WebDriver driver) {
        this.driver = driver ;
    }

    // <editor-fold defaultstate="collapsed" desc="home page Slider Web elements">

    public WebElement cart_items_qty()
    {
        WebElement cart_items = driver.findElement(By.className("cart-qty"));
        return cart_items;
    }

    public List<WebElement> add_to_cart_btn()
    {
        List<WebElement> shopping_cart_btn = driver.findElements(By.xpath("//div[@class=\"product-item\"]//button[@class=\"button-2 product-box-add-to-cart-button\"]"));
        return shopping_cart_btn;
    }

    public List<WebElement> item_title_homePage()
    {
        List<WebElement> items_titles = driver.findElements(By.xpath("//div[@class=\"product-item\"]//h2[@class=\"product-title\"]"));
        return items_titles;
    }

    public WebElement shoppingCart_msg_div()
    {
        WebElement shoppingCart_msg_div = driver.findElement(By.id("bar-notification"));
        return shoppingCart_msg_div;
    }


    public WebElement shoppingCart_msg_close()
    {
        WebElement shoppingCart_msg_close = driver.findElement(By.xpath
                ("//div[@id=\"bar-notification\"]//span[@class=\"close\"]"));
        return shoppingCart_msg_close;
    }



    public WebElement shoppingCart_lable()
    {
        WebElement shoppingCart_lable = driver.findElement(By.className("cart-label"));
        return shoppingCart_lable;
    }

    public WebElement item_QTY()
    {
        WebElement item_QTY = driver.findElement(By.xpath("//table[@class=\"cart\"]//input[@class=\"qty-input\"]"));
        return item_QTY;
    }

    public WebElement cart_item_title()
    {
        WebElement item_QTY = driver.findElement(By.xpath("//table[@class=\"cart\"]//td[@class=\"product\"]"));
        return item_QTY;
    }
    // </editor-fold>
}
