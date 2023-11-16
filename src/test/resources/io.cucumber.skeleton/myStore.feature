Feature:
  Scenario Outline:
    Given I open a browser
    And I choose shop page
    And I go to login page
    When I type "noga@gmail.com" login
    And I type "noga1234" password
    And I click login button
    Then I am logged in
    And I go to address page
    When I click create new address
    And I fill out the New Address form with the following details: "<alias>", "<alias>", "<alias>", "<alias>", "<alias>", "<alias>"

    And I submit the form
    Then the new address should be added successfully
    And the details of the added address should be correct

    Examples:
      | alias          | address        | city        | postalCode | country | phone       |
      | WorkAddress    | Happy Street   | Gdansk      | 12345      | Poland  | 123456789   |