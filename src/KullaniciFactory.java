// Kullanıcı Factory Sınıfı
public class KullaniciFactory {

    public static Kullanici kullaniciOlustur(String kullaniciTuru, int kullaniciId, String ad, String soyad, String email, String sifre, String daireNo) {
        if (kullaniciTuru == null) {
            return null;
        }

        if (kullaniciTuru.equalsIgnoreCase("admin")) {
            return new Admin(kullaniciId, ad, soyad, email, sifre, daireNo);
        } else if (kullaniciTuru.equalsIgnoreCase("yonetici")) {
            return new Yonetici(kullaniciId, ad, soyad, email, sifre, daireNo);
        } else if (kullaniciTuru.equalsIgnoreCase("sakin")) {
            return new Sakin(kullaniciId, ad, soyad, email, sifre, daireNo);
        }

        return null;
    }
}
