public class RubberProduct implements Waste_Rubber, Get_Rubber {
    /* rubber characteristics */
    private double rubberV, rubberK;
    TypeOfProduct Type;

    public RubberProduct(double V, double k, TypeOfProduct T) {
        rubberV = V;
        rubberK = k;
        Type = T;
    }


    @Override
    public Rubber Get() {
        return new Rubber(rubberV, rubberK);
    }

    @Override
    public Rubber Create( Rubber R ) {
        if (R.k >= rubberK && R.V > rubberV) {
            R.V -= rubberV;
        }

        return R;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (this.getClass() == obj.getClass()) {
            RubberProduct guest = (RubberProduct) obj;
            if (this.rubberV == guest.rubberV && this.rubberK == guest.rubberK && this.Type == guest.Type)
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Rubber " + Type + ": V = " + rubberV + ", k = " + rubberK;
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int result = 1;

        result = prime + (int)(rubberV + rubberK) + (Type == null ? 0 : Type.hashCode());
        return result;
    }
}
