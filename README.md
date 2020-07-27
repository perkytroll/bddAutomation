
# bddAutomation
Basic E2E UI flow Automation framework using Selenium-Java
- This framework incorporates TestNG and Cucumber for writing End to End tests.
- This framework uses TestNG annotations with Cucumber's easy to read Gherkin syntax to write Acceptance tests
- We can specify tags on Cucumber Scenarios and specify during runtime which Scenarios we want to execute
- Uses Maven for building Projects and Dependency management

### Pre - Requisites
Please install the listed versions of software's to avoid any exceptions while executing the Test Suite
- **Java** : Version 8
- **Apache Maven** : Version 3.6.2
- **Chrome** : Version 84
- **Firefox** : Version 78
```bash
 git clone git@github.com:perkytroll/bddAutomation.git
 cd bddAutomation
 ```


### Writing Tests
#### Features
- Cucumber lets anyone write Acceptance tests and closes the gap between the Business people and people who have more of a technical responsibility.
- The above is achieved by specifying a set of rules to be followed while writing tests in Gherkin
- For Example:
```gherkin
@test1
  Scenario: Register as a new user
    Given I register as an "endUser"
    When I login as the registered user
    Then I should be able to login
```


|Keywords                |Usage                                               |
|----------------|----------------------------|
|Scenario            |It specifies the rule or what the steps in Scenario have to achieve|
|Given            |It specifies the preconditions that should be set before actual test|
|When|It specifies the actual actions that have to be performed in test |	
|Then|It is used to assert whether the result of all the actions is as expected|
- For more info on the significance of Gherkin keywords and other ways to write Scenario's, please refer to [Cucumber Documentation]([https://cucumber.io/docs/gherkin/reference/)

#### Glue Code
```java
@When("^I register as an (.*)$")
    public void registerAsGivenUser(String userType) {
		UserRegistrationPage urp = new UserRegistrationPage(driver, context);
		urp.pageLoader();
		urp.fillRegistrationForm();
		urp.clickSignUp();
    }
```

### Running Scripts

- Setting up drivers for test execution - If on a Windows OS

> ./setupDrivers.bat
- If on a Linux/MacOS environment
> ./setupDrivers.sh
- After the Drivers have been downloaded and extracted, its time to execute the suite