Feature: Sum or subtraction of positive or negative numbers

  Scenario: Calculate from table
    Given user has the following data
      | Positive | Negative | Operation   |
      | 3        | -1       |             |
      | 2        | -5       | sum         |
      | 3        | -1       |             |
      | 2        | -5       | subtraction |
    When user calculates
    Then user Print results