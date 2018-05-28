# Home test task

I have provided the updated version of automated web test suite.
It is having all the required 10 updates as requested in the initial README.md document.


# Libraries Used

* Selenium:
    To incorporate web tests.
* TestNG:
    To perform parallel exection of test.
    To perform cross browser/platform test.
    To generate human readable report.
* Log4J:
    To perform logging across test application for all test cases.
* Org.JSON:
    To parse the json file and retrieve the test data for "Checkout" test case.



Solution includes the following:

* Logging
    - Implemented using Log4J.
* Taking screenshot on failed tests
    - BaseClass contains the feature to capture screen for failed test cases.
* Generation human readable report
    - Available in the "/src/test/resources/failure_screencaptures" directory.
* Generating random values for insignificant test data, for example, for new user
    - Used a "TestDataGenerator" class in the utiltity package for filling random values in "SignTest" for new user.
* WebDriver factory
    - WebDriverFactory class is added as part of base package to enable WebDriver initialization for
    cross browser and platform test.
* Encapsulation layers like test data, logic of tests, actions on web pages and so on
    - PageFactory design pattern is used to have a clean separation of layers consisting of test data, logic
    and actions on web pages.
* configurator(via testng.xml file):
  * run tests in parallel mode;
    - Test cases executed in parallel with maximum thread count of 3.
  * ability to run tests for different browsers/OS by configuring;
    - Test can run on windows/mac/linux OS for chrome/firefox browsers using parameters in testng.xml file.
  * ability to run tests for different environments(urls) by configuring/by command-line.
    - Environment url can be passes via command line if not it will default back to "http://automationpractice.com/index.php".
* reading test data from file, for example, the name of dress, size and color in the checkout test.
