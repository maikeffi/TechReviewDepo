package com.maikeffi.deposit.interview.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"},
        format = {"pretty", "html:target/reports/cucumber/html", "json:target/reports/cucumber/all_tests.json", "junit:target/reports/junit/all_tests.xml"},
        glue = {"com.maikeffi.deposit.interview.test.steps"},
        tags = {"@newuser"})
/**
 * Created by Kannan Maikeffi on 07-10-2017.
 */
public class PortalTest {
}
