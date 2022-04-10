public abstract class Shorties {
    String Name;
    Activity activity;
    Age age;

    public Shorties( String name ) {
        Name = name;
        activity = Activity.NOTHING;
        age = Age.UNKNOWN;
    }

    public abstract Rubber GetRubber( neFicus flower );
    public abstract Rubber GetRubber( Get_Rubber product );

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (this.getClass() == obj.getClass()) {
            Shorties guest = (Shorties) obj;
            if (this.Name == guest.Name)
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return Name + ": Status = " + activity;
    }

    @Override
    public int hashCode() {
        final int prime = 30;
        int result = 1;

        result = prime + ((Name == null) ? 0 : Name.hashCode());
        return result;
    }
}
