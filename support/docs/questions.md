## How to structure

- How do i structure the microservice into github projects? If I only create one repository it's a problem, but if I create multiple, then there is no root where the pom.xml dependencies are defined.

- How do I import one project into another if they don't have the same root?

http://blog.shippable.com/our-journey-to-microservices-and-a-mono-repository ?

## How to run

- Adding AO persistence as a dependency into User persistence, makes it break - JNDI doesn't find the User data source.

- The problem was having 2 configuration files in the project during compilation. Because user service imported account options service, config.yaml got overriden or something.

- This then comes back to the first question.

## Remark: Error in the tutorial

- When customer and orders service start to communicate there is an error regarding path to api operation and base url.

