simple spring boot service to calculate price.

to start the application, simply run it in an IDE or use maven: $ mvn spring-boot:run

the service exposes an endpoint at http://localhost:8080/rate

see attached postman-collection to send a post command to the endpoint.

I've only written one basic unit test. See com.htb.pricecalculator.service.PriceCalculationServiceTest# price-calculator

To improve the service, a retry mechanism and/or persistance layer could be added, as well as a ui (e.g. a dashboard).
