@tag
Feature: Product

  @tag1
  Scenario: Verify the product Link is clickable or not
    Given Launch the chrome browser
    And Open Flipkart Site
    When Search the product
    And Clickon the search product
    Then Verify the product has been open or not by title

