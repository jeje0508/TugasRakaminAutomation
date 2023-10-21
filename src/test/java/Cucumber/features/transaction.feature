Feature: Customer transaction

  @Regression @Transaction @Positive
  Scenario: User success add to cart and make transaction
    Given user open swag labs website
    Then user should see login Page
    And user input registered user
    And user input valid password
    When user click the login button
    Then user should see Product Page
    And user click add to cart button
    And user click cart icon
    And user click checkout button
    Then user should see Checkout Your Information page
    And user input on first name field
    And user input last name field
    And user input Zip or Postal Code field
    When user click continue button
    Then user directed to checkout overview section
    And user click Finish button
    Then user directed to checkout complete section
    When user click back home button
    Then user should see Product Page
    And user click burger button
    And user click logout menu
    Then user should see login Page

  @Regression @Transaction @Negative
  Scenario: User see error message bellow Postal Code field
    Given user open swag labs website
    Then user should see login Page
    And user input registered user
    And user input valid password
    When user click the login button
    Then user should see Product Page
    And user click add to cart button
    And user click cart icon
    And user click checkout button
    Then user should see Checkout Your Information page
    And user input on first name field
    And user input last name field
    When user click continue button
    Then user should see error message bellow the Zip or Postal Code field

