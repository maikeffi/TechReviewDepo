@newuser
Feature: Create New User
  Verify Create User Form Constrains

  @newuser-positive
  Scenario Outline: Check New User Url
    Given a new browser instance
    And navigate to <url>
    Then the title is <title>
    Examples:
      |url |title |
      |https://www.google.co.in/|New User|
      |https://www.facebook.com/|FB User|

