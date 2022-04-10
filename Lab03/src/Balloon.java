public class Balloon extends RubberProduct implements Flyable {
    /* Balloon characteristics */
    int size, v;
    final int MaxSize = 10;


    public  Balloon() {
        super(50, 0.5, TypeOfProduct.BALLOON);
        size = 0;
        v = 0;
    }

    public void Inflate() {
        if (Math.random() > 0.5) {
            if (size < MaxSize)
                size += Math.random() >= 0.5 ? 1 : 0;
            v = (size - MaxSize / 2) * (size - MaxSize / 2) + (MaxSize / 2) * (MaxSize / 2);
        }
        else {
            if (size > 0)
                size -= Math.random() >= 0.5 ? 0 : 1;
            v = (size - MaxSize / 2) * (size - MaxSize / 2) + (MaxSize / 2) * (MaxSize / 2);
        }
    }

    @Override
    public void Fly() {
        System.out.println("Летим со скоростью " + v);
    }

}
