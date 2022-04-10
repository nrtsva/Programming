package MyMove;

import ru.ifmo.se.pokemon.*;

public class DoubleSlap extends PhysicalMove {
    public DoubleSlap() {
        super(Type.NORMAL, 10, 85);
    }

    @Override
    protected java.lang.String describe() {
        return "Using Double Slap";
    }
}
