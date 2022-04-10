package MyPokemon;

import ru.ifmo.se.pokemon.*;

public class Yamask extends Pokemon {
    public Yamask(String name, int level ) {
        super(name, level);
        this.setType(Type.GHOST);
        this.setStats(38, 30, 85, 55, 65, 30);

        /* Set Moves */
        this.setMove(new MyMove.Rest(), new MyMove.WorkUp(), new MyMove.Swagger());
    }
}