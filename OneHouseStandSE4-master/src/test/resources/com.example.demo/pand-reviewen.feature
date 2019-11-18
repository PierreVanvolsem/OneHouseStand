# language: nl

#  Functionaliteit: Een review op een pand plaatsen.
 #   Het moet voor een huurder mogelijk zijn om een review te plaatsen op een bestaande pand.
  #  Een screener kan een review verbergen.
   # Zodra de pand gearchiveerd is zijn de reviews van de pand final.

#    Achtergrond:
 #     Gegeven er is een bestaand pand Waterkasteel Moorsel
  #    En er is een huurder Tibo ingelogd.
   #   En er is een screener Pierre ingelogd.

      #FTG2
#      Scenario: De review van de pand wordt aangemaakt
 #       Als Tibo een review plaatst met als beschrijving "Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand!" met score 6
  #      Dan zal de review status "Onverwerkt" zijn.

#      Scenario: De screener kan een review verbergen
 #       Gegeven Tibo heeft een review geplaatst met als beschrijving "Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand!" met score 6
  #      Als de screener op de knop verberg review klikt
   #     Dan zal de review status "Verborgen" zijn.

    #  Scenario: De screener kan een pand archiveren
     #   Gegeven Tibo heeft een review geplaatst met als beschrijving "Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand! Dit is een supermooi pand!" met score 6
      #  En de review heeft status "Verborgen"
        #Als de screener op de knop archiveer pand klikt
       # Dan zal de review null zijn.