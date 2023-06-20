Feature: Q10

  #Soru 10: Database üzerinden death_report tablosundaki ölüm tarihlerine göre
  # en son ölen hastanin guardian_name bilgisinin Kane Stark oldugunu dogrulayiniz.

  @Q10
  Scenario:Database üzerinden death_report tablosundaki ölüm tarihlerine göre
  en son ölen hastanin guardian_name bilgisinin Kane Stark oldugunu dogrulayiniz.

    * Database baglantisi kurulur.

    * death_report toplosuna query gönderilir gelen responce dogrulanir

    * Database baglantisi kapatilir.