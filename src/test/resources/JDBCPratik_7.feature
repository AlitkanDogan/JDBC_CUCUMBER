Feature: Q6
  Background:
    * Database baglantisi kurulur.

    #Soru 7: Database üzerinden birth_report tablosunda kardes olan bebekleri listeleyip isimlerini dogrulayiniz.

  @Q7
  Scenario: Database üzerinden birth_report tablosunda kardes olan bebekleri listeleyip isimlerini dogrulayiniz.

    * birth_report tablosuna query gönderilir sonuc dogrulanır

    * Database baglantisi kapatilir.