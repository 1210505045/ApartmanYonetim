public class IslemdeDurum implements SikayetDurumu {
    @Override
    public void durumGuncelle(Sikayet sikayet) {
        System.out.println("Şikayet durumu: İşlemde");
        sikayet.setDurum(new CozulduDurum());
    }
}
