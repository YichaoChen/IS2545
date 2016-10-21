Feature: Shopping Cart Operations
 
        Scenario: Add an item to the Shopping Cart and can go to Checkout Page
                  Given User is on the Magic Mouse Page
                  When User Click on the Add To Cart button
                  And User Click on the Go to Checkout Button
                  Then User will get to the Checkout | ONLINE STORE page

        Scenario: Change the Quantity with a positive number on the Checkout page and the total price will change
                  Given User is on the Magic Mouse Page
                  When User Click on the Add To Cart button
                  And User Click on the Go to Checkout Button
                  And Change the Quantity to 5
                  Then the total price will be $750.00

        Scenario: Change the Quantity to ZERO on the Checkout page and there will be no item in the Cart
                  Given User is on the Magic Mouse Page
                  When User Click on the Add To Cart button
                  And User Click on the Go to Checkout Button
                  And Change the Quantity to 0
                  Then the sentence "Oops, there is nothing in your cart." will show up on the page

        Scenario: Remove the item on the Checkout page and there will be no item in the Cart
                  Given User is on the Magic Mouse Page
                  When User Click on the Add To Cart button
                  And User Click on the Go to Checkout Button
                  And Click on Remove button
                  Then the sentence "Oops, there is nothing in your cart." will show up on the page