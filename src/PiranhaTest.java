import org.junit.Test;

import static org.junit.Assert.*;

public class PiranhaTest {

    @Test
    public void makan() {
        // Pada awal secara default ada 2 ikan
        Akuarium akuarium = new Akuarium();

        // ditambah 1 piranha
        Ikan piranha = new Piranha(0, 0, akuarium);
        akuarium.getIkanList().add(piranha);

        // ditambah 1 guppy
        Ikan guppy = new Guppy(0, 0, akuarium);
        akuarium.getIkanList().add(guppy);

        assertEquals(4, akuarium.getIkanList().getSize());

        piranha.Makan();

        assertEquals(3, akuarium.getIkanList().getSize());
        assertEquals(1, akuarium.getKoinList().getSize());
        assertEquals(200, piranha.getWaktuBebas());
        assertEquals(200, piranha.getWaktuCariMakan());
        assertFalse(piranha.makanSekarang);
    }

    @Test
    public void prosesWaktu() {
        Akuarium akuarium = new Akuarium();
        Ikan piranha = new Piranha(0, 0, akuarium);
        akuarium.getIkanList().add(piranha);

        int waktuBebasBefore = piranha.getWaktuBebas();
        int waktuCariMakanBefore = piranha.getWaktuCariMakan();

        piranha.ProsesWaktu();

        int waktuBebasAfter = piranha.getWaktuBebas();
        int waktuCariMakanAfter = piranha.getWaktuCariMakan();

        assertTrue(((waktuBebasBefore - 1) == waktuBebasAfter) || ((waktuCariMakanBefore - 1) == waktuCariMakanAfter));
    }

    @Test
    public void dropKoin() {
        Akuarium akuarium = new Akuarium();
        Ikan piranha = new Piranha(0, 0, akuarium);

        piranha.dropKoin();

        Koin droppedKoin = akuarium.getKoinList().get(akuarium.getKoinList().getSize() - 1);

        assertEquals(1, akuarium.getKoinList().getSize());
        assertEquals(50*(0 + 1), droppedKoin.getNilai());
    }
}