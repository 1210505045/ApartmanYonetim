public class NormalAidatFactory implements AidatFactory {
    @Override
    public Aidat aidatOlustur() {
        return new NormalAidat();
    }
}