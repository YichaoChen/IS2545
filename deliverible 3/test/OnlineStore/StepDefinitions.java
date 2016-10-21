/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineStore;

import com.google.common.base.Predicate;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author YichaoChen
 */
public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;
    
    /*
    I wrote those codes in modules since many scenarios share the same steps, so
    that those steps can be reused many times, which avoided repeating works :)
    I gave them comments so that it would be clear which scenarios include those steps
    */
    
    
    // Basic set up for the test
    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
    }
    
    
    // This Given is the base for UserLogin test and Search test. These two tests starts here
    // includes UserLogin test scenario 1, and Search scenario 1 and 2
    @Given("User is on Home Page")
    public void on_Home_Page() throws Throwable {
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/");
    }
    
    // A step for UserLogin test scenario 1
    @When("User Navigate to LogIn Page")
    public void user_Navigate_to_LogIn_Page() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
    }
    
    // A step for UserLogin test scenario 2(correct credentials) and scenario 3(wrong credentials)
    @When("User logged in using username as (.*) and password as (.*)")
    public void enter_UserName_and_Password(String username, String password) throws Throwable {
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"log\"]")).isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.id("log")).sendKeys(username); 	 
        driver.findElement(By.id("pwd")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }
       
    // A step for UserLogin test scenario 4(no input) 
    @When("User logged in without typing the username and the password")
    public void enter_no_UserName_and_Password() throws Throwable {
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.id("login")).isDisplayed());
        driver.findElement(By.id("login")).click();
    }
    
    // A step for UserLogin test scenario 1
    @Then("Message displayed on the right upper corner should be (.*)")
    public void message_displayed_Login_Successfully(String message) throws Throwable {
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a")).isDisplayed());
        String login = driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a")).getText();
        assertEquals(message, login);
    }
    
    // This Given is the base for UserLogin test scenario 2, 3, 4
    @Given("User is on Your Account Page")
    public void on_Your_Account_Page() throws Throwable {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/products-page/your-account/");
    }
    
    // A step for UserLogin test scenario 2
    @When("User click on Log out")
    public void user_Click_Log_out() throws Throwable {
        Thread.sleep(6000);
        //wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"meta\"]/ul/li[2]/a")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"meta\"]/ul/li[2]/a")).click();
    }
    
    // A step for UserLogin test scenario 2
    @Then("Message displayed on the page should be (.*)")
    public void message_displayed_Log_out(String message) throws Throwable {
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"login\"]/p[1]")).isDisplayed());
        String logOut = driver.findElement(By.xpath("//*[@id=\"login\"]/p[1]")).getText();
        assertEquals(message, logOut);
    }
    
    // A step for UserLogin test scenario 3
    @Then("Message displayed on the page will be (.*)")
    public void message_displayed_Invalid_Login_Credentials(String message) throws Throwable {
        //Thread.sleep(6000);
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]")).isDisplayed());
        String error = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]")).getText();
        assertEquals(message, error);
    }
    
    // A step for UserLogin test scenario 4
    @Then("Message displayed on the page must be (.*)")
    public void no_Username_And_Password_Error(String message) throws Throwable {
        //Thread.sleep(6000);
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]")).isDisplayed());
        String error = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]")).getText();
        assertEquals(message, error);
    }
    
    
    // A step for UserLogin test scenario 1 and 2
    @When("User Type \"(.*)\" as keywords for searching")
    public void user_Type_In_Serachbox(String input) throws Throwable {
        //Thread.sleep(6000);
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"main-nav\"]/form/fieldset/input[1]")).isDisplayed());
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/form/fieldset/input[1]"));
        searchBox.clear();
        searchBox.sendKeys(input);
        searchBox.sendKeys(Keys.ENTER);
    }
    
    // A step for UserLogin test scenario 1
    @Then("all related items should appear on search result page with clickable Add To Cart buttons")
    public void search_Has_Result() throws Throwable {
        //Thread.sleep(6000);
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"grid_view_products_page_container\"]/div/div[1]/div[2]/h2/a")).isDisplayed());
        boolean exist = driver.findElement(By.xpath("//*[@id=\"grid_view_products_page_container\"]/div/div[1]/div[2]/h2/a")).getText().isEmpty();
        assertFalse(exist);
    }
    
    // A step for UserLogin test scenario 2
    @Then("on the result page the sentence \"(.*)\" will appear")
    public void search_No_Result(String noResult) throws Throwable {
        //Thread.sleep(6000);
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"content\"]/p")).isDisplayed());
        String add = driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
        assertEquals(noResult, add);
    }
       
    // The base for ShoppingCart test all scenarios
    @Given("User is on the Magic Mouse Page")
    public void on_Magic_Mouse_Page() throws Throwable {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/");
    }
    
    // A step for ShoppingCart test all scenarios
    @When("User Click on the Add To Cart button")
    public void user_Click_Add_To_Cart() throws Throwable {
        //Thread.sleep(3500);
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"single_product_page_container\"]/div[1]/div[2]/form/div[2]/div[1]")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"single_product_page_container\"]/div[1]/div[2]/form/div[2]/div[1]")).click();       
    }
    
    // A step for ShoppingCart test all scenarios
    @Then("User Click on the Go to Checkout Button")
    public void user_Click_Go_To_Checkout() throws Throwable {
        //Thread.sleep(3500);
        wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"fancy_notification_content\"]/a[1]")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"fancy_notification_content\"]/a[1]")).click();       
    }
    
    // A step for ShoppingCart test scenario 1
    @Then("User will get to the (.*) page")
    public void user_Successfully_Go_To_Checkout_Page(String title) throws Throwable {
        //Thread.sleep(6000);
        wait.until(ExpectedConditions.titleContains(title));
        //assertEquals(title, driver.getTitle());
    }
    
    // A step for ShoppingCart test scenario 2 and 3
    @Then("Change the Quantity to (.*)")
    public void user_Change_Quantity(String num) throws Throwable {
        Thread.sleep(7000);
        //wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")).clear();
        driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")).sendKeys(num);        
        driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[4]")).click();
    }
    
    // A step for ShoppingCart test scenario 2
    @Then("the total price will be (.*)")
    public void total_Price(String price) throws Throwable {
        Thread.sleep(6000); 
        //wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[5]/span/span")).getText() == price);
        String realPrice = driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[5]/span/span")).getText();
        assertEquals(price, realPrice);
    }
    
    // A step for ShoppingCart test scenario 3 and 4
    @Then("the sentence \"(.*)\" will show up on the page")
    public void empty_Cart(String warning) throws Throwable {
        Thread.sleep(6000);
        //wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"post-29\"]/div")).isDisplayed());
        String sentence = driver.findElement(By.xpath("//*[@id=\"post-29\"]/div")).getText();
        assertEquals(warning, sentence);
    }
    
    // A step for ShoppingCart test scenario 4
    @Then("Click on Remove button")
    public void click_Remove() throws Throwable {
        Thread.sleep(6000); 
        //wait.until((Predicate<WebDriver>)d -> d.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[6]/form/input[4]")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[6]/form/input[4]")).click();
    }
    
    // Close the browser after a test
    @After
    public void cleanUp() {
        driver.quit();
    }
}
