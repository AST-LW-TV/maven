# Maven

## Project Description

> 1. **Google HomePage Automation** 
- This project is used to understand the Unit Test Concept. 
-  *Unit Tests are written to test the individual functionality of the method / function*. 
-  The test cases involve as follows, 
    -  **PageNavigatedTest** - This test is used to check whether the Home page is navigated to other page. 
    - **SearchStringValidationTest** - This test is used to validate whether desired search text is entered in
        search input field present in Home page.
    - **TextVerificationTest** - This text is used to verify if the text shown on links matches the Actual value.

> 2. **Simple Math Function** 
- The Scripts are written to understand the Integration Test Concept 
- Integration Tests are written to check functioning of modules when combined. 
- **mathoperations** package has three classes, 
  - **Addition** class - performs addition of two operands and returns sum.  
  -  **Subtraction** class - performs subtraction and returns difference. 
  - **Formula** class - Applies simple formula -> **sum x difference**. <br/>
- *Integration Test*
  - **IntegrationIT** class - checks whether the values returned by individual classes *(Addition & Subtraction)* is same as calculated in Formula class

## Commands

### General maven commands 

- To clean the project and removes all the files generated in previous build

```
mvn clean 
```

- To compile the project 

```
mvn compile 
```

- To execute all the unit tests in test directory

```
mvn test 
```

- To execute particular unit test 

```
mvn -Dtest=<name_of_the_test_file> test
```

- To execute integration tests and unit tests together 
```
mvn verify
```

- Using failsafe maven plugin, we can run only integration tests

```
mvn failsafe:integration-test failsafe:verify 
```

### To Install the project

```
git clone https://github.com/AST-LW-TV/maven.git

# open the project in IntelliJ Editor
```

### Commands used in this Project

First Task - Created a project with maven 

Second Task - Taking the properties from maven CLI

- Property - browserFromCMD
    - expected **value** - chrome or firefox
- To execute single file unit test 
     - -Dtest=PageNavigatedTest
     - -Dtest=SearchStringValidationTest 
     - -Dtest=TextVerificationTest
    
#### mvn commands
  - To execute the test in chrome browser
```
mvn -DbrowserFromCMD=chrome test
```

- To execute the test in firefox browser
```
mvn -DbrowserFromCMD=firefox test
```

- To execute individual test files 
```
mvn -DbrowserFromCMD=<value> -Dtest=PageNavigatedTest test

mvn -DbrowserFromCMD=<value> -Dtest=SearchStringValidationTest test

mvn -DbrowserFromCMD=<value> -Dtest=TextVerificationTest test
```

Third Task - Using profile tag to separate development and production stage

#### mvn commands


- To execute the development phase profile - runs in head mode and in chrome

```
mvn -P developmentPhase test

# execute particular test file in development phase
mvn -P developmentPhase -Dtest=PageNavigatedTest test
```

- To execute the production phase profile - runs in headless mode and in firefox 

```
mvn -P productionPhase test
```

Additional Task 

- To execute the integration tasks 

```
# executes IntegrationIT integration test
mvn failsafe:integration-test failsafe:verify
```

Resources 

- [How to update a property file using maven or pom.xml](https://stackoverflow.com/questions/48259808/how-to-update-a-property-file-using-maven-or-pom-xml)
- [Maven Profiles example](https://mkyong.com/maven/maven-profiles-example/)
- [Guide to Maven Profiles](https://www.baeldung.com/maven-profiles)
- [Using the properties tag within maven profiles](https://stackoverflow.com/questions/12068758/using-the-properties-tag-within-maven-profiles) 