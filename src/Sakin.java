// Sakin Kullanıcı Sınıfı
public class Sakin extends Kullanici {
    public Sakin(int kullaniciId, String ad, String soyad, String email, String sifre, String daireNo) {
        super(kullaniciId, ad, soyad, email, sifre, daireNo);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Sakin Kullanıcı: " + ad + " " + soyad + ", Email: " + email);
    }
}