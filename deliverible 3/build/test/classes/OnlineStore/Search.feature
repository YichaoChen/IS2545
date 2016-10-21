Feature: User Search Action
 
        Scenario: User type a search term for an existing product and get the search result
                  Given User is on Home Page
                  When User Type "ipad" as keywords for searching                 
                  Then all related items should appear on search result page with clickable Add To Cart buttons


        Scenario: User type a search term for an non-existing product and cannot see any product
                  Given User is on Home Page
                  When User Type "aaa" as keywords for searching                 
                  Then on the result page the sentence "Sorry, but nothing matched your search criteria. Please try again with some different keywords." will appear


        

