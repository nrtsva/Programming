public class Main {

    public static void main(String[] args) {
        SmartShorties Znayka = new SmartShorties("Znayka");
        AdultShorties Neznayka = new AdultShorties("Neznayka"),
                      Gunka = new AdultShorties("Gunka");
        BabyShorties Kids = new BabyShorties("Baby");

        Life L = new Life();

        L.AddLeader(Znayka);
        L.AddCharacters(Neznayka);
        L.AddCharacters(Gunka);
        L.AddCharacters(Kids);
        for (int i = 0; i < 5; i++) {
            L.AddPlant(new neFicus());
        }

        try {
            L.Go();
        } catch (BalloonException e) {
            System.out.println(e.getMessage());
        }
    }
}
