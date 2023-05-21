# DevelopmentBooks

There is a series of books about software development that have been read by a lot of developers who want to improve
their development skills. Let’s say an editor, in a gesture of immense generosity to mankind (and to increase sales as
well), is willing to set up a pricing model where you can get discounts when you buy these books. The available books
are :

1. Clean Code (Robert Martin, 2008)
2. The Clean Coder (Robert Martin, 2011)
3. Clean Architecture (Robert Martin, 2017)
4. Test Driven Development by Example (Kent Beck, 2003)
5. Working Effectively With Legacy Code (Michael C. Feathers, 2004)

# Rules

One copy of the five books costs 50 EUR.

- If, however, you buy two different books from the series, you get a 5% discount on those two books.
- If you buy 3 different books, you get a 10% discount.
- If you buy 4 different books, you get a 20% discount.
- If you go for the whole hog, and buy all 5, you get a huge 25% discount.
- Note that if you buy, say, 4 books, of which 3 are different titles, you get a 10% discount on the 3 that form part of
  a set, but the 4th book still costs 50 EUR.

# Functional case

If the shopping basket contains the below books.

- 2 copies of the “Clean Code” book
- 2 copies of the “Clean Coder” book
- 2 copies of the “Clean Architecture” book
- 1 copy of the “Test Driven Development by Example” book
- 1 copy of the “Working effectively with Legacy Code” book

We can avail the discounts for above shopping basket containing 8 books by grouping [5,3] or [4,4] or [3,3,2], etc.
Output should be **320 EUR** as the best price by applying **[4,4]** as below.

- (4 * 50 EUR) - 20% [first book, second book, third book, fourth book]
- (4 * 50 EUR) - 20% [first book, second book, third book, fifth book]

= (160 EUR + 160 EUR) => **320 EUR**

# Purpose

Develop a application to **calculate the best price** of any conceivable shopping basket by applicable the above
discounts using **Test Driven Development** (TDD).

# Tools used for developing this application

- **Backend** : Java 8, Spring Boot 2.7, Swagger 3.0
- **Build tool** : Maven 3.8.1
- **Reporting** : Jacoco 0.8.10
- **IDE** : IntelliJ IDEA 2023.1.1 (Community Edition)

## How to build the application

* Clone this repository

```
https://github.com/2023-DEV1-073/DevelopmentBook.git
```

* You can build the project and run the tests by running ```mvnw clean install```

## How to run the application

* By default the application will start on **port 8080**. If you want the application to run on different port 8082, you
  can pass additional parameter **--server.port=8082** while starting the application (or) you can update the *
  *server.port** in **application.properties**
* Once successfully built, you can run the service by one of this commands:

```
	java -jar target\online.shop.book-0.0.1-SNAPSHOT.jar
			
							(or)
							
	java -jar target\online.shop.book-0.0.1-SNAPSHOT --server.port=8082
```

Once the application runs you should see below message in console log

```

2023-05-21 19:21:32.559  INFO 23512 --- [  restartedMain] com.dev.bookshop.Application             : Started Application in 4.535 seconds (JVM running for 5.011)
2023-05-21 19:21:43.524  INFO 23512 --- [nio-8080-exec-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-05-21 19:21:43.524  INFO 23512 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-05-21 19:21:43.526  INFO 23512 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms

```

## How to access the application

* Once the application started successfully, you can access the application by launching the below url in the browser:

```
	http://localhost:8080/swagger-ui/
	
		(or)
		
	http://localhost:<PORT>/swagger-ui/
```

## **How to access the code coverage report**

Please follow the below-mentioned steps to access code coverage report.

1. Clone the repository ```https://github.com/2023-DEV1-073/DevelopmentBook.git```
2. Open CMD or Git Bash Terminal and run the below command

- `mvnw clean install`

3. After successful build, you can find the report in below path

- $buildDir/target/site/jacoco/index.html

****