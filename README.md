# jarvis-test-integration
This project contains automated tests implemented with Selenium and Cucumber for Liferay Global Service's internal portal - Jarvis.

### Prerequisites
The setup instructions assume that you have a copy of lfrgs-liferay-jarvis on your local machine already, as it is an automated testing framework for that project.

For the tests that are already created, it is assumed that the context menu is properly configured on each page. If the
context menu does not have the element the test is looking for then the test will fail. 

Also, it may be necessary to change the site url the tests are run on. By default our test are set to use the site jarvis.com. 
We added 'jarvis.com' to our hosts file and set 'jarvis.com' as the private url for the site. 
If you do not want to use jarvis.com as the url, you can update what URL is used by changing what `BASE_URL` is set to
in `PropValues.java`  

#### Required Libraries:
In order to get the test to run properly you have to first import the necessary libraries in to your project. 
These libraries are included in the repositories 'external-libraries' directory. 

* cucumber-core-1.2.5.jar
* cucumber-java-1.2.5.jar
* cucumber-junit-1.2.5.jar
* cucumber-jvm-deps-1.0.5.jar
* gherkin-2.12.2.jar
* hamcrest-core-1.3.jar
* junit-4.12.jar
* selenium-server-standalone-3.11.0.jar

### How to Run Tests
To run the tests, run the `TestRunner.java` class

### Making Your Own Test
1. Create a feature file and add a scenario in the same directory as the other feature files. If you want to add a scenario to an already existing feature, then feel
free to do that.
2. Create and implement a test class in the `stepImplementations` package. One test class should address one scenario.
3. Notice that there are `*PageFactory.java` files. These are files that allow you to easily access elements for a given page. If a `*PageFactory.java` class is missing the 
element you need, feel free to add it to an existing class. If a page on Jarvis does not have an associated `*PageFactory.java` class, feel free to create it.

NOTE: If you want to change the browser you are testing in, you can configure it in `PropValues.java`. `PropKeys.java` has the available options.