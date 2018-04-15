class Piranha extends Ikan {
    /*! \brief Attribute for last Guppy's level that was consumed by Piranha.*/
    private int tahapIkanDimakan;

    /*! \brief Default Piranha Constructor*/
    public Piranha() {
        super();
    }

    /*! \brief Piranha Constructor with parameters.
     *
     * The parameters are x-coordinate, y-coordinate, and pointer to Akuarium respectively.
     */
    public Piranha(double x, double y, Akuarium A) {
        super(x, y, A, TIPE_IKAN_PIRANHA);
        waktuCounter = 0;
        tahapIkanDimakan = 0;
    }

    /*! \brief Eat method for Piranha.
     *
     * Piranha will look for the nearest Guppy.
     * After eat the Guppy, Piranha will drop Koin based-on consumed Guppy's level.
     */
    @Override
    public void Makan() {
        double terdekat = 99999;
        int idxMin = -1;
        int i = 0;
        while (i < A.getIkanList().getSize())
        {
            if (jarak(this, (A.getIkanList().get(i))) <= terdekat && A.getIkanList().get(i).getTipe() == TIPE_IKAN_GUPPY)
            {
                terdekat = jarak(this, (A.getIkanList().get(i)));
                idxMin = i;
                if (terdekat <= radiusMakan)
                    break;
            }
            i++;
        }
        if (idxMin != -1)
        {
            Guppy guppy = (Guppy)A.getIkanList().get(idxMin);
            tahapIkanDimakan = guppy.getTahapPertumbuhan();
            A.getIkanList().remove(A.getIkanList().get(idxMin));

            this.waktuBebas = 200;
            this.waktuCariMakan = 200;
            this.makanSekarang = false;

            dropKoin();
        }
        moveDuration=20;
    }

    /*! \brief Method for processing Piranha in a Game Time units.
     *
     * Piranha will moved randomly if it isn't hungry.
     * Piranha will moved to the nearest Guppy if it is hungry.
     * Method will called Gerak() Method.
     * If Piranha is hungry, Piranha will try to eat nearest Guppy.
     * If Piranha is starving, then it will died.
     */
    @Override
    public void ProsesWaktu() {
        if (waktuBebas > 0)
            waktuBebas--;
        else
            waktuCariMakan--;
        Gerak();
        if (makanSekarang)
            Makan();
    }

    /*! \brief Method for dropping Koin.
     *
     * Piranha will drop Koin that value is based-on Consumed Guppy's Level.
     */
    @Override
    public void dropKoin() {
        int hargaIkan=50;
        Koin k = new Koin(x,y,A,hargaIkan*(tahapIkanDimakan+1));
        A.getKoinList().add(k);
    }
}