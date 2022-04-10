public class AdultShorties extends Shorties {
    public AdultShorties(String name) {
        super(name);
        age = Age.ADULT;
    }

    @Override
    public Rubber GetRubber(neFicus flower) {
        return flower.Get();
    }

    @Override
    public Rubber GetRubber( Get_Rubber product ) {
        return product.Get();
    }
}
