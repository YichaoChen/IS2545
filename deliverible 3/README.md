# IS2545 - DELIVERABLE 3: E-Commerce Website Testing

Notice: 
Since I wrote this assignment on Mac, if you are going to run the code using Windows system, please change the line in setUp() method to "System.setProperty("webdriver.gecko.driver", "libs\\geckodriver.exe");". 
I developed them in NetBeans. In order to run those tests, please firstly open StepDefinitions.java in NetBeans and click "Test File" under "Run", and then do the same thing to TestRunner.java.


Configurations:
There are three user stories for testing and they are wrote in three feature files seperately: UserLogin.feature, Search.feature and ShoppingCart.feature. They have 10 scenarios in total(UserLogin(4), Search(2) and ShoppingCart(4)).

I wrote those codes in modules since many scenarios share the same steps, so that those steps can be reused many times, which would help me avoid repeating works. I gave them comments so that it would be clear which scenarios include those steps.


Problems:
One of the problem I met during designing those tests was I couldn't tell when would the page finish its loading, since I couldn't locate the element in the page before it finishing loading or, at least, partially loading. The code never waits for the page's content, some test cases related to element locating failed due to slow page loading. Good news was the WebDriverWait can help me to continue waiting the web element until it showed up. The wait.until method works for many steps except for some test steps, for example, determine the total price in shopping cart after changing the quantity. Since the "div"(or web element) for total price in that page was already there before user made any change, the wait.until cannot work for status changing detection. After I made the quantity change, the code would still grad me a former total price. So I used Thread.sleep() to make sure the total price changed before I get its content. (I set it a relatively long time since the internet speed varies). 
I tried Dustin's wait.until plus "==" the new total price for it but it seems doesn't work so I have to choose the sleep method.
