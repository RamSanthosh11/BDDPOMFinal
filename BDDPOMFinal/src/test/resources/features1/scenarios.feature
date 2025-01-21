Feature: Place Order

Scenario: User Login
Given User is on login Page
When User enters credentials
  | username            | password   |
  | ramu33177@gmail.com | @Ramu4342  |

Then User should be on Home page

Scenario: Add Item to cart
Given User should be on Home page
When User add item to cart
Then Item must be added

Scenario: Checkout Order
Given User is on cart page
When User do checkout
Then Should navigate to Checkout page

Scenario: Delete an Item
Given Cart must have items
When User delete an item
Then Should delete item from cart
 
 
