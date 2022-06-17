package server.data;

/**
 * Class for describing field Coordinates of dragon
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class Coordinates {
    private int x;
    private Float y; //Максимальное значение поля: 508, Поле не может быть null

    /**
     * Constructor for making Coordinates field
     */
    public Coordinates() {
        x = 0;
        y = Float.valueOf(0f);
    }

    /**
     * Constructor for making Coordinates field
     *
     * @param X - x-coordinate
     * @param Y - y-coordinate
     */
    public Coordinates( int X, Float Y ) {
        x = X;
        y = Y <= 508 ? Y : Float.valueOf(0f);
    }

    /**
     * Method for setting Coordinates fields
     *
     * @param X - x-coordinate
     * @param Y - y-coordinate
     */
    public void setCoordinates( int X, float Y ) {
        x = X;
        y = Y <= 508 ? Float.valueOf(Y) : Float.valueOf(0f);
    }

    public int getXCoordinate() {
        return x;
    }
    public float getYCoordinate() {
        return y;
    }
    @Override
    /**
     * Method for printing this field into a string representation
     */
    public String toString() {
        return "{" + x + "; " + y + "}";
    }
}
