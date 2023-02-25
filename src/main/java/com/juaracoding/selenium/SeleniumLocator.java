package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/text-box");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        String titleHeader = driver.getTitle();
        System.out.println("Title Header :"+titleHeader);

        //Locator
        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title Page : "+title);
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("info@juaracoding.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        //Scroll by pixel (vertical)
        js.executeScript("window.scrollBy(0, 500)");
        driver.findElement(By.id("submit")).click();
        System.out.println("Data berhasil disimpan");

        //verify jika blm ada testNG
        System.out.println("Test Case Result");
        if (title.equals("Text box")){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        System.out.println("Delay 3 Seconds");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");
    }
}
