package com_orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Com_OrangeHrmLive {
    //1.Set up the Chrome Browser
    static String browser = "Chrome";
    //static String browser = "FireFox";
    //static String browser = "Edge";
    //Base Url
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    //Launch the Browser
    static WebDriver driver;

    public void multiBrowserTest() {
        //if-else loop
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
    }

    public static void main(String[] args) {
        //Object creation
        Com_OrangeHrmLive obj = new Com_OrangeHrmLive();
        obj.multiBrowserTest();

        //2.Open the Url into Browser
        driver.get(baseUrl);

        //Maximise the browser
        driver.manage().window().maximize();

        //We give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of the page
        System.out.println("Title of the page : " + driver.getTitle());

        //4. Print the current page
        System.out.println("Current Url : " + driver.getCurrentUrl());

        //5. Print the page source
        System.out.println("Page source : " + driver.getPageSource());

        //6. Click on 'Forgot your password?' link
        WebElement forgotPasswordLink = driver.findElement(By.className("orangehrm-login-forgot-header"));
        forgotPasswordLink.click();

        //7.Print the current Url
        System.out.println("Current url : " + driver.getCurrentUrl());

        //8. Navigate back to the login page
        driver.navigate().back();
        System.out.println("Login page : " + driver.getCurrentUrl());

        //9.Refresh the page
        driver.navigate().refresh();
        System.out.println("Refresh the page : " + driver.getCurrentUrl());

        //10. Enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("abc2023@gamil.com");

        //11. Enter the password to password field.
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("abc@2023");

        //12. Click on Login Button
        WebElement login = driver.findElement(By.xpath("//button[@type ='submit']"));
        login.click();

        //13. Close the Browser
        driver.quit();
    }
}//Run the program