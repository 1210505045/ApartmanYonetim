public class Sikayet {

    private String konu;
    private SikayetDurumu durum;

    public Sikayet(String konu) {
        this.konu = konu;
        this.durum = new YeniDurum();
    }

    public void setDurum(SikayetDurumu durum) {
        this.durum = durum;
    }

    public void ilerleDurum() {
        durum.durumGuncelle(this);
    }
}
