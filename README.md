Thymeleaf Tech Talk 
===================
A demo of the features of Thymeleaf + Spring MVC 3.2

Presentation
------------
The presentation for this demo can be found at [Slideshare](http://www.slideshare.net/JustinMunn/spring-user-group-thymeleaf-08212013)

Requirements
------------
- Java 7

Gradle Wrapper
--------------
This project uses Gradle to build the project. Gradle provides an embeddable version called the "Gradle Wrapper" which is included as part of this project. To use the Gradle wrapper in a UNIX like environment, simply execute ./gradlew while in the project directory. In a Windows enviornment, you execute ./gradlew.bat. Alternatively, you can always use an installed version of Gradle if you wish; however, it is recommended to use the wrapper. All commands below that use "gradle" can be replaced with the appropriate Gradle Wrapper command. For more information visit look at the [Gradle Website](http://www.gradleware.com/registered-access?content=screencasts%2Fthe-gradle-wrapper%2F)

Eclipse Setup
-------------
To set this project up in Eclipse follow these steps

1. Clone this project into your workspace
2. In the terminal run the command
2. In Eclipse go to File > Import...
3. Select "Existing Projects into Workspace"
4. Browse for the directory where you cloned the project
5. Click "Finish"

Run the App
-----------
 - Execute the command "gradle jettyRun"

This will start the app up on localhost:8080. If you wish to use another port update the Jetty configuration build.gradle.
