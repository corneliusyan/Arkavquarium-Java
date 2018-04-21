class Guppy extends Ikan {
    /*! \brief Guppy levels.*/
    private int tahapPertumbuhan;

    /*! \brief Number of needed-food to evolve Guppy Level.*/
    private int jumlahMakananUntukPertumbuhan;

    /*! \brief Default Guppy Constructor.*/
    public Guppy() {
        super();
    }

    /*! \brief Guppy Constructor.*/
    public Guppy(float x, float y, Akuarium A) {
        super(x, y, A, TIPE_IKAN_GUPPY);
        tahapPertumbuhan = 1;
        jumlahMakananUntukPertumbuhan = 2;
    }

    // Getter attribute
    /*! \brief Return Guppy Level.*/
    public int getTahapPertumbuhan() {
        return tahapPertumbuhan;
    }

    /*! \brief Return Number of needed-food to evolve Guppy level.*/
    public int getJumlahMakananUntukPertumbuhan() {
        return jumlahMakananUntukPertumbuhan;
    }

    // Setter attribute
    /*! \brief Set Guppy Level.*/
    public void setTahapPertumbuhan(int val) {
        tahapPertumbuhan = val;
    }

    /*! \brief Set Guppy's needed-food to evolve.*/
    public void setJumlahMakananUntukPertumbuhan(int val) {
        jumlahMakananUntukPertumbuhan = val;
    }

    // Method untuk makan Guppy
    /*! \brief Method for Guppy to eat food.
     *
     * Guppy will eat nearest food from Guppy position.
     */
    @Override
    public void Makan() {
        float terdekat = 99999;
        int idxMin = 0;
        for (int i = 0; i < A.getMakananIkanList().getSize(); i++) {
            if (jarak(this, (A.getMakananIkanList().get(i))) <= terdekat) {
                terdekat = jarak(this, (A.getMakananIkanList().get(i)));
                idxMin = i;
                if (terdekat <= radiusMakan)
                    break;
            }
        }
        MakananIkan temp = A.getMakananIkanList().get(idxMin);
        A.getMakananIkanList().remove(A.getMakananIkanList().get(idxMin));
        this.waktuBebas = 200;
        this.waktuCariMakan = 200;
        this.makanSekarang = false;
        if (this.tahapPertumbuhan == 1) {
            this.jumlahMakananUntukPertumbuhan--;
            if (this.jumlahMakananUntukPertumbuhan == 0) {
                this.jumlahMakananUntukPertumbuhan = 3;
                this.tahapPertumbuhan++;
            }
        } else if (this.tahapPertumbuhan == 2) {
            this.jumlahMakananUntukPertumbuhan--;
            if (this.jumlahMakananUntukPertumbuhan == 0) {
                this.jumlahMakananUntukPertumbuhan = 9999;
                this.tahapPertumbuhan++;
            }
        }
        moveDuration = 20;
    }

    // Method untuk memproses satu waktu
    /*! \brief Run Guppy to-do list on Game Time units.
     *
     * Guppy will called Gerak.
     * If Guppy is hungry, then Guppy will called Makan.
     * If Guppy is starving, Guppy die.
     * Guppy will drop Coin on the assigned time.
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
        waktuCounter--;
        if (waktuCounter == 0) {
            dropKoin();
            waktuCounter = 100;
        }
    }

    /*! \brief Method to create new coin.
     *
     * Guppy create new Coin object.
     * Coin is added on Aquarium KoinList.
     */
    @Override
    public void dropKoin() {
        Koin k = new Koin(x, y, A, 20 * tahapPertumbuhan);
        A.getKoinList().add(k);
    }
}