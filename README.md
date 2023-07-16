## how to run the project?
- install java 17 (should be able to run on java 11 also)
- make sure google chrome is installed
- install the dependencies using maven
- run the test from CheckoutTest.java





## what design pattern used?
- Page Object pattern: in this design pattern we separate each page to a class so as in the project we separate login page, homepage, and product detail page to a different class here. in the PageObject we set method for interaction within the page.
- Abstract Factory pattern: each page is inherited webdriver from abstract class PageObject.java.

## how project is structured?
- in the CheckoutTest.java webDriver is being declared, and WebController declared as it used to do logical process and interact to page objects. also app.properties is used to store properties if we want to set the custom value, or add new test data.

## What improvement is needed?
- I think in the next step we can implement cucumber so we can use it to generate report, and give BDD to other stakeholder.
- Implement multi-browser testing.
- setup the testing environment using virtual machine and docker so it can run across all OS. By doing so we can setup the selenoid so it can be remotely access anywhere
- setup the jenkins job so it can run anytime we want
