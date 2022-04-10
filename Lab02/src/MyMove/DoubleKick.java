package MyMove;

import ru.ifmo.se.pokemon.*;

public class DoubleKick extends PhysicalMove {
    public DoubleKick() {
        super(Type.FIGHTING, 30, 100, 0, 2);
    }

    @Override
    protected java.lang.String describe() {
        return "Using Double Kick";
    }
}
