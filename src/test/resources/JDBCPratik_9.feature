Feature: @9
  #Soru 9: Database uzerinden charge_categories tablosundaki name bilgisi "P" ile baslayan
  # iceriklerin charge_type_id numaralarini tekrardan arindirilmis olarak listeleyiniz
  # ve dogrulayiniz. (6 , 7)


  @Q9
  Scenario: Database uzerinden charge_categories tablosundaki
            name bilgisi "P" ile baslayan iceriklerin charge_type_id
            numaralarini tekrardan arindirilmis olarak listeleyiniz
            ve dogrulayiniz. (6 , 7)

  * Database baglantisi kurulur.
  * Charge_categories tablosuna query gonderılır ve sonuc dogrulanır
  * Database baglantisi kapatilir.

