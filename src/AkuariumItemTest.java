import org.junit.Test;

import static org.junit.Assert.*;

public class AkuariumItemTest {

    class Dummy extends AkuariumItem {
        public Dummy(float x, float y) {
            super(x, y, new Akuarium());
        }

        public void ProsesWaktu() {}
    }

    @Test
    public void getX() {
        Dummy dum = new Dummy(0, 0);
        assertEquals(0, dum.getX(), 0.000001);
    }

    @Test
    public void getY() {
        Dummy dum = new Dummy(0, 0);
        assertEquals(0, dum.getY(), 0.000001);
    }

    @Test
    public void setX() {
        Dummy dum = new Dummy(0, 0);
        dum.setX(20);
        assertEquals(20, dum.getX(), 0.000001);
    }

    @Test
    public void setY() {
        Dummy dum = new Dummy(0, 0);
        dum.setY(20);
        assertEquals(20, dum.getY(), 0.000001);
    }


    @Test
    public void jarak() {
        Dummy dumA = new Dummy(0, 0);
        Dummy dumB = new Dummy(1, 1);
        float expectedJarak = (float) Math.sqrt(Math.pow(0 - 1, 2) + Math.pow(0 - 1, 2));
        assertEquals(expectedJarak, AkuariumItem.jarak(dumA, dumB), 0.000001);
    }
}