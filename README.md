# selenium-chrome-headless

This is a simple Java project to execute a testng web test in headless mode on chrome, firefox and opera using remote web driver on docker containers.

## To run on docker containers
Execute the run.sh (rename to run.bat for windows) which will start a selenium hub and a bunch of browser containers. 

To verify that the hub and the browser nodes are connected and functional goto http://localhost:4444/grid/console

The run the test:
`mvn clean test`

## Manually using local jars
Start the grid:
`java -jar selenium-server-standalone-3.141.59.jar -role hub`

`java -Dwebdriver.chrome.driver="/Users/adityai/code/selenium-grid-server/chromedriver" -jar selenium-server-standalone-3.141.59.jar -rolwebdriver -hub http://0.0.0.0:4444/grid/register -port 5566`


To run the test:
`mvn clean test`

