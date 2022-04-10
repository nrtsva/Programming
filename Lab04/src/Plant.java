public class Plant {
    /* Plant characteristics */
    int size;
    double juiceV;


    public Plant() {
        size = 1;
        juiceV = Math.random();
    }

    public void Grow() {
        size += Math.random() >= 0.5 ? 1 : 0;
        juiceV += size * Math.random();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (this.getClass() == obj.getClass()) {
            Plant guest = (Plant) obj;
            if (this.size == guest.size && this.juiceV == guest.juiceV)
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getClass() + ": size = " + size + ", amount of juice = " + juiceV;
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int result = 1;

        result = prime + size + (int)juiceV;
        return result;
    }
}
