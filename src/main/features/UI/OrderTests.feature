@TestNG
Feature: Order Tests as Customer - Bulky Web App

  Scenario: Create an Order
    Given I open the web app "https://bulkymvc-jack.azurewebsites.net/"
    Given I click the login link
    Given I enter the username "customer@email.com" and password "Test123!"
    Given I click the details button for product "Fortune of Time"
    Given I set the count to "4"
    Given I click the Add To Cart button
    Given I click the cart icon
    Given I click the Summary button on the shopping cart page
    Given I click the Place Order button on the order summary page
    When I enter the credit card details on the stripe redirect page and click pay
    Then I am notified the order is placed successfully
