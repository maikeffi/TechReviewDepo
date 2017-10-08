@NewUser
Feature: Create New User

  Verify Create User Form and check Constrains as given below

  Background: Open browser
    Given I open chrome browser

  @NewUser-001
  Scenario Outline:  Test New User url with Valid values
    When I enter Url for New User in the browser
    And I enter values <name>,<email>,<password> and <cnfpassword>
    And I submit the form
    Then All Users Page Should Open
    Then user data <name>,<email>,<password> should appear on get all user api
    Examples:
      |name |email |password|cnfpassword|
      |adasd|adasd@mail.com|123|123|
      |bcd|bcd@mail.com|234|234|

  @NewUser-002
  Scenario Outline: Test New User url with Duplicate User Name and email
    When I enter Url for New User in the browser
    And I enter values <name>,<email>,<password> and <cnfpassword>
    And I submit the form
    And I enter Url for New User in the browser
    And I enter values <name>,<email>,<password> and <cnfpassword>
    And I submit the form
    Then I Should get name error message Must be unique
    Then I Should get email error message Must be unique
    Examples:
      |name |email |password|cnfpassword|
      |adasd|adasd@mail.com|123|123|
      |bcd|bcd@mail.com|234|234|

  @NewUser-003
  Scenario Outline: Test New User url with invalid email
    When I enter Url for New User in the browser
    And I enter values <name>,<email>,<password> and <cnfpassword>
    And I submit the form
    Then I Should get email error message Invalid email address
    Examples:
      |name |email |password|cnfpassword|
      |adasd|adasd@mail|123|123|
      |keffi|@keffi|456 |456|

  @NewUser-004
  Scenario Outline: Test New User URl Password confirmation
    When I enter Url for New User in the browser
    And I enter values <name>,<email>,<password> and <cnfpassword>
    And I submit the form
    Then I Should get password error message passwords are not the same
    Examples:
      |name |email |password|cnfpassword|
      |adasd|adasd@mail.com|123|12345|
      |keffi|bcd@mail.com|456 |456123|

  @NewUser-005
  Scenario Outline: Test New User URl for compulsory Password
    When I enter Url for New User in the browser
    And I enter values <name>,<email>
    And I submit the form
    Then I Should get password error message Required
    Examples:
      |name |email |
      |adasd|adasd@mail.com|
      |keffi|bcd@mail.com|

