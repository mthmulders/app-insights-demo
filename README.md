# app-insights-demo
An application used to demonstrate how to implement application insights in a Java application.


## The case demonstrated in this project
This project contains a sample application that allows speakers
to submit proposals for a fake conference. Other users can vote for proposals.
The session planner of the conference can plan sessions in rooms for tracks.

## Database setup
Either run SQL Server directly on your machine (if you're on Windows) or pull in a Docker container (on Linux or macOS).

    docker run \
          -e 'ACCEPT_EULA=Y' \
          -e 'SA_PASSWORD=MyAwesomePassword' \
          -p 1433:1433 \
          --name proposalkeeper-db \
          -d microsoft/mssql-server-linux

After that, create a database using `create database proposals`.
Now, you're ready to go!

## Quickstart
TODO: Describe how to compile the code and configure
the necessary settings to get the application working.
