Projenin Adı: Apartman Yönetim Sistemi

Amaç:
Bu proje, apartman yöneticilerinin aidat, duyuru, şikayet ve kullanıcı bilgilerini kolayca yönetebileceği bir sistem geliştirmeyi amaçlamaktadır. Proje, Java programlama dili kullanılarak ve MySQL veritabanı ile entegre şekilde geliştirilmiştir.

1. Kullanılan Teknolojiler
Programlama Dili: Java
Veritabanı Yönetim Sistemi: MySQL
Kütüphaneler: MySQL Connector
Geliştirme Ortamı: IntelliJ IDEA

2. Proje Özellikleri
Kullanıcı Yönetimi:
Kullanıcı ekleme, listeleme, güncelleme ve silme işlemleri.
Kullanıcı bilgilerinin güvenli şekilde saklanması.

Aidat Yönetimi:
Kullanıcıların aidat bilgilerini takip etme.
Aidatların ödenme durumlarının kontrol edilmesi.
Aidat ekleme, listeleme, güncelleme ve silme işlemleri.

Duyuru Yönetimi:
Apartman sakinlerine yönelik duyurular ekleme ve listeleme.

Şikayet/Talep Yönetimi:
Kullanıcıların sorun ve taleplerini sisteme ekleyebilmesi.
Şikayetlerin listelenmesi.
Veritabanı Bağlantısı:

Singleton tasarım deseni ile güvenli ve merkezi bir veritabanı bağlantısı.
3. Kurulum ve Çalıştırma
Veritabanı Ayarları:

Proje ile birlikte gelen apartman_yonetim.sql dosyasını MySQL üzerinde çalıştırarak gerekli tabloları oluşturdum.

Projenin Çalıştırılması:

Main sınıfını çalıştırarak uygulamayı başlatabilirsiniz.

4. Veritabanı Tabloları
Kullanıcılar Tablosu:
Kullanıcı bilgilerini saklar.

kullanici_id
isim
email
Aidatlar Tablosu:
Kullanıcıların aidat ödeme durumlarını takip eder.

aidat_id
kullanici_id
tutar
durum

Duyurular Tablosu:
Apartman sakinlerine yönelik duyuruları saklar.

duyuru_id
baslik
icerik
Şikayetler/Talepler Tablosu:
Kullanıcıların apartmanla ilgili sorunlarını saklar.

sikayet_id
kullanici_id
baslik
icerik
5. Geliştirme Süreci
Adım 1: Projenin temel sınıfları oluşturuldu.
Adım 2: Veritabanı bağlantısı ve CRUD işlemleri eklendi.
Adım 3: Kullanıcı, aidat, duyuru ve şikayet yönetim özellikleri tamamlandı.
