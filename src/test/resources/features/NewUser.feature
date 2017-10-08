@newuser
Feature: Create New User
  Verify Create User Form Constrains

  @newuser-positive
  Scenario Outline: Check New User Url
    Given a new chrome instance
    And navigate to http://85.93.17.135:9000/user/new
    Then the title is New User
    Examples:
      |name |email |password|cnfpassword|
      |adasd|adasd@mail.com|123|123|
      |bcd|bcd@| ||

