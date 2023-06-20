Feature: Q11
  #Soru 11: Database üzerinden discharge_card tablosundaki opd_details_id'si 11 ile 31 arasindaki (11 ve 31 haric) verlerin created_at bilgilerini dogrulayiniz.

  @Q11
  Scenario:  Database üzerinden discharge_card tablosundaki opd_details_id'si 11 ile 31 arasindaki (11 ve 31 haric) verlerin created_at bilgilerini dogrulayiniz.

    * Database baglantisi kurulur.

    * discharge_card tablosuna query gönderilir responce doğrulanır

    * Database baglantisi kapatilir.