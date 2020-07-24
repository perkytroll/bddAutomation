#Author: adsingh1595@gmail.com ---- Akashdeep Singh
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Test framework for BDD using TestNG and Cucumber
  Keyword driven

  @test1
  Scenario: Register as a new user
    Given I register as an "endUser"
    And I login as the registered user
    When I
    
    
