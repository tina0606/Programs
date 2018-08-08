
@tag
Feature: Conference Registration
  I want to make a Conference Room Booking
  
  @execute
  Scenario: booking a conference room
    Given User is on Conference room booking page
    When User select 'Next' link without entering 'FirstName'  
   Then 'Please fill the First Name' message should display
   
    When User select 'Next' link without entering 'LastName'
    Then 'Please fill the Last Name' message should display
    
    When User select 'Next' link without entering 'Email'
    Then 'Please fill the Email' message should display
    
     When User select 'Next' link after entering invalid 'Email' address
    Then 'Please enter valid Email Id.' message should display
    
     When User select 'Next' link without entering 'Contact No'
    Then 'Please fill the Contact No.' message should display
    
     When User select 'Next' link without entering 'Contact No'
    Then 'Please fill the Contact No.' message should display

   When User select 'Next' link without selecting  'Number of people attending'
    Then 'Please fill the Number of people attending' message should display
    
   When  User select 'Next' link without entering  'Building Name & Room No'
    Then 'Please fill the Building & Room No' message should display
    
   When  User select 'Next' link without entering  'Area Name'
    Then 'Please fill the Area name' message should display
    
   When  User select 'Next' link without selecting  'City'
   Then  'Please select city' message should display
    
  When   User select 'Next' link without selecting  'State'
  Then   'Please select state' message should display
    
   When User select 'Next' link without selecting  'MemberShip Status
    Then 'Please Select MemeberShip status' message should display
    
  When  User select 'Next' link after entering Valid set of information
   Then 'Personal details are validated.' message should display
   
     When User select 'Make Payment' link without entering 'Card Holder Name'  
   Then 'Please fill the Card Holder Name' message should display
   
    When User select 'Make Payment' link without entering 'Debit Card Number'
    Then 'Please fill the Debit Card Number' message should display
    
     When User select 'Make Payment' link without entering 'CVV'
    Then 'Please fill the CVV' message should display
    
      When User select 'Make Payment' link without entering 'CVV'
    Then 'Please fill the CVV' message should display
    
      When User select 'Make Payment' link without entering 'Expiration month'
    Then 'Please fill the Expiration month' message should display
    
      When User select 'Make Payment' link without entering 'Expiration Year'
    Then 'Please fill the Expiration Year' message should display
    
     When  User select 'Make Payment' link after entering Valid set of information
   Then 'Conference Room Booking succesfully done!!!.' message should display
    
    
    
    
    

  