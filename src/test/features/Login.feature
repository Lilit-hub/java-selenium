@test
@login
Feature: As a user, I want to be able to login into app

  Scenario: Login with valid credentials
    Given Login page is open
    And I type "standard_user" as username
    And I type "secret_sauce" as password
    When I click on Login button
    Then URL should contain "inventory"

  Scenario: Login with invalid credentials
    Given Login page is open
    When I type "invalid_username" as username
    And I type "invalid_password" as password
    And I click on Login button
    Then I should see error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login with empty username
    Given Login page is open
    When I type "invalid_password" as password
    And I click on Login button
    Then I should see error message "Epic sadface: Username is required"

  Scenario: Login with empty password
    Given Login page is open
    When I type "invalid_username" as username
    And I click on Login button
    Then I should see error message "Epic sadface: Password is required"

  Scenario: Logout from account
    Given User is logged in
    When I click on "Logout" button from sidebar menu
    Then I should be redirected to login page

