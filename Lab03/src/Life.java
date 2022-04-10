public class Life {
    SmartShorties Leader;
    Shorties Characters[] = new Shorties[5];
    neFicus Flowers[] = new neFicus[5];

    int NumOfCharacters, NumOfPlants;

    Rubber Keg;
    Balloon balloon;

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
        boolean LittleRubber = true,
                BalloonCreate = false;
        boolean flag = true;

        info(LittleRubber, BalloonCreate);
        Leader.activity = Activity.COMMAND;
        for (int i = 0; i < NumOfCharacters; i++) {
            Leader.Command(Characters[i], Activity.COLLECT_JUICE);
        }

        int t = 0;
        while (flag) {
            for (int j = 0; j < NumOfPlants; j++)
                Flowers[j].Grow();

            if (LittleRubber) {
                for (int i = 0; i < NumOfCharacters; i++) {
                    for (int j = 0; j < NumOfPlants; j++)
                        Keg = Keg.Plus(Characters[i].GetRubber(Flowers[j]));
                }
                if (Keg.V > 50) {
                    LittleRubber = false;
                    for (int i = 0; i < NumOfCharacters; i++) {
                        Leader.Command(Characters[i], Activity.NOTHING);
                    }
                }
            }

            Keg.Freeze();

            if (!BalloonCreate && !LittleRubber && Keg.k >= 0.5) {
                Keg = balloon.Create(Keg);
                BalloonCreate = true;
                for (int i = 0; i < NumOfCharacters; i++) {
                    Leader.Command(Characters[i], Activity.FLY);
                }
                Leader.activity = Activity.FLY;
            }

            if (BalloonCreate) {
                balloon.Fly();
                balloon.Inflate();
                t++;
            }


            if (t > 5)
                flag = false;

            info(LittleRubber, BalloonCreate);
        }
    }

    void info( boolean flag1, boolean flag2 ) {
        System.out.println("Leader of Shorties -> " + Leader.toString());
        for (int i = 0; i < NumOfCharacters; i++)
            System.out.println(Characters[i].toString());
        System.out.println("Plants:");
        for (int i = 0; i < NumOfPlants; i++)
            System.out.println(Flowers[i].toString());
        System.out.println("Keg: V = " + Keg.V + ", k = " + Keg.k);

        if (flag1)
            System.out.println("Резины не достаточно :(");
        else
            System.out.println("Собрано достаточно резины!!!");

        if (flag2)
            System.out.println("Создан воздушный шар");
        System.out.println();
    }
}
