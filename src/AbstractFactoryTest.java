public class AbstractFactoryTest {
    public static void main(String[] args) {
        AidatFactory normalFactory = new NormalAidatFactory();
        Aidat normalAidat = normalFactory.aidatOlustur();
        normalAidat.odemeYap();

        AidatFactory gecikmeliFactory = new GecikmeliAidatFactory();
        Aidat gecikmeliAidat = gecikmeliFactory.aidatOlustur();
        gecikmeliAidat.odemeYap();
    }
}
