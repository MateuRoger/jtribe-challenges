Feature: Users are able to calculate operations.
When users introduce two operands and one operation, the system will calculate the operation

  Scenario: The user be able to make adds
    Given I have a calculator
    When the user wants to execute the 2 + 2 operation
    Then the user gets 4

