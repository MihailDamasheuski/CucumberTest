Feature: My first cucumber experience
  @Thread1
  Scenario Outline: First cucumber test
    Given manage driver
    When go to "<url>" website
    When click register button
    When fill in register form fields with creds: "<NickName>", "<pswd>"
    When submit form
    Then confirm registration
    Then kill driver
    Examples:
      |NickName  | pswd  |          url         |
      | XaycuTo  |fk3hbf3| http://goodgame.ru/  |