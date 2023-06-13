Feature: Q3

  Background:
    Given Database baglantisi kurulur.

    # Soru 3: Database üzerinden 2023 yili Mayis ayinda olusturulan
    # icerikleri appointment_queue sutununa göre siralayin.

  @Q3
  Scenario: Database üzerinden 2023 yili Mayis ayinda olusturulan icerikleri appointment_queue sutununa göre siralayin.

    Then appointment_queue tablosuna Q3 gondrilir ve sonuc getirilir.

    And Database baglantisi kapatilir.