import ru.ifmo.se.pokemon.*;
import MyPokemon.*;

public class Main {
    public static void main( String[] args ) {
        Battle b = new Battle();
        Solrock p1 = new Solrock("", 30);
        Yamask p2 = new Yamask("", 30);
        Cofagrigus p3 = new Cofagrigus("", 30);
        Elekid p4 = new Elekid("", 30);
        Electabuzz p5 = new Electabuzz("", 30);
        Electivire p6 = new Electivire("", 30);

        b.addAlly(p1);
        b.addFoe(p2);
        b.addAlly(p3);
        b.addAlly(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
