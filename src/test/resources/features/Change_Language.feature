
Feature: Change Language

    Scenario: The user should be to change language
      Given Navigate to Login Page iki
      When The user should be able to language button click and select Deutsch
      Then  Verify that the language is selected as Deutsch
      When The user should be able to language button click and select Turkish
      Then Verify that the language is selected as Turkish
      When The user should be able to language button click and select English
      Then Verify that the language is selected as English
