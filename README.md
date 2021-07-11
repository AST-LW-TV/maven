# Maven

## Project Description

> 1. **Google HomePage Automation** \
     In this project is used to understand the Unit Test Concept. \
     *Unit Tests are written to test the individual functionality of the method / function*. \
     The test cases involve as follows, \
     ->  **PageNavigatedTest** - This test is used to check whether the Home page is navigated to other page. \
     -> **SearchStringValidationTest** - This test is used to validate whether desired search text is entered into
     search input field present in Home page. \
     ->  **TextVerificationTest** - This text is used to verify if the text shown on links matches the Actual value.

> 2. **Simple Math Function** \
     These Scripts are written to understand the Integration Test Concept \
     *Integration Tests are written to check functioning of modules when combined*. \
     *mathoperations* package has three classes, \
     -> **Addition** class - performs addition of two operands and returns sum.  \
     -> **Subtraction** class - performs subtraction and returns difference. \
     -> **Formula** class - Applies simple formula -> **sum x difference**. <br/>
     Integration Test \
     **IntegrationIT** class checks whether the values returned by individual classes *(Addition & Subtraction)* is same as calculated in Formula class

## Commands

### General maven commands 

- to clean the project and removes all the files generated in previous build

```
mvn clean 
```

- to compile the prpoject 

```
mvn compile 
```

- to execute all the unit tests in test directory

```
mvn test 
```

- to execute particular unit test 

```
mvn -Dtest=<name_of_the_test_file> test
```

- to execute integration tests and unit tests together 
```
mvn verify
```

- using failsafe maven plugin, we can run only integration tests

```
mvn failsafe:integration-test failsafe:verify 
```

### Commands used in this Project

First Task - created a project with maven 

Second Task - taking the properties from maven CLI

- property - browserFromCMD
    - expected **value** - chrome or firefox
    <p>&nbsp;</p>
- to execute single file unit test 
     - -Dtest=PageNavigatedTest
     - -Dtest=SearchStringValidationTest 
     - -Dtest=TextVerificationTest
    
#### mvn commands
  - to execute the test in chrome browser
```
mvn -DbrowserFromCMD=chrome test
```

- to execute the test in firefox browser
```
mvn -DbrowserFromCMD=firefox test
```

- to execute individual test files 
```
mvn -DbrowserFromCMD=<value> -Dtest=PageNavigatedTest test

mvn -DbrowserFromCMD=<value> -Dtest=SearchStringValidationTest test

mvn -DbrowserFromCMD=<value> -Dtest=TextVerificationTest test
```

Third Task - using profile tag to separate development and production stage

#### mvn commands


- to execute the development phase profile - runs in headless mode and in chrome

```
mvn -P developmentPhase test

# execute particular test file in development phase
mvn -P developmentPhase -Dtest=PageNavigatedTest test
```

- to execute the production phase profile - runs in headless mode and in firefox 

```
mvn -P productionPhase test
```

Additional Task 

- to execute the integration tasks 

```
# executes IntegrationIT integration test
mvn failsafe:integration-test failsafe:verify
```
