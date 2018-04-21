import org.junit.Test;

import static org.junit.Assert.*;

public class SiputTest {

    @Test
    public void getHadapKanan() {
        Akuarium akuarium = new Akuarium();
        Siput siput = new Siput(0, 0, akuarium);
        assertTrue(siput.getHadapKanan());
    }

    @Test
    public void setHadapKanan() {
        Akuarium akuarium = new Akuarium();
        Siput siput = new Siput(0, 0, akuarium);
        siput.setHadapKanan(false);
        assertFalse(siput.getHadapKanan());
    }

    @Test
    public void gerakKeKoin() {
        Akuarium akuarium = new Akuarium();
        Koin koin = new Koin(10, 0, akuarium, 20);
        akuarium.getKoinList().add(koin);
        Siput siput = new Siput(0, 0, akuarium);

        // Posisi sebelumnya
        float beforeX = siput.getX();
        float beforeY = siput.getY();

        siput.Gerak();

        // Posisi setelah
        float afterX = siput.getX();
        float afterY = siput.getY();

        // Harusnya siput gerak kekanan sebesar 0.1 pada sumbu x, dan 0 pada sumbu y
        assertEquals(beforeX + 0.1, afterX, 0.000001);
        assertEquals(beforeY, afterY, 0.000001);
    }

    @Test
    public void gerakBebas() {
        Akuarium akuarium = new Akuarium();
        Siput siput = new Siput(0, 0, akuarium);

        // Posisi sebelumnya
        float beforeX = siput.getX();
        float beforeY = siput.getY();

        siput.Gerak();

        // Posisi setelah
        float afterX = siput.getX();
        float afterY = siput.getY();

        // Harusnya siput tidak bergerak
        assertEquals(beforeX, afterX, 0.000001);
        assertEquals(beforeY, afterY, 0.000001);
    }

    @Test
    public void ambilKoin() {
        Akuarium akuarium = new Akuarium();
        Koin koin = new Koin(0, 0, akuarium, 20);
        akuarium.getKoinList().add(koin);
        Siput siput = new Siput(0, 0, akuarium);

        int koinBefore = akuarium.getKoin();
        int koinListSizeBefore = akuarium.getKoinList().getSize();

        siput.AmbilKoin();

        int koinAfter = akuarium.getKoin();
        int koinListSizeAfter = akuarium.getKoinList().getSize();

        assertEquals(koinBefore + 20, koinAfter);
        assertEquals(koinListSizeBefore - 1, koinListSizeAfter);
    }

    @Test
    public void prosesWaktu() {
        Akuarium akuarium = new Akuarium();
        Siput siput = new Siput(0, 0, akuarium);
        siput.ProsesWaktu();
    }
}