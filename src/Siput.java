import java.lang.Math;

public class Siput extends AkuariumItem implements MovingItem {
	/*! \brief Attribute to change Siput direction.*/
	protected boolean hadapKanan;

	/*! \brief Default Siput Constructor*/
	public Siput() {
		this.hadapKanan = true;
	}

	/*! \brief Siput Constructor with parameters
	 *
	 * The parameters are x-coordinate, y-coordinate, and pointer to Akuarium respectively.
	 */
	public Siput(float x, float y, Akuarium A) {
		super(x, y, A);
		this.hadapKanan = true;
	}

	/*! \brief Return Siput directions.
	 *
	 * Return true if Siput faced to the right.
	 * Return false if Siput faced to the left.
	 */
	public boolean getHadapKanan() {
		return this.hadapKanan;
	}

	/*! \brief Set Siput Directions.*/
	public void setHadapKanan(boolean hadapKanan) {
		this.hadapKanan = hadapKanan;
	}

	/*! \brief Set Siput position on Akuarium.*/
//	public void setSiput(float x, float y, Akuarium A) {
//		this.x = x;
//		this.y = y;
//		this.A = A;
//	}

	/*! \brief Method for Siput to move.
	 *
	 * Siput won't move until there is a Koin in Akuarium.
	 * Siput will move to the nearest Koin based-on euclidean-distance Siput with Koin.
	 */
	public void Gerak() {
		float minX = 99999;
		float minY = -999999;
		float dist = (float) Math.sqrt(Math.pow(minX - x, 2) + Math.pow(minY - y, 2));
		int i = 0;
		// LinkedList<Koin*> K = A.getKoinList();
		while (i < A.getKoinList().getSize()) {
			float kdist = (float) jarak(this, (A.getKoinList().get(i)));
			if (kdist < dist) {
				minX = A.getKoinList().get(i).getX();
				;
				minY = A.getKoinList().get(i).getY();
				;
				dist = kdist;
				if (dist <= 1)
					break;
			}
			i++;
		}
		if (!A.getKoinList().isEmpty()) {
			// cout<<"MinX - x = "<<minX-x<<endl;
			if (minX - x < 0) {
				if (minX - x < -0.5) {
					x -= 0.1;
					hadapKanan = false;
				}
			} else {
				if (minX - x > 0.5) {
					x += 0.1;
					hadapKanan = true;
				}
			}
		}
	}

	/*! \brief Method for take Koin in Akuarium.
	 *
	 * Siput will take the available Koin on radius 1 units from its position.
	 * Player's number of Koin will be increased. 
	 */
	public void AmbilKoin() {
		int i = 0;
		while (i < A.getKoinList().getSize()) {
			if (jarak(this, (A.getKoinList().get(i))) <= 1) {
				A.setKoin(A.getKoin() + A.getKoinList().get(i).getNilai());
				Koin hoyo = new Koin();
				hoyo = A.getKoinList().get(i);
				A.getKoinList().remove(A.getKoinList().get(i));
			} else {
				i++;
			}
		}
	}

	/*! \brief MEthod for processing Siput on a Game Time units
	 *
	 * Method will call Siput Gerak() and AmbilKoin() Method.
	 */
	public void ProsesWaktu() {
		Gerak();
		AmbilKoin();
	}
}