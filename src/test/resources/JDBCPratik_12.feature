Feature: Q12
  #Soru 12: Database üzerinden doctor_shift tablosunda staff_id=2 olan doctorun sali gunu kac saat calistigini dogrulayiniz. (2)

  @Q12
  Scenario: Database üzerinden doctor_shift tablosunda staff_id=2 olan doctorun sali gunu kac saat calistigini dogrulayiniz. (2)

    * Database baglantisi kurulur.

    * doctor_shift tablosuna query gönderilir responce doğrulanır

    * Database baglantisi kapatilir.