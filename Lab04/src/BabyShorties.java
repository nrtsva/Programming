public class BabyShorties extends Shorties {
    public BabyShorties( String name ) {
        super(name);
        age = Age.BABY;
    }

    @Override
    public Rubber GetRubber(neFicus flower) {
        return new Rubber(flower.Get().V / 2, flower.Get().k);
    }

    @Override
    public Rubber GetRubber( Get_Rubber product ) {
        return new Rubber(0, 0);
    }
}
