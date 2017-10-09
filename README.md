**User Addition/Registration Test** 

This is a test suite to Test the addition of New User to a Web portal

Use git clone https://github.com/maikeffi/TechReviewDepo.git to clone repo 

cd into cloned folder and from command line type mvn test .

In the PortalTest.java if needed to run only one specific scenario change the tags cucumber option

To run all test cases tags = {"@NewUser"} 

To run two specific test give tags as comma separated  value , eg: {"@NewUser-006,@NewUser-007"} 

**_List of test cases in feature file:_**

**@NewUser-001** --  Test New User url with Valid values 

**@NewUser-002** -- Test New User url with Duplicate User Name and email

**@NewUser-003** -- Test New User url with invalid email

**@NewUser-004** -- Test New User URl Password confirmation

**@NewUser-005** -- Test New User URl for compulsory Password.

**@NewUser-006** -- Test New User Url for Compulsory user Name

**@NewUser-007** -- Test New User Url for Compulsory user email



 

