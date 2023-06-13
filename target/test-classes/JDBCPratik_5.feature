Feature: Q5

  Background:
    Given  Database baglantisi kurulur.


 #Soru 5: Database üzerinden bed tablosunda bed group id'si
 #4 ve is_active= "no" olan hastanin name bilgisinin 105 oldugunu dogrulayiniz.

  @Q5
  Scenario:
  Soru 5: Database üzerinden bed tablosunda bed group id'si 4 ve is_active= "no" olan hastanin name bilgisinin 105 oldugunu dogrulayiniz.

    Then bed tablosuna query5 gönderilir ve name bilgisinin 105 olduğu doğrulanır.

    And Database baglantisi kapatilir.