package DragonParameters;

public class DragonHead {
    private int size;
    private long eyesCount;
    private Long toothCount; //Поле может быть null

    public DragonHead(){
        size = 0;
        eyesCount = 0;
        toothCount = null;
    }

    public DragonHead( int s, long e, Long t ){
        size = s;
        eyesCount = e;
        toothCount = t;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void setEyesCount(long eyesCount) {
        this.eyesCount = eyesCount;
    }
    public void setToothCount(Long toothCount) {
        this.toothCount = toothCount;
    }


    @Override
    public String toString() {
        return "{" + size + "; " + eyesCount + "; " + toothCount + "}";
    }

    @Override
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
