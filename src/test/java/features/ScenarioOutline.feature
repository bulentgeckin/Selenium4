@test
Feature: DataTableDemo


  @ScenarioOutlineDemo
  Scenario Outline: Scenario Outline Demo
    Given print "<email>", "<username>" , "<password>"
    Examples:
      | email       | username | password  |
      | email1@gmail | user1    | password1 |
      | email2@gmail | user2    | password3 |
      | email3@gmail | user2    | password3 |
