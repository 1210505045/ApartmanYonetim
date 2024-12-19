// Yönetici Kullanıcı Sınıfı
public class Yonetici extends Kullanici {
    public Yonetici(int kullaniciId, String ad, String soyad, String email, String sifre, String daireNo) {
        super(kullaniciId, ad, soyad, email, sifre, daireNo);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Yönetici Kullanıcı: " + ad + " " + soyad + ", Email: " + email);
    }
}