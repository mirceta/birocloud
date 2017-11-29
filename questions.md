- How do i structure the microservice into github projects? If I only create one repository it's a problem, but if I create multiple, then there is no root where the pom.xml dependencies are defined.

- How do I import one project into another if they don't have the same root?

http://blog.shippable.com/our-journey-to-microservices-and-a-mono-repository ?

- How to run an instance of a db in docker:

docker run -d --name postgres-customers -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=customer -p 5432:5432 postgres:latest