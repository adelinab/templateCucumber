
Feature: Search and place the order for products

  @tag3
  Scenario: search experience in home and offers page
    Given user is on greencart landing page
    When user searched with shortname "Tom" and extracted actual name of product
    Then user searched for same shortname "Tom" in offers page
    And validate product name in offers page matches with landing page

@tag1
  Scenario Outline: search experience in home and offers page
    Given user is on greencart landing page
    When user searched with shortname <Name> and extracted actual name of product
    Then user searched for same shortname <Name> in offers page
    And validate product name in offers page matches with landing page
    
    Examples:
    | Name |
    | Tom |
    | Beet |
    
  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
