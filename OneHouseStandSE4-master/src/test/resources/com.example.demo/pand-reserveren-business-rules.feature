# language: nl

Functionaliteit: Een reservatie voor een pand maken.

  Achtergrond:
    Gegeven er is een bestaand pand die geldig is en die geen reservering heeft
    En er is een geldige huurder ingelogd.
    En de huurder is op de pagina van het pand

  Scenario: het pand heeft geen reservering op de gegeven datum en de datum is in de toekomst en het aantal personen is tussen 1 en 99
    Als de huurder het veld "aantalPersonen" invuld met een geldig aantal
    En de huurder het veld "einddatum" invuld  met een geldige datum
    En de huurder op reserveer klikt
    Dan kan je de reservatie zien onder reservaties

  Scenario: het pand heeft geen reservering op de gegeven datum en de datum is in de toekomst en het aantal personen is niet tussen 1 en 99
    Als de huurder het veld "aantalPersonen" invuld met een ongeldig getal
    En de huurder het veld "einddatum" invuld  met een geldige datum
    En de huurder op reserveer klikt
    Dan staat er op een error bericht

  Scenario: het pand heeft nog geen reservering op de gegeven datum en de datum is in het verleden en het aantal personen is tussen 1 en 99
    Gegeven het pand heeft één reservatie met datum een geldige datum en een geldig aantal personen
    Als de huurder het veld "aantalPersonen" invuld met een geldig getal
    En de huurder het veld "einddatum" invuld  met een ongeldige datum
    En de huurder op reserveer klikt
    Dan staat er op een error bericht

  Scenario: het pand heeft al een reservering op de gegeven datum en de datum is in de toekomst en het aantal personen is tussen 1 en 99
    Gegeven de geldige pand heeft één geldige reservatie
    Als de huurder het veld "aantalPersonen" invuld met een geldig getal
    En de huurder het veld "einddatum" invuld  met een geldige datum
    En de huurder op reserveer klikt
    Dan staat er op een error bericht

  Scenario: het pand heeft een reservering op de gegeven datum en de datum is in het verleden en het aantal personen is tussen 1 en 99
    Gegeven de geldige pand heeft één geldige reservatie
    Als de huurder het veld "aantalPersonen" invuld met een ongeldig getal
    En de huurder het veld "einddatum" invuld  met een ongeldige datum
    En de huurder op reserveer klikt
    Dan staat er op een error bericht