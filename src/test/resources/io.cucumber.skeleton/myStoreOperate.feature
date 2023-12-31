Feature: MyStore-TestLab.CodersLab Test

  Scenario Outline: Correct Login
    Given I open a browser
    And I choose shop page
    And I go to login page
    When I type "noga@gmail.com" login
    And I type "noga1234" password
    And I click login button
    Then I am logged in
    And I go to address page
    When I click create new address
    And I fill out  alias "<alias>", address "<address>", city "<city>", postal code "<postalCode>", country "<country>", phone "<phone>"
    And I submit the form
    Then the new address should be added successfully
    And the details of the added address should be correct "<screen>"

      Examples:
        | alias          | address        | city        | postalCode | country | phone       | screen |
#       | WorkAddress    | Happy Street   | London      | 12-345      | Poland  | 123456789   |address1|
        |HomeAddress    | Happy Street   | London      | 12-345      | Poland  | 123456789   |address2|
        | RestAddress    | Happy Street   | London      | 12-345      | Poland  | 123456789   |address3|


