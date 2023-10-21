package kasirAJa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void success_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome drive
        //Membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();;//
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
        //Input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login
        driver.findElement(By.id("login-button")).click();

        //Assert di dashboard page
        String loginPageAssert1 = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert1,"Swag Labs");

        //quit
        //driver.close();
    }

    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome drive
        //Membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();;//
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(), 'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");
        //Input email
        driver.findElement(By.id("email")).sendKeys("admin@sel.com");
        //Input password
        driver.findElement(By.id("password")).sendKeys("123456");
        //click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(ErrorLogin, "Kredensial yang Anda berikan salah");
    }
}
