public class neFicus extends Plant implements Get_Rubber {

    public neFicus() {
        super();
    }

    @Override
    public Rubber Get() {
        if (juiceV > 2) {
            double x = Math.random() * 2;
            juiceV -= x;
            return new Rubber(x, 0);
        }
        return new Rubber(0, 0);
    }
}
