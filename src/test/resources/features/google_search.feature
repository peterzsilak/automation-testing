Feature: Google Search

  Scenario: Google search test
    Given the Google search page

  Scenario: Google search test 2
    Given the Google search page

  @wip
  Scenario Outline: Multiple search
    Given the Google search page
    When user is searching for a <word>

    Examples:
      | word      |
      | "cat"     |
#      | "dog"     |
#      | "páfrány" |
