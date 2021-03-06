@newuser
Feature: Create New User
  Verify Create User Form and check Constrains as given below

  @deletealluser-clean-data
  Scenario: Check Delete All Url
    Given when delete rest api is invoked
    And a new chrome instance
    And navigate to getAllUsersUrl
    Then no user is displayed

  @addnewuser-positive
  Scenario Outline: Check New User Url
    Given a new chrome instance
    And navigate to newUserUrl
    And submit form with values <name> , <email> , <password> and <cnfpassword>
    Then page changes to All User
    Then user data <name> , <email> , <password> should appear on get all user api
    Examples:
      |name |email |password|cnfpassword|
      |adasd|adasd@mail.com|123|123|
      |bcd|bcd@mail.com|234|234|



  @addnewuser-name-constrain
  Scenario Outline: Check User Name Constrain for  duplicate name
    Given a new chrome instance
    And navigate to newUserUrl
    And submit form with values <name> , <email> , <password> and <cnfpassword>
    Then user name error message should appear
    Examples:
      |name |email |password|cnfpassword|
      |adasd|ijk@mail.com|123|123|
      |bcd|lkj@mail.com|234|234|

  @addnewuser-email-constrain
  Scenario Outline: Check User Name Constrain for duplicate/valid email
    Given a new chrome instance
    And navigate to newUserUrl
    And submit form with values <name> , <email> , <password> and <cnfpassword>
    Then email error message should appear
    Examples:
      |name |email |password|cnfpassword|
      |Mike|adasd@mail.com|123|123|
      |john|bcd@mail.com|234|234|
      |jose|bcd@mail|234|234|
      |keffi|@keffi|456 |456|

  @addnewuser-password-constrain
  Scenario Outline: Check User Name Constrain for  password repeat must be the same
    Given a new chrome instance
    And navigate to newUserUrl
    And submit form with values <name> , <email> , <password> and <cnfpassword>
    Then passwords are not the same should appear
    Examples:
      |name |email |password|cnfpassword|
      |Mike|mike@mail.com|123|1234|
      |john|john@mail.com|234|2345|
      |jose|jose@mail.com|234|345|

  @addnewuser-password-constrain-required
  Scenario Outline: Check User Name Constrain for  password repeat must be the same
    Given a new chrome instance
    And navigate to newUserUrl
    And submit form with values <name> and <email>
    Then password is required message should appear
    Examples:
      |name |email |
      |Mike|mike@mail.com|

  @addnewuser-name-email-constrain-using-existing-data
  Scenario: Check User Name/email Constrain for  duplicates
    Given a new chrome instance
    And navigate to newUserUrl
    And submit form with values obtained from rest api
    Then user name error message should appear
    Then email error message should appear

  @check-all-users
  Scenario: Check if all users are displayed on UI
    Given a new chrome instance
    And navigate to getAllUsersUrl
    Then added users should be displayed