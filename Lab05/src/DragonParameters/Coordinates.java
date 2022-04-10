package DragonParameters;

public class Coordinates {
    private int x;
    private Float y; //Максимальное значение поля: 508, Поле не может быть null

    public Coordinates() {
        x = 0;
        y = Float.valueOf(0f);
    }

    public Coordinates( int X, Float Y ) {
        x = X;
        y = Y <= 508 ? Y : Float.valueOf(0f);
    }

    public void setCoordinates( int X, float Y ) {
        x = X;
        y = Y <= 508 ? Float.valueOf(Y) : Float.valueOf(0f);
    }

    @Override
    public String toString() {
        return "{" + x + "; " + y + "}";
    }
}
