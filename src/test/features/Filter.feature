@test
@filter
Feature: As a user I want to be able to filter products

  Background:
    Given User is logged in

  Scenario Outline: Filter items by <filterType>
    Given "PRODUCTS" page is open
    When I filter items by "<filterType>"
    Then I verify that items are ordered by "<filterType>"

    Examples:
      | filterType          |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

