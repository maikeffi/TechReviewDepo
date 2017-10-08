**User Addition/Registration Test** 

This is a test suite to Test the addition of New User to a Web portal

Use git clone https://github.com/maikeffi/TechReviewDepo.git to clone repo 

cd into cloned folder and from command line type mvn test .

In the PortalTest.java if needed to run only one specific scenario change the tags cucumber option
To run all test cases tags = {"@newuser"}  

List of test cases in feature file:

**@deletealluser-clean-data** -- test delete url and sets up test environment for testing 

**@addnewuser-positive** -- positive test scenario to Test creation of user

**@addnewuser-name-constrain** -- test scenario to check constrains on user name (Must be unique & Required)

**@addnewuser-email-constrain** -- test scenario to check constrains on user email (Must be unique & Required & Invalid email address)

**@addnewuser-password-constrain** -- test scenario to check constrains on password confirmation (passwords are not the same)
   
**@addnewuser-password-constrain-required** -- test scenario on constrains on password (Required)

**@addnewuser-name-email-constrain-using-existing-data** -- Uses rest api to fetch data from environment and checks for   constrains on user name & email (Must be unique & Required)

 **@check-all-users**    -- uses rest api to check all users are listed on all users page.


 

