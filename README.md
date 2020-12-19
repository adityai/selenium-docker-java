# selenium-chrome-headless

This is a simple Java project to execute a testng web test in headless mode on chrome, firefox and opera using remote web driver on docker containers.

## Start containers using docker-compose.yml

`docker-compose up -d`

## To start the containers using 'docker run' command

Execute the run.sh (rename to run.bat for windows) which will start a selenium hub and a bunch of browser containers.

To verify that the hub and the browser nodes are connected and functional goto http://localhost:4444/grid/console

## To run the test:

After starting the containers, run:

`mvn clean test`

## Start the grid manually using local jars

Start the grid:
`java -jar selenium-server-standalone-3.141.59.jar -role hub`

`java -Dwebdriver.chrome.driver="/Users/adityai/code/selenium-grid-server/chromedriver" -jar selenium-server-standalone-3.141.59.jar -rolwebdriver -hub http://0.0.0.0:4444/grid/register -port 5566`
