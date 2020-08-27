# Automation test demo

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Make sure you have installed all of the following prerequisites on your development machine:
* JDK 8 - [Download and install JDK 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
* Maven - [Download & Install Maven](http://maven.apache.org/)
* ChromeDriver - [Download Chromdriver](https://chromedriver.chromium.org/). Make sure the driver and chrome browser version are the same.
* JAVA_HOME System variable [Setup & Verification](https://mkyong.com/java/how-to-set-java_home-on-windows-10/)
* MAVEN_HOME System variable [Setup & Verification](https://mkyong.com/maven/how-to-install-maven-in-windows/)

## Test Configuration

### Driver configuration
Copy chromedriver.exe to `src/main/resources/driver`. 

## Run Test

### Test Configuration
From your terminal/command prompt, change directory to folder where you clone the project. 
```
mvn clean test
```
After the test finishes, you can find the txt report file in `\target\surefire-report` folder or directly on console screen.

## Selenium Grid configuration
