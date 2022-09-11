Feature: DataTableDemo

  @dataTableDemo
  Scenario: Data Table
    Given print e-mail,username and password to screen
      | email            | username | password     |
      | abc@gmail.com    | abc      | abc1234      |
      | xyz@hotmail.com  | xyz      | xyz1234      |
      | noname@gmail.com | noname   | noname123123 |

  @ScenarioOutlineDemo
  Scenario Outline: Scenario Outline Demo
    Given print "<email>", "<username>" , "<password>"
    Examples:
      | email       | username | password  |
      | email1@gmail | user1    | password1 |
      | email2@gmail | user2    | password3 |
      | email3@gmail | user2    | password3 |
