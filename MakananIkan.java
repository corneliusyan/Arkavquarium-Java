public class MakananIkan extends AkuariumItem implements MovingItem {
	/*! \brief Default MakananIkan Constructor.*/
	public MakananIkan() {
		super();
	}

	/*! \brief MakananIkan Constructor with parameters.
	 *
	 * The parameter is x-coordinate, y-coordinate, and pointer to Akuarium respectively.
	 */
	public MakananIkan(float x, float y, Akuarium A) {
		super(x, y, A);
	}

	/*! \brief Method for moving the MakananIkan.
	 *
	 * MakananIkan will move to the bottom of Aquarium.
	 */
	public void Gerak() {
		this.y += 0.05;
	}

	/*! \brief Method for processing MakananIkan in a Game Time units
	 *
	 * Method will call Gerak().
	 */
	public void ProsesWaktu() {
		Gerak();
	}
}