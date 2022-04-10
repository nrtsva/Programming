public class SmartShorties extends AdultShorties {
    public SmartShorties(String name) {
        super(name);
        activity = Activity.THINK;
    }

    public void Command( Shorties S, Activity newActivity ) {
        S.activity = newActivity;
    }
}
