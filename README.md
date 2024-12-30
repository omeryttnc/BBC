
# BBC API Task

## Project Overview

This project is a solution for an API task provided by BBC. It involves implementing automated tests for an API using Java 21, Cucumber, and JUnit. The project includes test reports generated with Allure and Cucumber HTML, as well as a manual functional testing component.

## Technologies Used

- **Java 21**: The programming language used for the implementation.
- **Cucumber**: For behavior-driven development (BDD) testing.
- **Allure**: For generating beautiful and interactive test reports.
- **Cucumber HTML Reports**: Alternative reporting tool.
- **GitHub Actions**: For continuous integration and test automation.

## Installation Instructions

### 1. **Clone the repository:**

   ```bash
   git clone https://github.com/omeryttnc/BBC
   ```

### 2. **Ensure you have Java 21 installed.**

### 3. **Install Maven:**

If Maven is not already installed, you can install it by following the instructions on the [official website](https://maven.apache.org/install.html).

### 4. **Install Allure Commandline (if needed):**

To install Allure for local reporting, use the following command:

   ```bash
   npm install -g allure-commandline --save-dev
   ```

## 5. **Set Environment Path for Allure (if needed)**

After installing Allure, you may need to add the `bin` folder of Allure to your system's environment path.

### On **Windows**:
1. Find the folder where Allure was installed. By default, it will be in:
   ```
   C:\Users\<YourUser>\AppData\Roaming\npm\node_modules\allure-commandline\bin
   ```
2. Copy the path to the `bin` folder.
3. Open **System Properties** → **Advanced** → **Environment Variables**.
4. Under **System Variables**, select **Path** and click **Edit**.
5. Add the copied path to the list of values.

### On **Mac/Linux**:
1. Open your terminal.
2. Add the Allure `bin` folder to your `PATH` with the following command:
   ```bash
   export PATH=$PATH:/path/to/allure/bin
   ```
3. To make this change permanent, add the above line to your shell configuration file (`~/.bash_profile`, `~/.zshrc`, etc.).

### 6. **Run the tests:**

To run the tests and generate reports:

```bash
mvn clean test
```

### 7. **Generate Allure report:**

If you want to view the Allure report locally:

```bash
allure generate target/allure-results --clean -o target/allure-report
```

### 8. **View reports:**

- **Cucumber HTML Report**: `target/cucumber-reports/cucumber-reports.html`
- **Allure Report**: `target/allure-report/index.html`

## Running Tests

To run the tests, use the following Maven command:

```bash
mvn clean test
```

## Reporting

### Allure Reporting

For Allure reporting, the following steps are required:

1. First, check if Allure is already installed by running the command:

   ```bash
   allure --version
   ```

   - If a version number appears, Allure is installed, and you can proceed.
   - If you receive an error, install Allure using:

   ```bash
   npm install -g allure-commandline --save-dev
   ```

2. After running the tests (`mvn clean test`), generate the Allure report with the following command:

   ```bash
   allure generate target/allure-results --clean -o target/allure-report
   ```

3. To view the report, open the `index.html` file located in `target/allure-report/` in any browser.

### Cucumber HTML Reporting

For Cucumber HTML reporting, no additional installation is required. After running the tests, you can view the report by opening the `target/cucumber-reports/cucumber-reports.html` file in any browser.

## GitHub Actions and Reports

The tests are set up to run automatically with every push using GitHub Actions. The Allure report is also hosted on GitHub Pages. You can view the report at the following URL:

[Allure Report](https://omeryttnc.github.io/BBC/allure-report)

## GitHub Repository

You can access the repository here:

[GitHub Repository](https://github.com/omeryttnc/BBC)

## Manual Functional Testing

The manual functional testing part of the task has been added to the `src/test/resource/features/manualFunctionalTesting.txt` file.

## Known Issues and Discrepancies:

1. **"id" Field Clarification**: In the test scenario, it was required to verify that the "id" field is not null or empty for all items in the elements array. However, the API response includes multiple types of "id" fields (e.g., episode id, version id, service id, etc.), but the specification did not clarify which one to validate. In the test, all the different "id" fields were validated.

2. **Incorrect Number of Items in elements Array**: The test expected 4 items in the elements array, but the actual response contained 5 items. The discrepancy was observed during the test execution, and the API response does not match the expected number of items.

## Recommendations:

- Clarify which "id" field(s) need to be validated (e.g., episode id, version id, etc.).
- Ensure the API response returns the expected number of items (i.e., 4 items in the elements array).
