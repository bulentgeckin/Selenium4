Feature: DataTableDemo


  @dataTableDemo
  Scenario: Data Table
    Given print e-mail,username and password to screen
      | email            | username | password     |
      | abc@gmail.com    | abc      | abc1234      |
      | xyz@hotmail.com  | xyz      | xyz1234      |
      | noname@gmail.com | noname   | noname123123 |