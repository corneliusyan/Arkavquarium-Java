import static org.junit.Assert.*;

public class AkuariumTest {

    @org.junit.Test
    public void getMaxX() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();
        assertEquals(testUtil.expectedMaxX, akuarium.getMaxX(), 0.00001);
    }

    @org.junit.Test
    public void getMaxY() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();
        assertEquals(testUtil.expectedMaxY, akuarium.getMaxY(), 0.00001);
    }

    @org.junit.Test
    public void getInitialNumberOfGuppy() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        assertEquals(testUtil.expectedInitialNumberOfGuppy, akuarium.getInitialNumberOfGuppy());
    }

    @org.junit.Test
    public void getKoin() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        assertEquals(testUtil.expectedKoin, akuarium.getKoin());
    }

    @org.junit.Test
    public void getTelur() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        assertEquals(testUtil.expectedTelur, akuarium.getTelur());
    }

    @org.junit.Test
    public void getSiput() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        assertNotNull(akuarium.getSiput());
    }

    @org.junit.Test
    public void getKoinList() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        LinkedList<Koin> koinList = akuarium.getKoinList();

        assertNotNull(koinList);

        assertEquals(testUtil.expectedNumberOfKoin, koinList.getSize());
    }

    @org.junit.Test
    public void getMakananIkanList() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        LinkedList<MakananIkan> makananIkanList = akuarium.getMakananIkanList();

        assertNotNull(makananIkanList);

        int makananIkanListSize = makananIkanList.getSize();

        assertEquals(3, makananIkanListSize);
    }

    @org.junit.Test
    public void getIkanList() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        LinkedList<Ikan> ikanList = akuarium.getIkanList();

        assertNotNull(ikanList);

        int ikanListSize = ikanList.getSize();

        assertEquals(8, ikanListSize);
    }

    @org.junit.Test
    public void setMaxX() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.setMaxX(1);

        assertEquals(1, akuarium.getMaxX(), 0.000001);
    }

    @org.junit.Test
    public void setMaxY() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.setMaxY(1);

        assertEquals(1, akuarium.getMaxY(), 0.000001);
    }

    @org.junit.Test
    public void setInitialNumberOfGuppy() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.setInitialNumberOfGuppy(10);

        assertEquals(10, akuarium.getInitialNumberOfGuppy());
    }

    @org.junit.Test
    public void setKoin() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.setKoin(9999);

        assertEquals(9999, akuarium.getKoin());
    }

    @org.junit.Test
    public void setTelur() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.setTelur(2);

        assertEquals(2, akuarium.getTelur());
    }

    @org.junit.Test
    public void prosesWaktu() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.ProsesWaktu();
    }

    @org.junit.Test
    public void ambilKoin() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.AmbilKoin(0, 0);

        assertEquals(testUtil.expectedKoin + 30, akuarium.getKoin());
        assertEquals(testUtil.expectedNumberOfKoin - 1, akuarium.getKoinList().getSize());
    }

    @org.junit.Test
    public void beliGuppy() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.BeliGuppy();

        LinkedList<Ikan> ikanList = akuarium.getIkanList();

        int expectedNumberOfFish = testUtil.expectedNumberOfGuppy + testUtil.expectedNumberOfPiranha + 1;
        assertEquals(expectedNumberOfFish, ikanList.getSize());

        Ikan ikanLast = ikanList.get(ikanList.getSize() - 1);

        assertEquals("Guppy", ikanLast.getTipe());
    }

    @org.junit.Test
    public void beliPiranha() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.BeliPiranha();

        LinkedList<Ikan> ikanList = akuarium.getIkanList();

        int expectedNumberOfFish = testUtil.expectedNumberOfGuppy + testUtil.expectedNumberOfPiranha + 1;
        assertEquals(expectedNumberOfFish, ikanList.getSize());

        Ikan ikanLast = ikanList.get(ikanList.getSize() - 1);

        assertEquals("Piranha", ikanLast.getTipe());
    }

    @org.junit.Test
    public void beliTelur() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.BeliTelur();

        assertEquals(testUtil.expectedTelur + 1, akuarium.getTelur());
    }

    @org.junit.Test
    public void beliMakanan() {
        TestUtility testUtil = new TestUtility();
        Akuarium akuarium = testUtil.generatePopulatedAkuarium();

        akuarium.BeliMakanan(0, 0);

        assertEquals(testUtil.expectedNumberOfMakananIkan + 1, akuarium.getMakananIkanList().getSize());
    }
}