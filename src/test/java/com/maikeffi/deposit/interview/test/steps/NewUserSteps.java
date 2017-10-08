package com.maikeffi.deposit.interview.test.steps;

import com.maikeffi.deposit.interview.automate.core.CHDriver;
import com.maikeffi.deposit.interview.automate.manager.Manager;
import com.maikeffi.deposit.interview.automate.page.NewUser;
import cucumber.api.java8.En;

import static com.maikeffi.deposit.interview.test.runner.PortalTest.manager;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class NewUserSteps implements En  {




    NewUser newUser;


    public NewUserSteps() {

        Given("^a new (\\S+) instance$", (String browser) -> {
            // Write code here that turns the phrase above into concrete actions
            //throw new PendingException();
            if (browser.equals("chrome")){newUser = new NewUser(manager.getCrDriver().getDriver());}

        });

        Given("^navigate to (\\S+)$", (String urlName) -> {
            // Write code here that turns the phrase above into concrete actions
            //throw new PendingException();
            String url = manager.getProItem().getItemFromProp("newUserUrl");
            System.out.println(url);
            newUser.navigateNewUserUrl(url);

        });

        Given("^submit form with values (\\S+) , (\\S+) , (\\S+) and (\\S+)$", (String name, String email, String pwd , String cnfPwd) -> {
            // Write code here that turns the phrase above into concrete actions
           // throw new PendingException();
            newUser.setValuesOnPage(name,email,pwd,cnfPwd);
            newUser.clickSubmitButton();
        });

        Then("^page changes to (.*)$", (String title) -> {
            // Write code here that turns the phrase above into concrete actions
            //System.out.println(title);
            assertEquals("Title of page",title,newUser.getNewUserPageTitle());
            //manager.kill();
           // throw new PendingException();
        });
        Then("^user name error message should appear$", () -> {
            // Write code here that turns the phrase above into concrete actions
            //Must be unique
            //Required
            assertThat(newUser.getUserNameErrorMessage(),isOneOf("Must be unique","Required"));
            //manager.kill();
            // throw new PendingException();
        });

        Then("^email error message should appear$", () -> {
            // Write code here that turns the phrase above into concrete actions
            //Must be unique
            //Required
            //Invalid email address
            // throw new PendingException();

            assertThat(newUser.getEmailErrorMessage(),isOneOf("Must be unique","Required","Invalid email address"));


        });

        Then("^passwords are not the same should appear$", () -> {
            // Write code here that turns the phrase above into concrete actions
            //Must be unique
            //Required
            //Invalid email address
            // throw new PendingException();

            assertThat(newUser.getPassworNotSameErrorMessage(),isOneOf("passwords are not the same"));


        });

    }
}
