public class GecikmeliAidatFactory implements AidatFactory {
    @Override
    public Aidat aidatOlustur() {
        return new GecikmeliAidat();
    }
}