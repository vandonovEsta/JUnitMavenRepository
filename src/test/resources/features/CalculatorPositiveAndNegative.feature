Feature: Compare positive and negative numbers sum or difference

  Scenario: Sum operation
    Given I have the following sets of numbers:
      | 3 | -1 |
      | 2 | -5 |
    When I do sum of the numbers in each column
    Then The result of each column should be printed out

  Scenario: Subtraction operation
    Given I have the following sets of numbers:
      | 3 | -1 |
      | 2 | -5 |
    When I do subtraction of the numbers in each column
    Then The result of each column should be printed out