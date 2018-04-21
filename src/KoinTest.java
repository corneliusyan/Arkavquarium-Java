import org.junit.Test;

import static org.junit.Assert.*;

public class KoinTest {

    @Test
    public void getNilai() {
        Akuarium akuarium = new Akuarium();
        Koin koin = new Koin(0, 0, akuarium, 20);
        assertEquals(20, koin.getNilai());
    }

    @Test
    public void setNilai() {
        Akuarium akuarium = new Akuarium();
        Koin koin = new Koin(0, 0, akuarium, 10);
        koin.setNilai(20);
        assertEquals(20, koin.getNilai());
    }

    @Test
    public void gerak() {
        Akuarium akuarium = new Akuarium();
        Koin koin = new Koin(0, 0, akuarium, 20);
        koin.Gerak();
        assertEquals(0, koin.getX(), 0.000001);
        assertEquals(0.1, koin.getY(), 0.000001);
    }

    @Test
    public void prosesWaktu() {
        Akuarium akuarium = new Akuarium();
        Koin koin = new Koin(0, 0, akuarium, 20);
        koin.ProsesWaktu();
    }
}