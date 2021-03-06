# language: nl
@PandReserveren
Functionaliteit: Een reservatie voor een pand maken.

  Achtergrond:
    Gegeven er is een bestaand pand met id 1 die goedgekeurd is en die geen reservering heeft
    En er is een huurder Tibo ingelogd.
    En Tibo is op de pagina van het pand met id 1

  Scenario: het pand heeft geen reservering op de gegeven datum en de datum is in de toekomst en het aantal personen is tussen 1 en 99
    Als Tibo het veld "aantalPersonen" invuld met 5
    En Tibo het veld "einddatum" invuld  met "20/11/2020"
    En Tibo op reserveer Klikt
    Dan staat er een nieuwe lijn onder Bestaande reservaties met "5 personen 2020-11-20"

  Scenario: het pand heeft geen resnervering op de gegeven datum en de datum is i de toekomst en het aantal personen is niet tussen 1 en 99
    Als Tibo het veld "aantalPersonen" invuld met 120
    En Tibo het veld "einddatum" invuld  met "20/11/2020"
    En Tibo op reserveer Klikt
    Dan staat er op de error pagina "Geen gelding aantal personen ingegeven"

  Scenario: het pand heeft nog geen reservering op de gegeven datum en de datum is in het verleden en het aantal personen is tussen 1 en 99
    Als Tibo het veld "aantalPersonen" invuld met 59
    En Tibo het veld "einddatum" invuld  met "20/11/2019"
    En Tibo op reserveer Klikt
    Dan staat er op de error pagina "Datum mag niet in het verleden zijn"

  Scenario: het pand heeft al een reservering op de gegeven datum en de datum is in de toekomst en het aantal personen is tussen 1 en 99
    Gegeven het pand met id 1 heeft één reservatie met datum "20/11/2020" en aantal personen 5
    Als Tibo het veld "aantalPersonen" invuld met 5
    En Tibo het veld "einddatum" invuld  met "20/11/2020"
    En Tibo op reserveer Klikt
    Dan staat er op de error pagina "Pand is al gereserveerd"

  Scenario: het pand heeft een reservering op de gegeven datum en de datum is in het verleden en het aantal personen is tussen 1 en 99
    Gegeven het pand met id 1 heeft één reservatie met datum "20/11/2019" en aantal personen 5
    Als Tibo het veld "aantalPersonen" invuld met 120
    En Tibo het veld "einddatum" invuld  met "20/11/2019"
    En Tibo op reserveer Klikt
    Dan staat er op de error pagina "Pand al gereserveerd en geen geldig aantal personen"