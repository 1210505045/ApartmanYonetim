public class ApartmanSakini implements Observer {

    private String isim;

    public ApartmanSakini(String isim) {
        this.isim = isim;
    }

    @Override
    public void update(String mesaj) {
        System.out.println(isim + " adlı apartman sakinine bildirim: " + mesaj);
    }
}
