# language: nl

  Functionaliteit: Een review op een pand plaatsen.
    Het moet voor een huurder mogelijk zijn om een review te plaatsen op een bestaande pand.
    Een screener kan een onverwerkte review verwerken.
    Een screener kan een onverwerkte review verbergen.
    Een screener kan een verwerkt pand verbergen.
    Zodra het pand gearchiveerd is zijn de reviews van het pand final.

    Achtergrond:
      Gegeven er is een bestaand pand
      En er is een klant Tibo ingelogd
      En er is een screener Pierre ingelogd


    #TODO - Vragen of "plaats beschrijving x met score x" zonder "EN" mag.
    #TC1 - S0 --> S1
    Scenario: De review van het pand kan worden aangemaakt met een aanvaardbare beschrijving
      Als Tibo een review plaatst met als beschrijving "supertof pand" met score 5
      Dan zal de review status "Onverwerkt" zijn

    #TC1 - S1 --> S2
    Scenario: De review van het pand is aangemaakt en wordt verwerkt door de screener
      Als Tibo een review plaatst met als beschrijving "supertof pand" met score 5
      En de status van de review is "Onverwerkt"
      En Pierre verwerkt de review
      Dan zou de review status "Verwerkt" moeten zijn

    #TC1 - S2 --> S3
    Scenario: De review van het pand is verwerkt en kan worden verborgen
      Als Tibo een review plaatst met als beschrijving "supertof pand" met score 5
      En de status van de review is "Onverwerkt"
      En Pierre verwerkt de review
      En de status van de review is "Verwerkt"
      En Pierre verbergt de review
      Dan zou de review status "Verborgen" moeten zijn

    #TC1 - S3 --> S4
    Scenario: De review van het pand is verwerkt, verborgen en kan worden verwijderd
      Als Tibo een review plaatst met als beschrijving "supertof pand" met score 5
      En de status van de review is "Onverwerkt"
      En Pierre verwerkt de review
      En de status van de review is "Verwerkt"
      En Pierre verbergt de review
      En de status van de review is "Verborgen"
      En het pand waaraan de review gekoppeld is wordt verwijdert
      Dan zou de review niet meer mogen bestaan

    #TC2 - S0 --> S1
    Scenario: De review van het pand kan worden aangemaakt met een onaanvaardbare beschrijving
      Als Tibo een review plaatst met als beschrijving "fuck you dit is een lelijk kutpand" met score 0
      Dan zal de review status "Onverwerkt" zijn

    #TC2 - S1 --> S3
    Scenario: De review van het pand is aangemaakt en kan worden verborgen
      Als Tibo een review plaatst met als beschrijving "fuck you dit is een lelijk kutpand" met score 0
      En de status van de review is "Onverwerkt"
      En Pierre verbergt de review
      Dan zou de review status "Verborgen" moeten zijn

    #TC2 - S5 --> S4
    Scenario: De review van het pand is aangemaakt, verborgen en het pand wordt verwijderd
      Als Tibo een review plaatst met als beschrijving "fuck you dit is een lelijk kutpand" met score 0
      En de status van de review is "Onverwerkt"
      En Pierre verbergt de review
      En de status van de review is "Verborgen"
      En het pand waaraan de review gekoppeld is wordt verwijdert
      Dan zou de review niet meer mogen bestaan

