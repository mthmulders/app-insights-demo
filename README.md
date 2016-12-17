# app-insights-demo
An application used to demonstrate how to implement application insights in a Java application.


## The case demonstrated in this project
This project contains a sample application that allows speakers
to submit proposals for a fake conference. Other users can vote for proposals.
The session planner of the conference can plan sessions in rooms for tracks.

## Quickstart
A simple `mvn clean package` should do the trick. 
After that, start the app using `java -Dspring.datasource.password=MyAwesomePassword -jar target/proposalkeeper-1.0-SNAPSHOT.jar`
