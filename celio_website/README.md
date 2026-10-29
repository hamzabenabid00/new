# Celio Website Automation Project

This project is a Java Selenium test automation suite for the Celio Tunisia website. It uses a Page Object Model (POM), Cucumber feature files, JUnit, and Firefox WebDriver for browser automation.

## Tech Stack
- Java 17
- Selenium WebDriver
- JUnit 4
- Cucumber JVM
- Maven
- PageFactory + @FindBy
- WebDriverWait for explicit waits

## Project Structure

```text
celio_website/
├── pom.xml
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   ├── Helper/
│       │   │   ├── Config.java
│       │   │   └── Utlis.java
│       │   ├── Pages/
│       │   │   ├── Ajoutpanier.java
│       │   │   ├── PageAccueil.java
│       │   │   └── ProduitCollection.java
│       │   ├── Runner/
│       │   │   └── Runner.java
│       │   └── StepDef/
│       │       ├── AjoutPanierStepDef.java
│       │       ├── PageAccueilStepDef.java
│       │       └── ProduitCollectionStepDef.java
│       └── resources/
│           ├── features/
│           │   ├── ajoutpanier.feature
│           │   ├── homepage.feature
│           │   └── produit_collection.feature
│           └── Properties/
│               └── properties
└── target/
```

## Features Covered
- Homepage menu navigation
- Product click verification
- Add to cart flow
- Product page verification

## Requirements
- Java JDK 17+
- Maven
- Firefox installed on the machine
- GeckoDriver available in the system PATH

## Run the tests

From the project root:

```bash
cd /home/hamza/git/new/celio_website
mvn test -Dtest=Runner
```

This runs the Cucumber/JUnit runner configured in `src/test/java/Runner/Runner.java`.

## Browser Setup
The project currently initializes Firefox using:

```java
Config.driver = new FirefoxDriver();
```

Make sure Firefox and the matching WebDriver are installed and accessible.

## Notes
- This project uses a Cucumber-style BDD structure.
- Page objects use `@FindBy` and `PageFactory`.
- Explicit waits are implemented with `WebDriverWait`.
- The runner points to the feature files for execution.

## Example Scenario
A sample scenario checks that a user can open the homepage, click a menu item, and verify the correct page is displayed.

## Status
This project is a working Selenium test automation example for the Celio website. The suite can be executed with Maven and Cucumber.
