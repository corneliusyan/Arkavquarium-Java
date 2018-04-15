import java.lang.Math;
public abstract class AkuariumItem {
    /*! \brief AkuariumItem x-coordinate.*/
    protected double x;
    /*! \brief AkuariumItem y-coordinate.*/
    protected double y;
    /*! \brief Aquarium Pointer.*/
    protected Akuarium A;

    /*! \brief Default AkuariumItem Constructor.*/
    public AkuariumItem() {
        x = 0;
        y = 0;
    }

    /*! \brief AkuariumItem Constructor.*/
    public AkuariumItem(double x, double y, Akuarium A) {
        this.x = x;
        this.y = y;
        this.A = A;
    }

    /*! \brief Set AkuariumItem x-coordinate.*/
    public void setX(double val) {
        x = val;
    }

    /*! \brief Set AkuariumItem y-coordinate.*/
    public void setY(double val) {
        y = val;
    }

    /*! \brief Return AkuariumItem x-coordinate.*/
    public double getX() {
        return x;
    }

    /*! \brief Return AkuariumItem y-coordinate.*/
    public double getY() {
        return y;
    }

    /*! \brief Run AkuariumItem on Game Time units.*/
    public abstract void ProsesWaktu();

    /*! \brief Return the Euclidean-distance of two AkuariumItem.*/
    public static double jarak(AkuariumItem a1, AkuariumItem a2) {
        return (double) Math.sqrt(Math.pow(a1.x - a2.x, 2) + Math.pow(a1.y - a2.y, 2));
    }

}