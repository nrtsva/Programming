package MyMove;

import ru.ifmo.se.pokemon.*;

public class WorkUp extends StatusMove {
    public WorkUp() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected java.lang.String describe() {
        return "Using WorkUp";
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().stat(Stat.ATTACK, 1).stat(Stat.SPECIAL_ATTACK, 1);
        p.addEffect(e);
    }
}
