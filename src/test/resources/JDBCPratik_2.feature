Feature: @2

Background:
  Given Database baglantisi kurulur.

  # Soru 2: Database üzerinden appointment_payment tablosunda odeme turu olarak
  # "offline" secenl hasta id'lerinin (1,2,3,16,17,18,20,21,24,25,31) oldugunu dogrulayiniz.

  @Q2
  Scenario: Database üzerinden appointment_payment tablosunda odeme turu olarak "offline" secenl hasta id'lerinin (1,2,3,16,17,18,20,21,24,25,31) oldugunu dogrulayiniz.

    Then appointment_payment tablosuna query gonderilir ve sonuclar dogrulanir.

    And Database baglantisi kapatilir.
