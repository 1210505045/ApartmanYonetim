public class TestUygulama {
    public static void main(String[] args) {
        // Kullanıcıları yarat
        Kullanici admin = KullaniciFactory.kullaniciOlustur("admin", 1, "Ahmet", "Kaya", "ahmet.kaya@mail.com", "12345", "A1");
        Kullanici yonetici = KullaniciFactory.kullaniciOlustur("yonetici", 2, "Mehmet", "Yılmaz", "mehmet.yilmaz@mail.com", "67890", "B2");
        Kullanici sakin = KullaniciFactory.kullaniciOlustur("sakin", 3, "Ali", "Demir", "ali.demir@mail.com", "abcde", "C3");

        // Bilgileri göster
        admin.bilgiGoster();
        yonetici.bilgiGoster();
        sakin.bilgiGoster();
    }
}