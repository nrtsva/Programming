package MyMove;

import ru.ifmo.se.pokemon.*;

public class Confusion extends SpecialMove {

    public Confusion() {
        super(Type.PSYCHIC, 50, 100);
    }

    @Override
    protected java.lang.String describe() {
        return "Using Confusion";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.1)
            Effect.confuse(p);
    }
}
