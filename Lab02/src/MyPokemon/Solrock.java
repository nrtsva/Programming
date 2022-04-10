package MyPokemon;

import ru.ifmo.se.pokemon.*;

public class Solrock extends Pokemon {
    public Solrock(String name, int level ) {
        super(name, level);
        this.setType(Type.ROCK, Type.PSYCHIC);
        this.setStats(90, 95, 85, 55, 65, 70);

        /* Set Moves */
        this.setMove(new MyMove.HeartStamp(), new MyMove.DoubleSlap(), new MyMove.FocusBlast(), new MyMove.IceBeam());
    }
}