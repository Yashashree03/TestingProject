Feature:Login functionality 

  @tag1
  Scenario: Verify user is able to login into saucedmo website
    Given Launch browser
    And Open saucedemo browser
    When Enter username and password
    And Click on login
    Then Verify url of the website
    And Logout of the website

 
