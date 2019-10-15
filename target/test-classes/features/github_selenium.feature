
@tag
Feature: Title of your feature
  
 
  Scenario: Title of your scenario
    Given I login to my GitHub account
    And I create a new repository
    When I pass in repository name "DemoAPITesting"
    And I click Create Repository
    Then the title of the page should containt "DemoAPITesting"

 