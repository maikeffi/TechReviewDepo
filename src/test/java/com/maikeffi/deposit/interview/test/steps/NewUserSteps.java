package com.maikeffi.deposit.interview.test.steps;

import com.maikeffi.deposit.interview.automate.core.CHDriver;
import com.maikeffi.deposit.interview.automate.manager.Manager;
import com.maikeffi.deposit.interview.automate.page.NewUser;
import cucumber.api.java8.En;

import static com.maikeffi.deposit.interview.test.runner.PortalTest.manager;


public class NewUserSteps implements En  {




    NewUser newUser;


    public NewUserSteps() {

        Given("^a new browser instance$", () -> {
            // Write code here that turns the phrase above into concrete actions
            //throw new PendingException();
            newUser = new NewUser(manager.getCrDriver().getDriver());
        });

        Given("^navigate to (.*)$", (String url) -> {
            // Write code here that turns the phrase above into concrete actions
            //throw new PendingException();
            System.out.println(url);
            newUser.navigateNewUserUrl(url);

        });

        Then("^the title is (.*)$", (String title) -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println(title);
            //manager.kill();
           // throw new PendingException();
        });


    }
}
