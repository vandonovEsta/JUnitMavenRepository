Feature: Sum feature
  Rule: Integer sum
    Scenario: User successfully sums two integers
      Given user sums two ints: 3 and 5
      Then user should get 8 integer


  Rule: Float sum
    Scenario: User successfully sums two float numbers
      Given user sums two floats: 1.2 and 3.0
      Then user should get 5.2

  Rule: Double sum
    Scenario: User successfully sums two double numbers
      Given user sums two doubles: 1.2 and 3.0
      Then user should get 4.2 double