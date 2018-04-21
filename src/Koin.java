public class Koin extends AkuariumItem implements MovingItem {
	// Koin's value
	protected int nilai;

	/*! \brief Default Koin Constructor.*/
	public Koin() {
	}

	/*! \brief Koin Constructor with parameter.
	*
	* The parameter is x-coordinate, y-coordinate, Pointer to Akuarium, and Koin value.
	*/
	public Koin(float x, float y, Akuarium A, int n) {
		super(x, y, A);
		this.nilai = n;
	}

	/*! \brief Return Koin value.*/
	public int getNilai() {
		return this.nilai;
	}

	/*! \brief Set Koin Value.*/
	public void setNilai(int n) {
		this.nilai = n;
	}

	/*! \brief Method for change Koin position.
	 *
	 * Koin will move to the bottom of Akuarium.
	 */
	public void Gerak() {
		y += 0.1;
		if (y > A.getMaxY())
			y = A.getMaxY();
	}

	/*! \brief Method for processing Koin on a Game Time units.
	 *
	 * This method will call Gerak().
	 */
	public void ProsesWaktu() {
		Gerak();
	}

}