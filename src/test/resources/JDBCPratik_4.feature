Feature:  Q4



  #Soru 4: Database uzerinden bed tablosunda created_at = 2021-10-25 03:34:25
  # olan yatagin active oldugunu dogrulayiniz.

  Background:
    Given Database baglantisi kurulur.

  @Q4
  Scenario: Database uzerinden bed tablosunda created_at = 2021-10-25 03:34:25 olan yatagin active oldugunu dogrulayiniz.

    Then bed tablosuna sorgu gonderilir ve sonuc dogrulanir.

    And Database baglantisi kapatilir.