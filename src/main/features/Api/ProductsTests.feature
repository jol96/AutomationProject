@TestNG
Feature: Products API Tests - Bulky Web App

  Scenario: Create and Delete New Product
  Given I try create these product via the product API
      | Title                                  | Description | ISBN  | Author      | List Price | Price | Price 50 | Price 100 | Category Id |
      | Harry Potter and the half blood prince | The 4th     | 10001 | J.K Rowling | 10.99      | 10.99 | 8.00     | 5.00      | 2           |
  Then the product "Harry Potter and the half blood prince" is created successfully
  Then the product is deleted successfully