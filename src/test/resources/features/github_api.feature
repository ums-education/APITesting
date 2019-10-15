@tag
Feature: This is demo of API Automation

  Scenario Outline: Title of your scenario outline
    Given I get my repositories
    And I want to "<action>" a repository
    When I pass in the "<name of the repository>"
    Then I should "<see/not see>" the repository in my profile

    Examples: 
      | action | name of the repository | see/not see |
      #| post   | DemoAPITest            | see         |
      #| post   | AnotherAPI             | see         |
      #| post   | OneMoreAPI             | see         |
      | delete | DemoAPITest            | see         |
      | delete | AnotherAPI             | see         |
      | delete | OneMoreAPI             | see         |
