Feature: Customer login

  @Regression @Positive
  Scenario: User success login with registered username and password
    Given user open swag labs website
    Then user should see login Page
    And user input registered user
    And user input valid password
    When user click the login button
    Then user should see Product Page

  @Regression @Positive
  Scenario: User login with locked username and password
    Given user open swag labs website
    Then user should see login Page
    And user input locked user
    And user input valid password
    When user click the login button
    Then user should see locked message bellow the password field

  @Regression @Negative
  Scenario: User login with registered username without password
    Given user open swag labs website
    Then user should see login Page
    And user input registered user
    And user not input password
    When user click the login button
    Then user should see error pass message bellow the password field

  @Regression @Negative
  Scenario: User login with wrong username and registered password
    Given user open swag labs website
    Then user should see login Page
    And user input unregistered user
    And user input valid password
    When user click the login button
    Then user should see error message bellow the password field

    @TDD
    Scenario Outline: User login to Kasir Aja
      Given user open swag labs website
      Then user should see login Page
      When i input <username> as username
      And  i input <password> as password
      When user click the login button
      And user verify <status> login


      Examples:
        |    username     |   password   |     status    |
        |  standard_user  | secret_sauce |    success    |
        | locked_out_user | secret_sauce |    locked     |
        |   problem_user  | secret_sauce |    success    |
        |   locked_out    | secret_sauce | wrongusername |
        |  standard_user  |              |     failed    |



