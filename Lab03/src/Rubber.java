public class Rubber {
    double V, k;

    public Rubber() {
        V = 0;
        k = 0;
    }

    public Rubber(double v, double coef) {
        V = v;
        k = coef;
    }

    public void Freeze() {
        if (V != 0)
            k += 0.1;
    }

    public Rubber Plus( Rubber R ) {
        double resV = V + R.V,
               resK = (V * k + R.V * R.k) / (resV == 0 ? 1 : resV);
        return new Rubber(resV, resK);
    }
}
