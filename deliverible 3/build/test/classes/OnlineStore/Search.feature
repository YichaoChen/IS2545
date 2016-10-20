Feature: User Search Action
 
        Scenario: Successful Login with Valid Credentials
                  Given User is on Home Page
                  When User Type "ipad" as keywords for searching                 
                  Then all related items should appear on search result page with clickable Add To Cart buttons


        Scenario: Log out after successful Login
                  Given User is on Home Page
                  When User Type "aaa" as keywords for searching                 
                  Then on the result page the sentence "Sorry, but nothing matched your search criteria. Please try again with some different keywords." will appear


        

