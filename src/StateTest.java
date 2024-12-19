public class StateTest {
    public static void main(String[] args) {
        Sikayet sikayet = new Sikayet("Elektrik Kesintisi");

        sikayet.ilerleDurum(); // Yeni -> İşlemde
        sikayet.ilerleDurum(); // İşlemde -> Çözüldü
        sikayet.ilerleDurum(); // Çözüldü (Daha fazla ilerlemez)
    }
}
