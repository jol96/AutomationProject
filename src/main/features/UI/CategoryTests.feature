@TestNG
Feature: Category Tests as an Admin user - Bulky Web App

  Scenario: Create and Delete New Category
    Given I open the web app "https://bulkymvc-jack.azurewebsites.net/"
    Given I click the login link
    Given I enter the username "admin@dotnetmastery.com" and password "Admin123*"
    Given I click the content management drop down
    Given I select Category in the content management drop down
    When I click the Create New Category button
    When I enter the category name "Comic" and display order"4"
    When I click the create button
    When I click the delete button for category "Comic"
    When I click the delete button on the delete category page
    Then the category "Comic" has been deleted successfully