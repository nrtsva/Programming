package server.data;

/**
 * Class for describing field DragonHead of dragon
 *
 * @author Anna Nartseva
 * @version 1.0
 */
public class DragonHead {
    private int size;
    private long eyesCount;
    private Long toothCount; //Поле может быть null

    /**
     * Constructor for making DragonHead field
     */
    public DragonHead(){
        size = 0;
        eyesCount = 0;
        toothCount = null;
    }

    /**
     * Constructor for making DragonHead field
     *
     * @param s - size
     * @param e - count of eyes
     * @param t - count of tooth
     */
    public DragonHead( int s, long e, Long t ){
        size = s;
        eyesCount = e;
        toothCount = t;
    }

    /**
     * Method for setting size
     *
     * @param size - size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Method for setting eyesCount
     *
     * @param eyesCount - count of eyes
     */
    public void setEyesCount(long eyesCount) {
        this.eyesCount = eyesCount;
    }

    /**
     * Method for setting toothCount
     *
     * @param toothCount - count of tooth
     */
    public void setToothCount(Long toothCount) {
        this.toothCount = toothCount;
    }

    /**
     * Method for setting head
     *
     * @param size - head size
     * @param eyesCount - count of eyes
     * @param toothCount - count of tooth
     */
    public void set(int size, long eyesCount, Long toothCount) {
        this.size = size;
        this.eyesCount = eyesCount;
        this.toothCount = toothCount;
    }


    @Override
    /**
     * Method for printing this field into a string representation
     */
    public String toString() {
        return "{" + size + "; " + eyesCount + "; " + toothCount + "}";
    }

    @Override
    /**
     * Method for to compare elements
     *
     * @param obj - DragonHead objects
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (this.getClass() == obj.getClass()) {
            DragonHead guest = (DragonHead) obj;
            if (this.size == guest.size && this.eyesCount == guest.eyesCount && this.toothCount == guest.toothCount)
                return true;
        }

        return false;
    }
}
