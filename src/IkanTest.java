import org.junit.Test;

import static org.junit.Assert.*;

public class IkanTest {

    @Test
    public void getIsKenyang() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        assertTrue(ikan.getIsKenyang());
    }

    @Test
    public void getHadapKanan() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        assertFalse(ikan.getHadapKanan());
    }

    @Test
    public void getRadiusMakan() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        assertEquals(1, ikan.getRadiusMakan(), 0.000001);
    }

    @Test
    public void getWaktuBebas() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        assertEquals(100, ikan.getWaktuBebas());
    }

    @Test
    public void getWaktuCariMakan() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        assertEquals(300, ikan.getWaktuCariMakan());
    }

    @Test
    public void getWaktuCounter() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        assertEquals(100, ikan.getWaktuCounter());
    }

    @Test
    public void getTipe() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        assertEquals("Piranha", ikan.getTipe());
    }

    @Test
    public void setIsKenyang() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        ikan.setIsKenyang(false);
        assertFalse(ikan.getIsKenyang());
    }

    @Test
    public void setHadapKanan() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        ikan.setHadapKanan(true);
        assertTrue(ikan.getHadapKanan());
    }

    @Test
    public void setRadiusMakan() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        ikan.setRadiusMakan(2);
        assertEquals(2, ikan.getRadiusMakan(), 0.000001);
    }

    @Test
    public void setWaktuBebas() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        ikan.setWaktuBebas(999);
        assertEquals(999, ikan.getWaktuBebas());
    }

    @Test
    public void setWaktuCariMakan() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        ikan.setWaktuCariMakan(999);
        assertEquals(999, ikan.getWaktuCariMakan());
    }

    @Test
    public void setWaktuCounter() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        ikan.setWaktuCounter(999);
        assertEquals(999, ikan.getWaktuCounter());
    }

    @Test
    public void setTipe() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");
        ikan.setTipe("paus");
        assertEquals("paus", ikan.getTipe());
    }

    @Test
    public void gerakBebas() {
        Akuarium akuarium = new Akuarium();
        Ikan ikan = new Ikan(0, 0, akuarium, "Piranha");

        float beforeX = ikan.getX();
        float beforeY = ikan.getY();

        ikan.Gerak();

        float afterX = ikan.getX();
        float afterY = ikan.getY();

        double distance = Math.sqrt(Math.pow(afterX - beforeX, 2) + Math.pow(afterY - beforeY, 2));

        assertEquals(0.1, distance, 0.000001);
    }

    @Test
    public void gerakPiranhaMakan() {
        Akuarium akuarium = new Akuarium();
        Ikan piranha = new Ikan(0, 0, akuarium, "Piranha");

        Ikan guppy = new Guppy(2, 2, akuarium);
        akuarium.getIkanList().add(guppy);

        float beforeX = piranha.getX();
        float beforeY = piranha.getY();

        double distanceBefore = Math.sqrt(Math.pow(2 - beforeX, 2) + Math.pow(2 - beforeY, 2));

        piranha.setWaktuBebas(0);
        piranha.Gerak();

        float afterX = piranha.getX();
        float afterY = piranha.getY();

        double distanceAfter = Math.sqrt(Math.pow(2 - afterX, 2) + Math.pow(2 - afterY, 2));

        assertEquals(0.1, (distanceBefore - distanceAfter), 0.000001);
    }

    @Test
    public void gerakGuppyMakan() {
        Akuarium akuarium = new Akuarium();
        Ikan guppy = new Ikan(0, 0, akuarium, "Guppy");

        MakananIkan makananIkan = new MakananIkan(2, 2, akuarium);
        akuarium.getMakananIkanList().add(makananIkan);

        float beforeX = guppy.getX();
        float beforeY = guppy.getY();

        double distanceBefore = Math.sqrt(Math.pow(2 - beforeX, 2) + Math.pow(2 - beforeY, 2));

        guppy.setWaktuBebas(0);
        guppy.Gerak();

        float afterX = guppy.getX();
        float afterY = guppy.getY();

        double distanceAfter = Math.sqrt(Math.pow(2 - afterX, 2) + Math.pow(2 - afterY, 2));

        assertEquals(0.1, (distanceBefore - distanceAfter), 0.000001);
    }
}