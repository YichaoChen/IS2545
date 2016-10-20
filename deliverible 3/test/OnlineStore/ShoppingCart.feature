Feature: Shopping Cart Operations
 
        Scenario: Add an item to the Shopping Cart and Go Checkout
                  Given User is on the Magic Mouse Page
                  When User Click on the Add To Cart button
                  And User Click on the Go to Checkout Button
                  Then User will get to the Checkout | ONLINE STORE page

        Scenario: Change the Quantity with a positive number in the Checkout page
                  Given User is on the Magic Mouse Page
                  When User Click on the Add To Cart button
                  And User Click on the Go to Checkout Button
                  And Change the Quantity to 5
                  Then the total price will be $750.00

        Scenario: Change the Quantity to ZERO in the Checkout page
                  Given User is on the Magic Mouse Page
                  When User Click on the Add To Cart button
                  And User Click on the Go to Checkout Button
                  And Change the Quantity to 0
                  Then the sentence "Oops, there is nothing in your cart." will show up on the page

        Scenario: Remove the item in the Checkout page
                  Given User is on the Magic Mouse Page
                  When User Click on the Add To Cart button
                  And User Click on the Go to Checkout Button
                  And Click on Remove button
                  Then the sentence "Oops, there is nothing in your cart." will show up on the page