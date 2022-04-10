package MyPokemon;

public class Cofagrigus extends Yamask {
    public Cofagrigus(String name, int level ) {
        super(name, level);
        this.setStats(58, 50, 145, 95, 105, 30);

        /* Set Moves */
        this.addMove(new MyMove.EnergyBall());
    }
}