# SandboxSiteTesting_ITBC
Project : Automation testing of a web application - https://sandbox.2checkout.com/sandbox 


For work with web elements use Selenium Web driver and for writing the tests use TestNG.
Apply POM - Page Object Model.

All used locator need to be stored in a single text file, so if some (such as x-path) changes, it doesn’t have to compiled the entire code.

Log In - Test whether it is possible to log in if the user registration step is skipped (using data that has never been stored in the database).

Registration - Test if the registration form works by entering a single user data. Detailed check if is possible to register without entering all fields. Register 30 people with information about each person being read from an xlsx or xls file. The data set generate automatically and create an xlsx or xls file that is filled with the data required to register 30 users. For each person check if the registration was successful.

Products cart - Test the addition of 5 products - only basic information is required. Load the required data from an xlsx or xls file, create products and verify that their creation is successful. Increase the price of previously created products by 100 and check the success of the changes.

Bug Report - Write a bug report and fill it out using information found through automatic and manual testing.

Bonus requirement - Create one test suite that will run tests from all TestNG classes. Instead of a Java project, create a Maven project.
