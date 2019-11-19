# language: nl

  Functionaliteit: Een reservatie voor een pand maken.

    Achtergrond:
      Gegeven er is een bestaande pand met id 1 die goedgekeurd is
      En er is een huurder Tibo ingelogd.
      En Tibo is op de pagina van de pand met id 1

      Scenario: Een Pand in de toekomst reserveren met het aantal personen groter dan 1 en kleiner dan de maximale waarde van een int32
        Als Tibo in het veld aantalPersonen "5" invult
        En in het veld Eind Datum  "02-05-2020" invult
        En op de knop Reserveer clickt
        Dan staat er een nieuwe lijn onder Bestaande reservaties met "5 personen 2020-05-02"

    Scenario: Een Pand in de toekomst reserveren met het aantal personen groter dan de maximale waarde van een int32
      Als Tibo in het veld aantalPersonen "9999999999" invult
      En in het veld Eind Datum  "02-05-2020" invult
      En op de knop Reserveer clickt
      #as-is
      Dan staat er onder Reservatie plaatsen "Gelieve de problemen op te lossen."


        #werkt niet
    Scenario: Een Pand in het verleden reserveren met het aantal personen groter dan 1
      Als Tibo in het veld aantalPersonen "5" invul
      En in het veld Eind Datum  "02-05-2018" invul
      En op de knop Reserveer click
      #as-is
      Dan staat er een nieuwe lijn onder Bestaande reservaties met "5 personen 2018-05-02"
      #to-be (error pagina)
      Dan staat er op de pagina "error, We are awfully sorry, but there is something rotten in the state of Denmark"

    Scenario: Een Pand in de toekomst reserveren met het aantal personen dat negatief is
      Als Tibo in het veld aantalPersonen "-2" invul
      En in het veld Eind Datum  "02-05-2020" invul
      En op de knop Reserveer click
      #as-is
      Dan moet er een tooltip dialog voorkomen waarbij staat "Waarde moet groter dan of gelijk zijn aan 1"
      #to-be (error pagina)
    #???

    Scenario: Een Pand in het verleden reserveren met het aantal personen gelijk aan 0
      Als Tibo in het veld aantalPersonen "0" invul
      En in het veld Eind Datum  "02-05-2020" invul
      En op de knop Reserveer click
      #as-is
      Dan moet er een tooltip dialog voorkomen waarbij staat "Waarde moet groter dan of gelijk zijn aan 1"
      #to-be (error pagina)
    #???
    Scenario: Een Pand in het verleden reserveren met het aantal personen gelijk aan 1
      Als Tibo in het veld aantalPersonen "1" invul
      En in het veld Eind Datum  "02-05-2020" invul
      En op de knop Reserveer click
      #as-is
      Dan staat er een nieuwe lijn onder Bestaande reservaties met "1 personen 2020-05-02"

    Scenario: Een Pand in het verleden reserveren met het aantal personen gelijk aan Int.Max -1
      Als Tibo in het veld aantalPersonen Int.Max -1 invul
      En in het veld Eind Datum  "02-05-2020" invul
      En op de knop Reserveer click
      #as-is
      Dan staat er een nieuwe lijn onder Bestaande reservaties met "Int.Max -1 personen 2020-05-02"

    Scenario: Een Pand in het verleden reserveren met het aantal personen gelijk aan Int.Max
      Als Tibo in het veld aantalPersonen Int.Max invul
      En in het veld Eind Datum  "02-05-2020" invul
      En op de knop Reserveer click
      #as-is
      Dan staat er een nieuwe lijn onder Bestaande reservaties met "Int.Max personen 2020-05-02"

    Scenario: Een Pand in het verleden reserveren met het aantal personen gelijk aan Int.Max+1
      Als Tibo in het veld aantalPersonen Int.Max+1 invul
      En in het veld Eind Datum  "02-05-2020" invul
      En op de knop Reserveer click
      #as-is
      Dan staat er een nieuwe lijn onder Bestaande reservaties met "Int.Max+1 personen 2020-05-02"





      #buiten de scope ?
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