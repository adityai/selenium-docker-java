docker run -d -p 4444:4444 --name selenium-hub selenium/hub
docker run -d -P --link selenium-hub:hub selenium/node-chrome-debug
docker run -d -P --link selenium-hub:hub selenium/node-firefox-debug
docker run -d -P --link selenium-hub:hub selenium/node-firefox-debug
docker run -d -P --link selenium-hub:hub selenium/node-opera
docker run -d -P --link selenium-hub:hub selenium/node-chrome
docker run -d -P --link selenium-hub:hub selenium/node-chrome
docker run -d -P --link selenium-hub:hub selenium/node-chrome