import org.junit.Test;

import static org.junit.Assert.*;

public class MakananIkanTest {

    @Test
    public void gerak() {
        Akuarium akuarium = new Akuarium();
        MakananIkan makananIkan = new MakananIkan(0, 0, akuarium);
        makananIkan.Gerak();
        assertEquals(0, makananIkan.getX(), 0.000001);
        assertEquals(0.05, makananIkan.getY(), 0.000001);
    }

    @Test
    public void prosesWaktu() {
        Akuarium akuarium = new Akuarium();
        MakananIkan makananIkan = new MakananIkan(0, 0, akuarium);
        makananIkan.ProsesWaktu();
        assertEquals(0, makananIkan.getX(), 0.000001);
        assertEquals(0.05, makananIkan.getY(), 0.000001);
    }
}