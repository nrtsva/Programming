public class Main {

    public static void main(String[] args) {
        SmartShorties Znayka = new SmartShorties("Znayka");
        AdultShorties Neznayka = new AdultShorties("Neznayka"),
                      Gunka = new AdultShorties("Gunka");
        BabyShorties Kids = new BabyShorties("Baby");
        neFicus Flowers[] = new neFicus[5];

        for (int i = 0; i < 5; i++) {
            Flowers[i] = new neFicus();
        }

        Life L = new Life();

        L.AddLeader(Znayka);
        L.AddCharacters(Neznayka);
        L.AddCharacters(Gunka);
        L.AddCharacters(Kids);
        for (int i = 0; i < 5; i++) {
            L.AddPlant(Flowers[i]);
        }

        L.Go();
    }
}
