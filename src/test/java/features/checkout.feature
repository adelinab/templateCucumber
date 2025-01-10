
Feature: Search and place the order for products

  @PlaceOrder
  Scenario Outline: search experience in home and offers page
    Given user is on greencart landing page
    When user searched with shortname <Name> and extracted actual name of product
    And added "3" items of the selected product to cart
    Then user proceeds to checkout and validate the <Name> items in checkout page
    And user has ability to enter promo code and place the order
    
    Examples:
    | Name |
    | Tom |
    