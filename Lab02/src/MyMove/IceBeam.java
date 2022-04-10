package MyMove;

import ru.ifmo.se.pokemon.*;

public class IceBeam extends SpecialMove {
    public IceBeam() {
        super(Type.ICE, 95, 100);
    }

    @Override
    protected java.lang.String describe() {
        return "Using Ice Beam";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect e = new Effect().chance(0.1).condition(Status.FREEZE);
        p.addEffect(e);
    }
}
