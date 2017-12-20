# DepositSolutionsTest
Implementation of automated tests for the "New User" system

To implement the automated tests for the New User page, the following tools were used:
Eclipse project with Maven integration and JDK 1.9
Selenium Webdriver 3.8 with TestNG framework

The tests were implemented using Mozilla Firefox browser as the test platform, because it contains the native engine GeckoDriver that communicates with Webdriver, making the test setup quicker. The tests can be easily ported to different web browsers using TestNG to create test suites that execute the same test cases using different drivers.

The Test Cases defined for the New User webpage are defined in the TestCases.txt file.

To execute the tests, right click the testng.xml file (suite file) and click on Run As -> TestNG Suite.

Challenges and final considerations:

To guarantee that the tests cases remained independent from one another, a step was inserted to navigate to the initial URL before the execution of each test. In this case, even if some operation causes the web page to be unavailable - e.g. some action caused a 404 Page Not Found error - the remaining tests would still be executed.

The natural next step for this set of test cases would be to parameterize the creation of the Webdriver, so the same suite could be run in a different web browser. In some cases, it may be necessary to make small changes to the tests to make it possible to execute them smoothly in other browser, such as adjustments on the html elements that are used to locate them.

Another extension that could be made to improve this test suite would be to integrate the available REST requests, Get all users and DELETE all users. GET all users could be used after attempt of new user creation, to verify whether or not the user was created. DELETE all users could be used by the end of each suite execution, so that the suite is ready to run automatically once more, without the need of manually cleaning the database to avoid duplicated users.