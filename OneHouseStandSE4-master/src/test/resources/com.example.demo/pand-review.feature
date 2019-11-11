# language: nl

  Functionaliteit: Een review op een pand plaatsen.
    Het moet voor een huurder mogelijk zijn om een review te plaatsen op een bestaande pand.
    Het systeem kan een review verwerken.
    Een screener kan een review verbergen.
    Zodra de pand gearchiveerd is zijn de reviews van de pand final.

    Achtergrond:
      Gegeven er is een bestaande pand
      En er is een huurder Tibo ingelogd.

      #FTG1
      Scenario: De review van de pand wordt verwerkt
        Als Tibo een review plaatst met als beschrijving "Dit is een supermooi pand!"
        En de score van de review is 4
        En het systeem verwerkt de review
        En het systeem beschouwt de review als verwerkt
        En de screener verbergt de review
        En de pand van de review wordt gearchiveerd.
        Dan zal de verwerkte review final zijn.
