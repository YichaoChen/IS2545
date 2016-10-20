Feature: User Login Action
 
        Scenario: Successful Login with Valid Credentials
                  Given User is on Home Page
                  When User Navigate to LogIn Page
                  And User logged in using username as cyc and password as testcycyic85
                  Then Message displayed on the right upper corner should be Howdy, cyc


        Scenario: Log out after successful Login
                  Given User is on Your Account Page
                  When User logged in using username as cyc and password as testcycyic85
                  And User click on Log out                  
                  Then Message displayed on the page should be You are now logged out.


        Scenario: Login with Invalid Credentials
                  Given User is on Your Account Page
                  When User logged in using username as cyc and password as test                 
                  Then Message displayed on the page will be ERROR: Invalid login credentials.

        
        Scenario: Login with blank Credentials
                  Given User is on Your Account Page
                  When User logged in without typing the username and the password                 
                  Then Message displayed on the page must be Please enter your username and password.

        
