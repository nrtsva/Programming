package MyPokemon;

public class Electivire extends Electabuzz {
    public Electivire(String name, int level ) {
        super(name, level);
        this.setStats(75, 123, 67, 95, 85, 95);

        /* Set Moves */
        this.addMove(new MyMove.Confusion());
    }
}
