public class YeniDurum implements SikayetDurumu {
    @Override
    public void durumGuncelle(Sikayet sikayet) {
        System.out.println("Şikayet durumu: Yeni");
        sikayet.setDurum(new IslemdeDurum());
    }
}