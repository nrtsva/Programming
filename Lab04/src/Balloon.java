public class Balloon extends RubberProduct implements Flyable {
    FlightParameters Param;

    public  Balloon() {
        super(50, 0.5, TypeOfProduct.BALLOON);
        Param = new FlightParameters();
    }

    public void Inflate() throws SpeedException {
            Param.Update();
    }

    @Override
    public String Fly() {
        return "Летим со скоростью " + Param.GetSpeed();
    }

    static class FlightParameters {
        private int BalloonSize;
        private float speed;

        public FlightParameters() {
            BalloonSize = 0;
            speed = 0;
        }

        void SetSpeed( float v ) {
            speed = v;
        }

        float GetSpeed() {
            return speed;
        }

        public void Update() throws SpeedException  {
            double x = Math.random();
            BalloonSize += x > 0.5 ? 1 : x < 0.2 ? -1 : 0;
            speed = (float)(Math.random() + 1) * BalloonSize * 10;

            if (speed < 0) {
                throw new SpeedException("Speed is less then 0", speed);
            }
        }
    }
}
