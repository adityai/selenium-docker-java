# selenium-chrome-headless

This is a simple Java project to execute a testng selenium chrome web test case in headless mode using remote web driver.

Start the grid:
`java -jar selenium-server-standalone-3.141.59.jar -role hub`

`java -Dwebdriver.chrome.driver="/Users/adityai/code/selenium-grid-server/chromedriver" -jar selenium-server-standalone-3.141.59.jar -rolwebdriver -hub http://0.0.0.0:4444/grid/register -port 5566`


To run the test:
`mvn clean test`

