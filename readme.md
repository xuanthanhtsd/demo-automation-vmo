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

```bash
$ mvn clean test
```
After the test finishes, you can find the txt report file in `\target\surefire-report` folder or directly on console screen.

## Selenium Grid configuration
### Install docker:

Step 1: input all command line below

```bash
$ sudo apt-get install -y curl  apt-transport-https ca-certificates 
$ software-properties-common
$ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add 
$ sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
$ sudo apt-get update
$ sudo apt-get install -y docker.io
```
Step 2: Fix Got permission denied while trying to connect to the Docker daemon socket:
```bash
$ sudo usermod -aG docker ${USER}
$ su - ${USER}
$ id -nG
```
Step 3: Configure Docker to start on boot:
```bash
$ sudo systemctl enable docker
```
Step 4: log out

### Install docker-compose:
```bash
$ sudo curl -L "https://github.com/docker/compose/releases/download/1.26.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
$ sudo chmod +x /usr/local/bin/docker-compose
```
### Run docker Hub, Node by docker-compose
Go to docker-compose folder.
```bash
$ cd /home/ubuntu/automation/demo-automation-vmo/selenium-grid/docker-hub-node-debug
$ docker-compose up -d
```
### Connect  to node by  VNC Viewer

[Download](https://www.realvnc.com/en/connect/download/viewer/) and install VNC Viewer

Connect to node by Vnc Viewer: ex: 172.16.0.8:5902

Password: "secret"