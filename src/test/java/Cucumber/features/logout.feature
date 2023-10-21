Feature: Customer logout

  @Regression @Positive
  Scenario: User success login and logout
    Given user open swag labs website
    Then user should see login Page
    And user input registered user
    And user input valid password
    When user click the login button
    Then user should see Product Page
    And user click burger button
    And user click logout menu
    Then user should see login Page

