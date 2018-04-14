import java.lang.Math;

public class Ikan extends AkuariumItem implements MovingItem {
    public static final String TIPE_IKAN_GUPPY = "Guppy";
    public static final String TIPE_IKAN_PIRANHA = "Piranha";
    /*! \brief Fish status whether hungry or not*/
    protected boolean isKenyang;

    /*! \brief Fish direction to the right or not */
    protected boolean hadapKanan;

    /*! \brief Minimum food radius to be eaten */
    protected float radiusMakan;

    /*! \brief Time value for Fish to move randomly */
    protected int waktuBebas;

    /*! \brief Time value for Fish to find food */
    protected int waktuCariMakan;

    /*! \brief Time value for Fish to drop coin */
    protected int waktuCounter;

    /*! \brief Fish type */
    protected String tipe;

    /*! \brief Fish status whether hungry or not for each fps*/
    protected boolean makanSekarang;

    /*! \brief Time value for Fish to move randomly in 1 direction for 1 fps*/
    protected int moveDuration;

    /*! \brief the amount of location changes in 1 fps*/
    protected float xt, yt;

    /*! \brief Default Constructor without parameter */
    public Ikan() {
    }

    /*! \brief Fish Constructor with 3 parameters*/
    public Ikan(float x, float y, Akuarium A, String tipe) {
        super(x,y,A);
        this.tipe = tipe;
        radiusMakan = 1;
        waktuBebas = 100;
        waktuCariMakan = 300;
        waktuCounter = 100;
        makanSekarang = false;
        moveDuration = 0;
        xt = 0;
        yt = 0;
    }

    /*! \brief return Fish status of hunger*/
    public boolean getIsKenyang() {
        return isKenyang;
    }

    /*! \brief return Fish direction*/
    public boolean getHadapKanan() {
        return hadapKanan;
    }

    /*! \brief return Minimum radius of food to be eaten*/
    public float getRadiusMakan() {
        return radiusMakan;
    }

    /*! \brief return time value for Fish to move randomly*/
    public int getWaktuBebas() {
        return waktuBebas;
    }

    /*! \brief return time value for Fish to find food*/
    public int getWaktuCariMakan() {
        return waktuCariMakan;
    }

    /*! \brief return time value for Fish to drop Coin*/
    public int getWaktuCounter() {
        return waktuCounter;
    }

    /*! \brief return Fish type*/
    public String getTipe() {
        return tipe;
    }

    /*! \brief set Fish status of hunger*/
    public void setIsKenyang(boolean val) {
        isKenyang = val;
    }

    /*! \brief set Fish Directiom*/
    public void setHadapKanan(boolean val) {
        hadapKanan = val;
    }

    /*! \brief set Minimum radius of food to be eaten */
    public void setRadiusMakan(float val) {
        radiusMakan = val;
    }

    /*! \brief set time value for Fish to move randomly*/
    public void setWaktuBebas(int val) {
        waktuBebas = val;
    }

    /*! \brief set time value for Fish to find food*/
    public void setWaktuCariMakan(int val) {
        waktuCariMakan = val;
    }

    /*! \brief set time value for Fish to drop Coin*/
    public void setWaktuCounter(int val) {
        waktuCounter = val;
    }

    /*! \brief set Fish type*/
    public void setTipe(String val) {
        tipe = val;
    }

    /*! \brief Implement fish movement in Game
     *
     * If Fish waktuBebas > 0, Fish will move randomly
     * else (Fish is hungry)
     * If Fish type is Guppy, then Fish will find nearest food
     * If there is no food, Guppy will move randomly
     * If Fish type is Piranha, then Fish will find nearest guppy
     * If there is no guppy, Piranha will move randomly
     */

    public void Gerak() {
        float x2, y2, alfa, deg;
        if (waktuBebas > 0) {
            boolean isValid = ((x + xt <= (A.getMaxX())) && (x + xt >= 0) && (y + yt <= (A.getMaxY()))
                    && (y + yt >= 0));
            if (moveDuration == 0 || !isValid) {
                do {
                    deg = (float) Math.random() * 360;
                    alfa = (float) (deg * Math.PI / 180);
                    x2 = (float) (0.1 * Math.cos(alfa));
                    y2 = (float) (0.1 * Math.sin(alfa));
                } while (!((x + x2 <= (A.getMaxX())) && (x + x2 >= 0) && (y + y2 <= (A.getMaxY())) && (y + y2 >= 0)));
                moveDuration = 20;
            } else {
                x2 = xt;
                y2 = yt;
                moveDuration--;
            }
        } else {
            if (tipe == TIPE_IKAN_GUPPY) {
                float terdekat = 99999;
                int idxMin = -1;
                if (A.getMakananIkanList().getSize() != 0) {
                    for (int i = 0; i < A.getMakananIkanList().getSize(); i++) {
                        if (AkuariumItem.jarak(this, (A.getMakananIkanList().get(i))) <= terdekat) {
                            terdekat = AkuariumItem.jarak(this, (A.getMakananIkanList().get(i)));
                            idxMin = i;
                            if (terdekat <= radiusMakan)
                                break;
                        }
                    }
                    float xx, yy;
                    xx = (float) (A.getMakananIkanList().get(idxMin).getX() - this.x);
                    yy = (float) (A.getMakananIkanList().get(idxMin).getY() - this.y);
                    alfa = (float) Math.atan2(yy, xx);
                    x2 = (float) (0.1 * Math.cos(alfa));
                    y2 = (float) (0.1 * Math.sin(alfa));
                    if (terdekat <= radiusMakan) {
                        makanSekarang = true;
                    }
                } else {
                    boolean isValid = ((x + xt <= (A.getMaxX())) && (x + xt >= 0) && (y + yt <= (A.getMaxY()))
                            && (y + yt >= 0));
                    if (moveDuration == 0 || !isValid) {
                        do {
                            deg = (float) Math.random() * 360;
                            alfa = (float) (deg * Math.PI / 180);
                            x2 = (float) (0.1 * Math.cos(alfa));
                            y2 = (float) (0.1 * Math.sin(alfa));
                        } while (!((x + x2 <= (A.getMaxX())) && (x + x2 >= 0) && (y + y2 <= (A.getMaxY()))
                                && (y + y2 >= 0)));
                        moveDuration = 20;
                    } else {
                        x2 = xt;
                        y2 = yt;
                        moveDuration--;
                    }
                }
            } else {
                float terdekat = 99999;
                int idxMin = -1, i = 0;
                while (i < A.getIkanList().getSize()) {
                    if (AkuariumItem.jarak(this, (A.getIkanList().get(i))) <= terdekat
                            && A.getIkanList().get(i).getTipe() == TIPE_IKAN_GUPPY) {
                        terdekat = AkuariumItem.jarak(this, (A.getIkanList().get(i)));
                        idxMin = i;
                        if (terdekat <= radiusMakan)
                            break;
                    }
                    i++;
                }
                if (idxMin == -1) {
                    boolean isValid = ((x + xt <= (A.getMaxX())) && (x + xt >= 0) && (y + yt <= (A.getMaxY()))
                            && (y + yt >= 0));
                    if (moveDuration == 0 || !isValid) {
                        do {
                            deg = (float) Math.random() * 360;
                            alfa = (float) (deg * Math.PI / 180);
                            x2 = (float) (0.1 * Math.cos(alfa));
                            y2 = (float) (0.1 * Math.sin(alfa));
                        } while (!((x + x2 <= (A.getMaxX())) && (x + x2 >= 0) && (y + y2 <= (A.getMaxY()))
                                && (y + y2 >= 0)));
                        moveDuration = 20;
                    } else {
                        x2 = xt;
                        y2 = yt;
                        moveDuration--;
                    }
                } else {
                    float xx, yy;
                    xx = (float) (A.getIkanList().get(idxMin).getX() - this.x);
                    yy = (float) (A.getIkanList().get(idxMin).getY() - this.y);
                    alfa = (float) Math.atan2(yy, xx);
                    x2 = (float) (0.1 * Math.cos(alfa));
                    y2 = (float) (0.1 * Math.sin(alfa));
                    if (terdekat <= radiusMakan) {
                        makanSekarang = true;
                    }
                }
            }
        }
        xt = x2;
        yt = y2;
        x += xt;
        y += yt;
        if (xt < 0)
            hadapKanan = false;
        else if (xt > 0)
            hadapKanan = true;
    }

    /*! \brief Run Fish to-do list on Game Time units.
     *
     * Fish will called Gerak.
     * If Fish is hungry, then Fish will called Makan.
     * If Fish is starving, Fish die.
     */
    public void ProsesWaktu() {

    }
    /*! \brief Implements Fish eating their Food base on Fish type
     *
     * method Makan will be implemented in Fish's child classes
     * such as Guppy and Piranha 
     */

    public void Makan() {
    }

    /*! \brief Implemets Fish producing Coin
     *
     * method dropKoin will be implemented in Fish's child classes
     * such as Guppy and Piranha 
     */
    public void dropKoin() {
    }
}