public class Main {
    public static void main(String[] args) {
        // Singleton Veritabanı Bağlantısını Test Et
        VeritabaniBaglantisi veritabaniBaglantisi = VeritabaniBaglantisi.getInstance();

        // Aidat Yönetimi Test
        AidatYonetimi aidatYonetimi = new AidatYonetimi();
        aidatYonetimi.aidatEkle(1, 500.0, "2024-12-18", "Ödenmedi");
        aidatYonetimi.aidatlariListele();

        // Duyuru Yönetimi Test
        DuyuruYonetimi duyuruYonetimi = new DuyuruYonetimi();
        duyuruYonetimi.duyuruEkle("Toplantı", "Yarın toplantı yapılacaktır.");
        duyuruYonetimi.duyurulariListele();

        // Şikayet Yönetimi Test
        SikayetYonetimi sikayetYonetimi = new SikayetYonetimi();
        sikayetYonetimi.sikayetEkle(2, "Elektrik Kesintisi", "Dairemde sık sık elektrik kesiliyor.");
        sikayetYonetimi.sikayetleriListele();
    }
}
