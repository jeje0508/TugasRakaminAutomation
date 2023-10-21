Feature: Customer add to card

    @Regression @Positive @cobain
    Scenario: User add to cart item
    Given user open swag labs website
    Then user should see login Page
    And user input registered user
    And user input valid password
    When user click the login button
    Then user should see Product Page
    And user click add to cart button
    And user click cart icon

