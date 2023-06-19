Feature: Q8

  #Soru 8: Database üzerinden blood_donor tablosundaki id= 7 olan donorun
  # donor_name'i Maria,
  # date_of_birth=2001-03-02,
  # gender=Female,
  # father_name=Jhonson,
  # address=England
  # oldugunu dogrulayiniz.


  @Q8
  Scenario: Database üzerinden blood_donor tablosundaki id= 7 olan donorun donor_name'i Maria,
  date_of_birth=2001-03-02, gender=Female, father_name=Jhonson, address=England oldugunu dogrulayiniz.

    * Database baglantisi kurulur.
    * blood_donor tablosuna query gonderilir, gelen sonuc dogrulanir
    * Database baglantisi kapatilir.


