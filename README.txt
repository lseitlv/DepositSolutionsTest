# DepositSolutionsTest
Implementation of automated tests for the "New User" use case

To implement the automated tests for the New User page, the following tools were used:
Eclipse (Oxygen) project with Maven integration and JDK 1.9
Selenium Webdriver 3.8 with TestNG framework

The tests were implemented using Mozilla Firefox browser as the test platform, because it contains the native engine GeckoDriver that communicates with Webdriver, making the test setup quicker. The tests can be easily ported to different web browsers by parameterizing the WebDriver definition, so it's possible to execute the same test cases using different drivers.

The Test Cases defined for the New User webpage are defined in the TestCases.txt file.

To execute the tests, right click the testng.xml file (suite file) and click on Run As -> TestNG Suite. Since the GeckoDriver location is defined for the test, it might be required to update it.

Challenges and final considerations:

The initial setup of Eclipse, that was the work environment of choice, with Webdriver and a git reporisoty, was a bit challenging, since several issues had to be solved. The JAR files required for WebDriver integration were conflicting and not properly recognized by the project. Also, there were difficulties to push the initial project commit into a remote repository. The solution I found was to create a new remote repo, clone it into my local environment and create the eclipse workspace inside it.

To guarantee that the tests cases remained independent from one another, a step was inserted to navigate to the initial URL before the execution of each test. In this case, even if some operation causes the web page to be unavailable - e.g. some action caused a 404 Page Not Found error - the remaining tests would still be executed.

There are some additional required efforts to turn this test suite, that is a proof of concept, into an embracing and efficient test suite for this use case. The first next step would be to parameterize the creation of the Webdriver, so the same set of tests could be run in a different web browser. In some cases, it may be necessary to make small changes to the tests to make it possible to execute them smoothly in other browser, such as adjustments on the html elements that are used to locate them.

Additionally, a report system should be implemented. TestNG framework provides a report generation engine that allows us to add relevant milestones/checkpoints to an organized report file, that is automatically generated during suite execution.

Another extension that sould be made to improve this test suite would be to integrate the available REST requests, Get all users and DELETE all users. GET all users could be used after attempt of new user creation, to verify whether or not the user was created. DELETE all users could be used by the end of each suite execution, so that the suite is ready to run automatically once more, without the need of manually cleaning the database to avoid duplicated users.