package MyPokemon;

public class Electabuzz extends Elekid {
    public Electabuzz(String name, int level ) {
        super(name, level);
        this.setStats(65, 83, 57, 95, 85, 105);

        /* Set Moves */
        this.addMove(new MyMove.DoubleKick());
    }
}
