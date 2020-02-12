Feature: Saller Poplar
 
  Scenario: Get all the dresses (their names) in the Saller and select the most expensive one with its name
  
    When Saller Dresses
    Then Get Max Price
    Then Move to Card
     Then Register
      Then Check Pay
           Then Confirm
      
    