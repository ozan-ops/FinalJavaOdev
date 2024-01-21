# Ders, Öğrenci ve Öğretim Görevlisi Kayıt Uygulaması

* Bu proje, ders, öğrenci ve öğretim görevlisi kayıt projesidir.
* Projede 4 form, 3 sınıf (form sınıfları ile birlikte 7 sınıf) bulunmaktadır.
* Projede veriler JTable nesnesinde listelenmektedir.

## Nasıl Çalışır

1. Anasayfa çalıştırılır.
2. Ders eklemek için açılan pencerede Ders Kaydı Oluştur'a tıklanır.
3. Öğrenci eklemek için açılan pencerede Öğrenci Kaydı Oluştur'a tıklanır.
4. Öğretim görevlisi eklemek için açılan pencerede Öğretmen Kaydı Oluştur'a tıklanır.
5. Ders eklemek için tüm alanlar doldurulur. Tüm alanlar doldurulmaz ise işlem gerçekleştirilmez.
6. Öğrenci eklemek için tüm alanlar doldurulur. Tüm alanlar doldurulmaz ise işlem gerçekleştirilmez.
7. Öğretim görevlisi eklemek için tüm alanlar doldurulur. Tüm alanlar doldurulmaz ise işlem gerçekleştirilmez.
* Not: Öğrenci Kayıt sayfasında öğrenci bölümü girilir ve Enter tuşuna basılır. Bölüme göre dersler combobox nesnesinde listelenir.
* Not: Öğretmen Kayıt sayfasında dersler belgeden okunur ve combobox nesnesinde listelenir.
* Not: Ders Kayıt sayfasında öğretmenler belgeden okunur ve combobox nesnesinde listelenir.

## Formlar

- Anasayfa: Menü penceresidir.
- DersOlustur: Ders ekleme ve arama penceresidir.
- OgrenciKayit: Öğrenci ekleme ve arama penceresidir.
- OgretmenKayit: Öğretim görevlisi ekleme ve arama penceresidir.

## Sınıflar

- Ders: Ders bilgilerini tutan ve bu bilgileri işleyen sınıftır.
- Ogrenci: Öğrenci bilgilerini tutan ve bu bilgileri işleyen sınıftır.
- Ogretmen: Öğretmen bilgilerini tutan ve bu bilgileri işleyen sınıftır.

- Anasayfa, DersOlustur, OgrenciKayit ve OgretmenKayit sınıfları pencere sınıflarıdır.

## Metodlar

- Ders -> Ders: Sınıfın kurucu metotudur. Parametre olarak gönderilen değerleri ilgili alanlara atar.
- Ders -> getDersSinifi: dersSinifi alanını geri döndürür.
- Ders -> setDersSinifi: Parametre olarak gönderilen değeri dersSinifi alanına atar.
- Ders -> getOgretmenAdiSoyadi: ogretmenAdiSoyadi alanını geri döndürür.
- Ders -> setOgretmenAdiSoyadi: Parametre olarak gönderilen değeri ogretmenAdiSoyadi alanına atar.
- Ders -> toCSV: Sınıf alanlarını CSV formatına göre sıralar ve sıralanmış veriyi geri döndürür.

- DersOlustur -> filterTableByDersID: Parametre olarak gönderilen değerlere göre tabloyu sadece ders adına göre filtreler.
- DersOlustur -> kaydetDersBilgileri: Dersleri CSV belgesine kayıt eder.
- DersOlustur -> getOgretmenFromCsv: Öğretmenin verdiği dersleri geri döndürür.

- Ogrenci -> Ogrenci: Sınıfın kurucu metotudur. Parametre olarak gönderilen değerleri ilgili alanlara atar.
- Ogrenci -> toCSV: Sınıf alanlarını CSV formatına göre sıralar ve sıralanmış veriyi geri döndürür.

- OgrenciKayit -> filterTableByOgrnciID: Parametre olarak gönderilen değerlere göre tabloyu sadece öğrenci numarasına göre filtreler.
- OgrenciKayit -> getBolumeAitDersler: Parametre olarak gönderilen bölüm değerine göre o bölüme ait dersleri geri döndürür.
- OgrenciKayit -> append: Dizi genişletme metotudur.
- OgrenciKayit -> kaydetOgrenciBilgileri: Öğrencileri CSV belgesine kayıt eder.

- Ogretmen -> Ogretmen: Sınıfın kurucu metotudur. Parametre olarak gönderilen değerleri ilgili alanlara atar.
- Ogretmen -> toCSV: Sınıf alanlarını CSV formatına göre sıralar ve sıralanmış veriyi geri döndürür.

- OgretmenKayit -> filterTableByOgrtID: Parametre olarak gönderilen değerlere göre tabloyu sadece öğretmen numarasına göre filtreler.
- OgretmenKayit -> kaydetOgretmenBilgileri: Öğretmenleri CSV belgesine kayıt eder.
- OgretmenKayit -> getDerslerFromCSV: Öğretmenin verdiği dersleri geri döndürür.
