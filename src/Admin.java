// Admin Kullanıcı Sınıfı
public class Admin extends Kullanici {
    public Admin(int kullaniciId, String ad, String soyad, String email, String sifre, String daireNo) {
        super(kullaniciId, ad, soyad, email, sifre, daireNo);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Admin Kullanıcı: " + ad + " " + soyad + ", Email: " + email);
    }
}