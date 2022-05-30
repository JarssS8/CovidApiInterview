build:
	docker build -t covid-api-adrian-corral .

down:
	docker stop covid-api-adrian-corral

up: build
	docker run --rm -d -p 8080:8080 --name covid-api-adrian-corral covid-api-adrian-corral:latest

output: build
	docker run --rm -d -p 8080:8080 --name covid-api-adrian-corral covid-api-adrian-corral:latest

sonar:
	mvn clean install sonar:sonar
