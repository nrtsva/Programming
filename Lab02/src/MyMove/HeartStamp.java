package MyMove;

import ru.ifmo.se.pokemon.*;

public class HeartStamp extends PhysicalMove {

    public HeartStamp() {
        super(Type.PSYCHIC, 60, 100);
    }

    @Override
    protected java.lang.String describe() {
        return "Using Heart Stamp";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.3)
            Effect.flinch(p);
    }
}
