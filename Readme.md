# Java Test Automation Framework

This is a Java-based Test Automation Framework. 

It supports cross-browser testing, headless execution, cloud execution via LambdaTest, and data-driven testing.


## 🚀 About Me
Hi, My name is Shivakumar Baragi and I have 3.5 years of experience in Quality Assuance/Test Automation using technologies like Selenium Webdriver, Restassured and Playeright.

My major expertise is in Java and Javascript Language.

## Author

- [@Aeroshiva](https://github.com/Aeroshiva)
- Email Id: aerospaceshiva@gmail.com


## Tech Stack

**Programming Language:** Java11

## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Aeroshiva)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://in.linkedin.com/in/aeroshiva)




## Prerequisites
Before running this framework, ensure the following configuration are installed on your system.
- **Java 11** installed and configured (JAVA_HOME)
- **Maven** installed and available in system PATH
    - Download Link: https://maven.apache.org/download.cgi

## Features

- **Cross-browser Testing** – Execute tests across multiple browsers like Chrome and Firefox.
- **Cloud Execution with LambdaTest** – Run tests on a wide range of OS and browser combinations in the cloud.
- **Headless Mode** – Speed up test execution by running in headless mode.
- **Data-driven Testing** – Easily run tests using dynamic input from CSV or Excel files using OpenCSV and Apache POI.
- **Fake Data Generation** – Use the Faker library to inject realistic dummy data into test cases.
- **Reporting** – Get detailed test execution insights via Extent Reports.
- **Logging** – Track execution details and errors using Log4j with timestamped logs.
- **CI/CD Friendly** – Ready to integrate with Jenkins, GitHub Actions, and other CI/CD tools.

## Technologies Used
- Java 11
- TestNG – Testing framework
- OpenCSV – Data-driven testing from CSV files
- Gson – JSON parsing and configuration
- Apache POI – Excel data handling
- Faker – Generating fake test data
- Extent Reports – Test reporting
- Log4j – Logging mechanism
- Maven Surefire Plugin – Command-line test execution
- LambdaTest – Cloud-based cross-browser testing






## Setup Instruction

**Clone the repository:**

```bash
    git clone https://github.com/Aeroshiva/Java-Selenium-Test-Automation-Framework.git

    cd Java-Selenium-Test-Automation-Framewor
```
    
**Run tests on LambdaTest:**
```bash
    mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X 
```
**Run headless tests locally:**
```bash
    mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X 
```
## Reports & Logs

- **Extent Report** – Generated at ./report.html.

  The report contains information on test cases executed, Passed, Failed, and Skipped, along with Screenshots for failed tests.  

- **Logs** – Stored in the ./logs/ directory with date-time stamped log files

## Integrated the Projct with GitHub Actions
This Automation Framework is integrated with github actions. The tests will be executed 11:30PM IST every single day.

The reports will be archived in gh-pages branch
You can view HTML reports at :
https://aeroshiva.github.io/Java-Selenium-Test-Automation-Framework/report.html
