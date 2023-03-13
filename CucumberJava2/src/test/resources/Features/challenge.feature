#Author
#Date
#Description
Feature: Challenge test


  Scenario Outline: Confirm all devices price
    Given prepared setup
    And user go to the home page
    When hits english language
    And validate list of prices in the range
    And choose a random range price
    And users chooses the follow <range_price>

    Examples:
      | range_price |
      | THB 2,000 - 6,000 |


