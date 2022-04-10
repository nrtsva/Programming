package MyPokemon;

import ru.ifmo.se.pokemon.*;

public class Elekid extends Pokemon {
    public Elekid(String name, int level ) {
        super(name, level);
        this.setType(Type.ELECTRIC);
        this.setStats(45, 63, 37, 65, 55, 90);

        /* Set Moves */
        this.setMove(new MyMove.DoubleTeam(), new MyMove.Rest());
    }
}
