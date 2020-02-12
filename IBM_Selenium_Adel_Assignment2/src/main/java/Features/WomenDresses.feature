Feature: Women Dresses
 
  Scenario: From the women, get the names of the all dresses then get all the dresses that have discounts and add them to the cart, along with getting the discount percentage
   
    When Women Dresses Displayed
    Then Get Discound Price
    Then Move to Card
    Then Register
     Then Check Pay
     Then Confirm
     
    