@newuser
Feature: Create New User
  Verify Create User Form Constrains

  @addnewuser-positive
  Scenario Outline: Check New User Url
    Given a new chrome instance
    And navigate to newUserUrl
    And submit for with values <name> , <email> , <password> and <cnfpassword>
    Then page changes to All User
    Examples:
      |name |email |password|cnfpassword|
      |adasd|adasd@mail.com|123|123|
      |bcd|bcd@mail.com|234|234|

  @addnewuser-name-constrain
  Scenario Outline: Check User Name Constrain
    Given a new chrome instance
    And navigate to newUserUrl
    And submit for with values <name> , <email> , <password> and <cnfpassword>
    Then user name error message should appear
    Examples:
      |name |email |password|cnfpassword|
      |adasd|ijk@mail.com|123|123|

