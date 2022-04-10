public class SpeedException extends Exception{
    private float speed;

    public float getSpeed() {
        return speed;
    }

    public SpeedException( String message, float s ) {
        super(message);
        speed = s;
    }
}
