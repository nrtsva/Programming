package MyMove;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 90);
    }

    @Override
    protected java.lang.String describe() {
        return "Using Swagger";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect e = new Effect().stat(Stat.ATTACK, 2);
        p.addEffect(e);
        Effect.confuse(p);
    }
}
