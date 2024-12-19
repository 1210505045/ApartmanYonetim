public class ObserverTest {
    public static void main(String[] args) {
        DuyuruYonetimi duyuruYonetimi = new DuyuruYonetimi();

        // Apartman sakinlerini (gözlemcileri) ekliyoruz
        ApartmanSakini sakin1 = new ApartmanSakini("Ahmet");
        ApartmanSakini sakin2 = new ApartmanSakini("Ayşe");
        ApartmanSakini sakin3 = new ApartmanSakini("Mehmet");

        duyuruYonetimi.addObserver(sakin1);
        duyuruYonetimi.addObserver(sakin2);
        duyuruYonetimi.addObserver(sakin3);

        // Yeni duyuru ekleniyor
        duyuruYonetimi.duyuruEkle("Aidat Ödemesi", "Lütfen bu ayki aidatlarınızı 20 Aralık'a kadar ödeyiniz.");
    }
}




