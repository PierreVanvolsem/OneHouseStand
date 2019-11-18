# language: nl

  Functionaliteit: Een reservatie voor een pand maken.

    Achtergrond:
      Gegeven er is een bestaande pand met id 1 die goedgekeurd is
      En er is een huurder Tibo ingelogd.

      Scenario: Een Pand in de toekomst reserveren met het aantal personen groter dan 1 en kleiner dan de maximale waarde van een int32
        Als Tibo naar de aanbod pagina gaat
        En op de pand met id 1 clickt
        En in het veld aantalPersonen "5" invul
        En in het veld Eind Datum  "02-05-2020" invul
        En op de knop Reserveer click
        Dan staat er een nieuwe lijn onder Bestaande reservaties met "5 personen 2020-05-02"

    Scenario: Een Pand in de toekomst reserveren met het aantal personen groter dan de maximale waarde van een int32
      Als Tibo naar de aanbod pagina gaat
      En op de pand met id 1 clickt
      En in het veld aantalPersonen "9999999999" invul
      En in het veld Eind Datum  "02-05-2020" invul
      En op de knop Reserveer click
      Dan staat er onder Reservatie plaatsen "Gelieve de problemen op te lossen."


        #werkt niet
    Scenario: Een Pand in het verleden reserveren met het aantal personen groter dan 1
      Als Tibo naar de aanbod pagina gaat
      En op de pand met id 1 clickt
      En in het veld aantalPersonen "5" invul
      En in het veld Eind Datum  "02-05-2018" invul
      En op de knop Reserveer click
      #as-is
      Dan staat er een nieuwe lijn onder Bestaande reservaties met "5 personen 2018-05-02"
      #to-be (error)
      Dan staat er op de pagina "error, We are awfully sorry, but there is something rotten in the state of Denmark"


    Scenario: Er is al een reservatie voor de pand
      #todo nakijken of een nieuwe given hier mag !!!
      Gegeven er is een bestaande pand met id 1 die goedgekeurd is
      En er is al een reservatie op de pand voor de datum "02-05-2020"
      En er is een huurder Tibo ingelogd.

      Als Tibo naar de aanbod pagina gaat
      En op de pand met id 1 clickt
      En in het veld aantalPersonen "5" invul
      En in het veld Eind Datum  "02-05-2020" invul
      En op de knop Reserveer click
      #as-is
      Dan staat er een nieuwe lijn onder Bestaande reservaties met "5 personen 02-05-2020"
      #to-be (error)
      Dan staat er op de pagina "error, We are awfully sorry, but there is something rotten in the state of Denmark"