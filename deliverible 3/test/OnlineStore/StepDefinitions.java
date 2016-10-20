/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineStore;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author AsphaltPanthers
 */
public class StepDefinitions {
    private WebDriver driver;
    
    
    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
    }
    
    
    // UserLogin feature(user story) tests
    @Given("User is on Home Page")
    public void on_Home_Page() throws Throwable {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/");
    }
    
    @When("User Navigate to LogIn Page")
    public void user_Navigate_to_LogIn_Page() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
    }
    
    @When("User logged in using username as (.*) and password as (.*)")
    public void enters_correct_UserName_and_Password(String username, String password) throws Throwable {
        driver.findElement(By.id("log")).sendKeys(username); 	 
        driver.findElement(By.id("pwd")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }
       
            
    @When("User logged in without typing the username and the password")
    public void enters_no_UserName_and_Password() throws Throwable {
        driver.findElement(By.id("login")).click();
    }
    
    @Then("Message displayed on the right upper corner should be (.*)")
    public void message_displayed_Login_Successfully(String message) throws Throwable {       
        String login = driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a")).getText();
        assertEquals(message, login);
    }
    
    @Given("User is on Your Account Page")
    public void on_Your_Account_Page() throws Throwable {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/products-page/your-account/");
    }
    
    @When("User click on Log out")
    public void user_Click_Log_out() throws Throwable {
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"meta\"]/ul/li[2]/a")).click();
    }
    
    @Then("Message displayed on the page should be (.*)")
    public void message_displayed_Log_out(String message) throws Throwable {       
        String logOut = driver.findElement(By.xpath("//*[@id=\"login\"]/p[1]")).getText();
        assertEquals(message, logOut);
    }
    
    @Then("Message displayed on the page will be (.*)")
    public void message_displayed_Error(String message) throws Throwable {
        Thread.sleep(6000);
        String error = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]")).getText();
        assertEquals(message, error);
    }
    
    @Then("Message displayed on the page must be (.*)")
    public void no_Username_And_Password_Error(String message) throws Throwable {
        Thread.sleep(6000);
        String error = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]")).getText();
        assertEquals(message, error);
    }
    
    
    // Search feature(user story) tests
    @When("User Type \"(.*)\" as keywords for searching")
    public void user_Type_In_Serachbox(String input) throws Throwable {
        Thread.sleep(6000);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/form/fieldset/input[1]"));
        searchBox.clear();
        searchBox.sendKeys(input);
        searchBox.sendKeys(Keys.ENTER);
    }
    
    @Then("all related items should appear on search result page with clickable Add To Cart buttons")
    public void search_Result() throws Throwable {
        Thread.sleep(6000);
        boolean exist = driver.findElement(By.xpath("//*[@id=\"grid_view_products_page_container\"]/div/div[1]/div[2]/h2/a")).getText().isEmpty();
        assertFalse(exist);
    }
    
    @Then("on the result page the sentence \"(.*)\" will appear")
    public void search_noResult(String noResult) throws Throwable {
        Thread.sleep(6000);
        String add = driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
        assertEquals(noResult, add);
    }
       
    // ShoppingCart feature(user story) tests
    @Given("User is on the Magic Mouse Page")
    public void on_Magic_Mouse_Page() throws Throwable {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/");
    }
    
    @When("User Click on the Add To Cart button")
    public void user_Click_Add_To_Cart() throws Throwable {
        Thread.sleep(3500);
        driver.findElement(By.xpath("//*[@id=\"single_product_page_container\"]/div[1]/div[2]/form/div[2]/div[1]")).click();       
    }
    
    @Then("User Click on the Go to Checkout Button")
    public void user_Click_Go_To_Checkout() throws Throwable {
        Thread.sleep(3500);
        driver.findElement(By.xpath("//*[@id=\"fancy_notification_content\"]/a[1]")).click();       
    }
    
    @Then("User will get to the (.*) page")
    public void user_Go_To_Checkout_Page(String title) throws Throwable {
        Thread.sleep(6000);       
        assertEquals(title, driver.getTitle());
    }
    
    @Then("Change the Quantity to (.*)")
    public void user_Change_Quantity(String num) throws Throwable {
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")).clear();
        driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")).sendKeys(num);
        driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[4]")).click();
    }
    
    @Then("the total price will be (.*)")
    public void total_Price(String price) throws Throwable {
        Thread.sleep(6000);       
        String realPrice = driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[5]/span/span")).getText();
        assertEquals(price, realPrice);
    }
    
    @Then("the sentence \"(.*)\" will show up on the page")
    public void empty_Cart(String warning) throws Throwable {
        Thread.sleep(6000);       
        String sentence = driver.findElement(By.xpath("//*[@id=\"post-29\"]/div")).getText();
        assertEquals(warning, sentence);
    }
    
    @Then("Click on Remove button")
    public void click_Remove() throws Throwable {
        Thread.sleep(6000);       
        driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[6]/form/input[4]")).click();
    }
        
    @After
    public void cleanUp() {
        driver.quit();
    }
}
