// Abstract Kullanıcı Sınıfı
public abstract class Kullanici {
    protected int kullaniciId;
    protected String ad;
    protected String soyad;
    protected String email;
    protected String sifre;
    protected String daireNo;

    public Kullanici(int kullaniciId, String ad, String soyad, String email, String sifre, String daireNo) {
        this.kullaniciId = kullaniciId;
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.sifre = sifre;
        this.daireNo = daireNo;
    }

    public abstract void bilgiGoster();

    public int getKullaniciId() {
        return kullaniciId;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getEmail() {
        return email;
    }

    public String getDaireNo() {
        return daireNo;
    }
}


