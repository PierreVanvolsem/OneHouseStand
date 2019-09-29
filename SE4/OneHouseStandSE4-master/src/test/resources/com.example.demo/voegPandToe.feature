Feature: Add House

  It should be possible to add a house to the list
  Just after adding the house,
  the list is shown and contains the newly added house

  Scenario: Add one house
    Given I am signed in as a klant
    And I am on the page where I can add a new house
    When I enter "800" in the prijsPerUur field
    And I enter "Boulevardlaan" in the straatNaam field
    And I enter "60" in the huisNummer field
    And I press on the Submit button
    And I sign in as screener
    And i go to the ongekeurde panden page
    Then I should see a list containing "ongekeurd", "800"
    And I close the browser

#    TODO: WHEN I CLICK ON THE HOUSE.. I SHOULD SEE THE DETAILS (huisnummer, adres)
#    When I click the Lijst van alle personen Link
#    Then I should see the following on the screen
#      | label        | data         |
#      | Status:      | Ongekeurd    |
#      | PrijsPerUur: | 199          |




