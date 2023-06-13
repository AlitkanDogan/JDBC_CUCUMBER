Feature: Q1

  # Soru 1: Database üzerinden appointment tablosundaki patient_id = 20
  # olan hastanin canli muayene isteginin acik oldugunu dogrulayiniz.

  Background:
    * Database baglantisi kurulur.

  @Q1
  Scenario: Database üzerinden appointment tablosundaki patient_id = 20 olan hastanin canli muayene isteginin acik oldugunu dogrulayiniz.

    * appoimtment query gonderilir ve  sonuc dogrulanir.

    * Database baglantisi kapatilir.