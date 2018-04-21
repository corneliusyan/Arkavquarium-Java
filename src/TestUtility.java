public class TestUtility {
    public final int expectedInitialNumberOfGuppy = 2;
    public final int expectedKoin = 100;
    public final int expectedNumberOfGuppy = 5;
    public final int expectedNumberOfPiranha = 3;
    public final int expectedMaxX = 30;
    public final int expectedMaxY = 15;
    public final int expectedNumberOfKoin = 3;
    public final int expectedTelur = 1;
    public final int expectedNumberOfMakananIkan = 3;

    public TestUtility() {

    }

    public Akuarium generatePopulatedAkuarium() {
        Akuarium akuarium = new Akuarium();

        // Set Max Coor
        akuarium.setMaxX(expectedMaxX);
        akuarium.setMaxY(expectedMaxY);

        // Initialize koin for buying purpose
        akuarium.setKoin(100000);

        // Initialize guppy
        for (int i = 0; i < (expectedNumberOfGuppy - expectedInitialNumberOfGuppy); i++) {
            akuarium.BeliGuppy();
        }

        // Initialize Piranha
        for (int i = 0; i < expectedNumberOfPiranha; i++) {
            akuarium.BeliPiranha();
        }

        // Initialize Telur
        for (int i = 0; i < expectedTelur; i++) {
            akuarium.BeliTelur();
        }

        // Initialize MakananIkan
        for (int i = 0; i < expectedNumberOfMakananIkan; i++) {
            akuarium.BeliMakanan(0, 0);
        }

        // Initialize dropped Koin
        for (int i = 0; i < expectedNumberOfKoin; i++) {
            Koin k = new Koin(0, 0, akuarium, 30);
            akuarium.getKoinList().add(k);
        }

        // Initialize Koin
        akuarium.setKoin(expectedKoin);

        return akuarium;
    }
}
