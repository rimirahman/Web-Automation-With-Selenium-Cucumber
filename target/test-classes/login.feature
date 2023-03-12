Feature: GitHub Search and About Page Verification

  Scenario Outline: Search for "create-react-app" as a guest and verify the first result
    Given I am on the GitHub landing page
    When I search for "<searchInput>"
    Then I should see a count of matching results

    Examples:
      | searchInput |
      | create-react-app |
      | facebook/create-create-app |

  Scenario: Verify About page as a guest
    Given I am on the GitHub landing page
    When I click the "About" button in the footer
    Then Assert i am on About page
