Feature: CheapestPoplar
 
  Scenario: Get all the dresses (their names) in the popular section and select the cheapest one with its name
  
    When Poplar Dresses
    Then Get Less Price
    Then Move to Card
   Then Register
     Then Check Pay
     Then Confirm
    