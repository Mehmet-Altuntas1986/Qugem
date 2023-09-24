package com.company.Qugem.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/testReports/htmlReport/htmlReport.html",
                "json:target/testReports/jsonReport/jsonReport.json",
                "junit:target/testReports/junitReport/junitReport.xml",


                "rerun:target/rerun.txt"
        },

        stepNotifications = true, // Senaryo adımı bildirimlerini etkinleştir
        monochrome = true,
        publish = true,

        features = "src/test/resources/features",
        glue = {"com/company/Qugem/stepDefinitions", "com/company/Qugem/hooks"},
        dryRun = false,
        tags = "a"


)
public class CukesRunner {
}


//VERY IMPORTANT
//HOOK CLASS AND STEPDEFINITION SHOULD BE IN THE SAME PACKAGE , OTHERWISE HOOKS DONT RUN
//in this case solution is to show its path also in glue




 /*
dryRun = true-> glue code execution should be skipped ,will print out the missing step definitions in the console output.

dryRun: Set to false to execute the test steps

monochrome = true, --> the console output will be displayed without colored formatting.

features: Specifies the directory where your feature files are located.

glue: Specifies the package where your step definitions are located.

tags: Allows you to filter scenarios to be executed based on tags. Empty tags mean all scenarios will be executed.

 publish = true,--> publisable html report link appears in console after Test run

 plugins added

"pretty": Produces human-readable console output.

"html:target/testReports/htmlReport/htmlReport.html": Generates an HTML report in the specified directory.
"json:target/testReports/jsonReport/jsonReport.json": Generates a JSON report in the specified directory.
"junit:target/testReports/junitReport/junitReport.xml": Generates a JUnit XML report in the specified directory.
"rerun:target/rerun.txt": Stores information about failed scenarios for rerun purposes.

        Other Options:


mvn clean test -Dcucumber.filter.tags="@smoke" -Dbrowser=chrome



  */

