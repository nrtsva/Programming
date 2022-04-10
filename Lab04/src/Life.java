public class Life {
    SmartShorties Leader;
    Shorties Characters[] = new Shorties[5];
    neFicus Flowers[] = new neFicus[5];
    int NumOfCharacters, NumOfPlants;
    Rubber Keg;
    Balloon balloon;
    info INFO = new info();

    public Life() {
        NumOfCharacters = 0;
        NumOfPlants = 0;
        Keg = new Rubber();
        balloon = new Balloon();
    }

    public void AddLeader( SmartShorties P ) {
        Leader = P;
    }

    public void AddCharacters( Shorties P ) {
        if (NumOfCharacters < 5) {
            Characters[NumOfCharacters] = P;
            NumOfCharacters++;
        }
    }

    public void AddPlant( neFicus F ) {
        if (NumOfPlants < 5) {
            Flowers[NumOfPlants] = F;
            NumOfPlants++;
        }
    }

    public void Go() {
        boolean RubberFlag = false,
                BalloonFlag = false;

        INFO.OutPut();
        Leader.activity = Activity.COMMAND;
        for (int i = 0; i < NumOfCharacters; i++) {
            Leader.Command(Characters[i], Activity.COLLECT_JUICE);
        }

        int t = 0;
        while (t < 20) {
            for (int j = 0; j < NumOfPlants; j++)
                Flowers[j].Grow();

            if (!RubberFlag) {
                for (int i = 0; i < NumOfCharacters; i++) {
                    for (int j = 0; j < NumOfPlants; j++)
                        Keg = Keg.Plus(Characters[i].GetRubber(Flowers[j]));

                    if (Math.random() > 0.9 && Characters[i].age == Age.ADULT) {
                        Keg = Keg.Plus(Characters[i].GetRubber(new Get_Rubber() {
                            @Override
                            public Rubber Get() {
                                return new Rubber(Math.random() * 5, 0.5);
                            }
                        }));
                    }
                }
                if (Keg.V > 50) {
                    RubberFlag = true;
                    INFO.SetRubberFlag(true);
                    for (int i = 0; i < NumOfCharacters; i++) {
                        Leader.Command(Characters[i], Activity.NOTHING);
                    }
                }
            }

            Keg.Freeze();

            if (!BalloonFlag && RubberFlag && Keg.k >= 0.5) {
                Keg = balloon.Create(Keg);
                BalloonFlag = true;
                INFO.SetBalloonFlag(true);
                for (int i = 0; i < NumOfCharacters; i++) {
                    Leader.Command(Characters[i], Activity.FLY);
                }
                Leader.activity = Activity.FLY;
            }

            if (BalloonFlag) {
                INFO.SetExtraInfo(balloon.Fly());

                try {
                    balloon.Inflate();
                } catch (SpeedException e) {
                    INFO.SetExtraInfo(e.getMessage() + ": " + e.getSpeed());
                    balloon.Param.SetSpeed(0);
                }
            }

            t++;
            INFO.OutPut();
        }
        if (!BalloonFlag)
            throw new BalloonException();
    }

    class info {
        private boolean RubberFlag, BalloonFlag;
        private String ExtraInfo;

        info () {
            RubberFlag = false;
            BalloonFlag = false;
            ExtraInfo = "";
        }

        void SetRubberFlag( boolean f ) {
            RubberFlag = f;
        }

        void SetBalloonFlag( boolean f ) {
            BalloonFlag = f;
        }

        void SetExtraInfo( String s ) {
            ExtraInfo = s;
        }

        void OutPut() {
            // Shorties information
            System.out.println("Leader of Shorties -> " + Life.this.Leader.toString());
            for (int i = 0; i < Life.this.NumOfCharacters; i++)
                System.out.println(Life.this.Characters[i].toString());

            // Plants information
            System.out.println("Plants:");
            for (int i = 0; i < Life.this.NumOfPlants; i++)
                System.out.println(Life.this.Flowers[i].toString());

            System.out.println("Keg: V = " + Life.this.Keg.V + ", k = " + Life.this.Keg.k);

            if (RubberFlag)
                System.out.println("Собрано достаточно резины!!!");
            else
                System.out.println("Резины не достаточно :(");

            if (BalloonFlag)
                System.out.println("Создан воздушный шар");
            System.out.println(ExtraInfo + "\n");
        }
    }
}
