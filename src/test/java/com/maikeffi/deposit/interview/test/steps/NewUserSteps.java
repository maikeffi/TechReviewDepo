package com.maikeffi.deposit.interview.test.steps;

import com.maikeffi.deposit.interview.automate.model.User;
import com.maikeffi.deposit.interview.automate.model.UserForm;
import com.maikeffi.deposit.interview.automate.page.AllUserPage;
import com.maikeffi.deposit.interview.automate.page.NewUserPage;
import cucumber.api.java8.En;

import java.util.List;

import static com.maikeffi.deposit.interview.test.runner.PortalTest.manager;
import static org.junit.Assert.*;


public class NewUserSteps implements En  {




    private NewUserPage newUserPage;
    private AllUserPage allUserPage;

    public NewUserSteps() {



        Given("^I open (\\S+) browser$", (String browser) -> {

            if (browser.equals("chrome")){
                newUserPage = new NewUserPage(manager.getCrDriver().getDriver());
                allUserPage = new AllUserPage(manager.getCrDriver().getDriver());
            }

        });

        When("^I Clean up Test Data$", () -> {
            manager.getUserClient().deleteAll();
        });

        When("^I enter Url for New User in the browser$", () -> {
            String url = manager.getProItem().getItemFromProp("newUserUrl");
            newUserPage.navigateNewUserUrl(url);
        });

        When("^I enter values (\\S+),(\\S+),(\\S+) and (\\S+)$", (String name,String email,String pwd, String cnfPwd) -> {
            UserForm userForm = new UserForm(name,email,pwd,cnfPwd);
            newUserPage.setValuesOnPage(userForm);
        });

        When("^I enter values (\\S+),(\\S+) except (\\S+)", (String one,String two,String type) -> {
            newUserPage.setValuesOnFormExceptType(one,two,type);
        });

        When("^I submit the form$", () -> {
            newUserPage.clickSubmitButton();
        });

        Then("^All Users Page Should Open$", () -> {
            assertEquals("Title of page","All User", allUserPage.getNewUserPageTitle());
        });



        Then("^I Should get (.*) error message (.*)$", (String type ,String expErrorMessage) -> {
            String errorMessage = newUserPage.getErrorMessageByType(type);
            assertEquals("Error Message ",errorMessage, expErrorMessage);
        });

        Then("^user data (\\S+),(\\S+),(\\S+) should appear on get all user api$", (String  name,String email , String pwd) -> {
            User expectedUser = new User();
            User actualUser = new User();
            Boolean isMatching = false;
            expectedUser.setName(name);
            expectedUser.setEmail(email);
            expectedUser.setPassword(pwd);
            List<User> users = manager.getUserClient().findAll();
            for (User user:users){
                if (user.equals(expectedUser)){
                    isMatching = true;
                    System.out.println(actualUser.getName());
                }
            }
            assertTrue("Check if two objects are equal",isMatching);
        });




    }
}
