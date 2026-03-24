Feature: Login Validation

  Scenario: valid login page
    Given user launches browser
    When user enters credentials
      | username | password             |
      | tomsmith | SuperSecretPassword! |
      | tomsmith | SuperSecret!         |
