import org.junit.Test;

import static org.junit.Assert.*;

public class GuppyTest {

    @Test
    public void getTahapPertumbuhan() {
        Akuarium akuarium = new Akuarium();
        Guppy guppy = new Guppy(0, 0, akuarium);

        assertEquals(1, guppy.getTahapPertumbuhan());
    }

    @Test
    public void getJumlahMakananUntukPertumbuhan() {
        Akuarium akuarium = new Akuarium();
        Guppy guppy = new Guppy(0, 0, akuarium);

        assertEquals(2, guppy.getJumlahMakananUntukPertumbuhan());
    }

    @Test
    public void setTahapPertumbuhan() {
        Akuarium akuarium = new Akuarium();
        Guppy guppy = new Guppy(0, 0, akuarium);

        guppy.setTahapPertumbuhan(20);

        assertEquals(20, guppy.getTahapPertumbuhan());
    }

    @Test
    public void setJumlahMakananUntukPertumbuhan() {
        Akuarium akuarium = new Akuarium();
        Guppy guppy = new Guppy(0, 0, akuarium);

        guppy.setJumlahMakananUntukPertumbuhan(100);

        assertEquals(100, guppy.getJumlahMakananUntukPertumbuhan());
    }

    @Test
    public void makan() {
        // Pada awal secara default ada 2 ikan
        Akuarium akuarium = new Akuarium();

        // Ikan ditambah 1 guppy
        Ikan guppy = new Guppy(0, 0, akuarium);
        akuarium.getIkanList().add(guppy);

        // Makanan ikan ditambah 1
        MakananIkan makananIkan = new MakananIkan(0, 0, akuarium);
        akuarium.getMakananIkanList().add(makananIkan);

        guppy.Makan();

        assertEquals(0, akuarium.getMakananIkanList().getSize());
    }

    @Test
    public void prosesWaktu() {
        Akuarium akuarium = new Akuarium();
        Ikan guppy = new Guppy(0, 0, akuarium);
        akuarium.getIkanList().add(guppy);

        int waktuBebasBefore = guppy.getWaktuBebas();
        int waktuCariMakanBefore = guppy.getWaktuCariMakan();

        guppy.ProsesWaktu();

        int waktuBebasAfter = guppy.getWaktuBebas();
        int waktuCariMakanAfter = guppy.getWaktuCariMakan();

        assertTrue(((waktuBebasBefore - 1) == waktuBebasAfter) || ((waktuCariMakanBefore - 1) == waktuCariMakanAfter));
    }

    @Test
    public void dropKoin() {
        Akuarium akuarium = new Akuarium();
        Guppy guppy = new Guppy(0, 0, akuarium);

        guppy.dropKoin();

        assertEquals(1, akuarium.getKoinList().getSize());
    }
}