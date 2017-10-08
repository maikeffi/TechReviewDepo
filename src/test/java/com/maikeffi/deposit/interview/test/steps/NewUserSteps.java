package com.maikeffi.deposit.interview.test.steps;

import com.maikeffi.deposit.interview.automate.core.CHDriver;
import com.maikeffi.deposit.interview.automate.manager.Manager;
import com.maikeffi.deposit.interview.automate.model.User;
import com.maikeffi.deposit.interview.automate.page.AllUserPage;
import com.maikeffi.deposit.interview.automate.page.NewUser;
import com.maikeffi.deposit.interview.automate.utils.UserClient;
import cucumber.api.java8.En;

import java.util.List;

import static com.maikeffi.deposit.interview.test.runner.PortalTest.manager;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class NewUserSteps implements En  {




    NewUser newUser;
    AllUserPage allUserPage;



    public NewUserSteps() {

        Given("^a new (\\S+) instance$", (String browser) -> {

            if (browser.equals("chrome")){
                newUser = new NewUser(manager.getCrDriver().getDriver());
                allUserPage = new AllUserPage(manager.getCrDriver().getDriver());
            }

        });

        When("^we delete all user entries$", ()->{

        });

        Given("^navigate to (\\S+)$", (String urlName) -> {

            String url = manager.getProItem().getItemFromProp(urlName);
            System.out.println(url);
            newUser.navigateNewUserUrl(url);

        });

        Given("^submit form with values (\\S+) , (\\S+) , (\\S+) and (\\S+)$", (String name, String email, String pwd , String cnfPwd) -> {

            newUser.setValuesOnPage(name,email,pwd,cnfPwd);
            newUser.clickSubmitButton();
        });

        Given("^submit form with values (\\S+) and (\\S+)$", (String name, String email) -> {

            newUser.setValuesOnPage(name,email);
            newUser.clickSubmitButton();
        });

        Given("^when delete rest api is invoked$", () -> {
            manager.getUserClient().deleteAll();
        });

        Then("^no user is displayed$", () -> {
            assertEquals("No User Test",allUserPage.getNoUserText(),"No Users");
        });



        Then("^page changes to (.*)$", (String title) -> {

            assertEquals("Title of page",title,newUser.getNewUserPageTitle());

        });



        Then("^user name error message should appear$", () -> {

            assertThat(newUser.getUserNameErrorMessage(),isOneOf("Must be unique","Required"));


        });

        Then("^email error message should appear$", () -> {


            assertThat(newUser.getEmailErrorMessage(),isOneOf("Must be unique","Required","Invalid email address"));


        });

        Then("^passwords are not the same should appear$", () -> {


            assertThat(newUser.getPassworNotSameErrorMessage(),isOneOf("passwords are not the same"));


        });

        Then("^password is required message should appear$", () -> {


            assertThat(newUser.getPasswordRequiredErrorMessage(),isOneOf("Required"));


        });

        Then("^added users should be displayed$", () -> {

            List<User> users = manager.getUserClient().findAll();
            users.forEach(user -> {
                System.out.println(user.getName());
            });





        });

        Then("^the rest api json should have user details$", () -> {

        });



    }
}
