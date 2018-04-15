import java.util.Random;
import java.lang.Math;

public class Akuarium{
	/*! \brief Akuarium width size.*/
	private double maxX;

	/*! \brief Akuarium height size.*/
	private double maxY;

	/*! \brief Akuarium game time.*/
	private int gameTime;

	/*! \brief Player's Coin.*/
	private int koin;

	/*! \brief Akuarium default number of Guppy.*/
	private int initialNumberOfGuppy;

	/*! \brief Player's number of egg.*/
	private int telur;

	/*! \brief Akuarium snails object.*/
	private Siput siput;

	/*! \brief Akuarium List of Coin.*/
	private LinkedList<Koin> KoinList;

	/*! \brief Akuarium List of Fish Food.*/
	private LinkedList<MakananIkan> MakananIkanList;

	/*! \brief Akuarium List of Fish.*/
	private LinkedList<Ikan> IkanList;


	/*! \brief Akuarium Default Constructor.*/
	public Akuarium(){
		maxX = 30;
		maxY = 15;
		initialNumberOfGuppy = 2;
		koin = 10000;
		telur = 0;
		siput = new Siput(maxX/2, maxY, this);
		Random rand = new Random();
		for (int i = 0; i < initialNumberOfGuppy; i++) {
			double rand_x = rand.nextInt((int)maxX)*1.0;
			double rand_y = rand.nextInt((int)maxY)*1.0;
			Ikan gup = new Guppy(rand_x, rand_y, this);
			IkanList.add(gup);
		}
	}

	/*! \brief Return Akuarium width size.*/
	public double getMaxX() {
		return maxX;
	}

	/*! \brief Return Akuarium height size.*/
	public double getMaxY() {
		return maxY;
	}

	/*! \brief Return player's coin.*/
	public int getGameTime() {
		return gameTime;
	}

	/*! \brief Return game time.*/
	public int getInitialNumberOfGuppy() {
		return initialNumberOfGuppy;
	}

	/*! \brief Return default number of guppy.*/
	public int getKoin() {
		return koin;
	}

	/*! \brief Return number of egg.*/
	public int getTelur() {
		return telur;
	}

	/*! \brief Return Snail Object.*/
	public Siput getSiput(){
		return siput;
	}

	/*! \brief Return List of Coin in Akuarium.*/
	public LinkedList<Koin> getKoinList() {
		return KoinList;
	}
	/*! \brief Return List of Fish Food in Akuarium.*/
	public LinkedList<MakananIkan> getMakananIkanList() {
		return MakananIkanList;
	}
	/*! \brief Return List of Fish in Akuarium.*/
	public LinkedList<Ikan> getIkanList() {
		return IkanList;
	}

	/*! \brief Set Akuarium width size.*/
	public void setMaxX(double x){
		maxX = x;
	}

	/*! \brief Set Akuarium height size.*/
	public void setMaxY(double y){
		maxY = y;
	}

	/*! \brief Set current Game Time.*/
	public void setGameTime(int g){
		gameTime = g;
	}

	/*! \brief Set default number of guppy.*/
	public void setInitialNumberOfGuppy(int i){
		initialNumberOfGuppy = i;
	}

	/*! \brief Set Player's Coin.*/
	public void setKoin(int k){
		koin = k;
	}

	/*! \brief Set Player's number of egg.*/
	public void setTelur(int t){
		telur = t;
	}

	/*! \brief Run the game process on unit of time.*/
	public void ProsesWaktu() {
		gameTime++;
		int i = 0;
		while (i < KoinList.getSize()) {
			KoinList.get(i).ProsesWaktu();
			i++;
		}
		i=0;
		while (i < MakananIkanList.getSize()) {
			MakananIkanList.get(i).ProsesWaktu();
			if(MakananIkanList.get(i).getY() >= maxY){
				MakananIkanList.remove(MakananIkanList.get(i));
			}
			else {
				i++;
			}
		}
		Node<Ikan> cur = IkanList.getHead();
		while (cur != null) {
			Ikan cur_ikan = cur.getData();
			cur_ikan.ProsesWaktu();
			if (cur_ikan.getWaktuCariMakan() <= 0) {
				cur = cur.getNext();
				IkanList.remove(cur_ikan);
			}
			else {
				cur = cur.getNext();
			}
		}
		siput.ProsesWaktu();
	}

	/*! \brief Method for get a coin by On-Screen click.
	 *
	 * Return true if player click on a coin.
	 * Return false if playeer didn't click a coin.
	 */
	public boolean AmbilKoin(double x, double y) {
		int i=0;
		while (i < KoinList.getSize()) {
			if (Math.sqrt(Math.pow(x - KoinList.get(i).getX(), 2) + Math.pow(y - KoinList.get(i).getY(), 2)) <= 1) {
				koin = (koin + KoinList.get(i).getNilai());
				KoinList.remove(KoinList.get(i));
				return true;
			}
			else {
				i++;
			}
		}
		return false;
	}

	/*! \brief Method for buy Guppy on player's Akuarium.
	 *
	 * Return true if player has enough coin for buy a Guppy.
	 *  Return false if player doesn't have enough coin for buy a Guppy.
	 */
	public boolean BeliGuppy(){
		if (koin >= 50){
			koin -= 50;
			Random rand = new Random();
			double rand_x = (rand.nextInt((int)maxX))*1.0;
			double rand_y = (rand.nextInt((int)maxY))*1.0;
			Ikan gup = new Guppy(rand_x, rand_y, this);
			IkanList.add(gup);
			return true;
		}
		return false;
	}

	/*! \brief Method for buy Piranha on player's Akuarium.
	 *
	 * Return true if player has enough coin for buy a Piranha
	 * Return false if player doesn't have enough coin for buy a Piranha
	 */
	public boolean BeliPiranha(){
		if (koin >= 100){
			koin -= 100;
			Random rand = new Random();
			Piranha pir = new Piranha(rand.nextInt((int)maxX)*1.0, rand.nextInt((int)maxY)*1.0, this);
			IkanList.add(pir);
			return true;
		}
		return false;
	}

	/*! \brief Method for buy Egg on player's Akuarium.
	 *
	 * Return true if player has enough coin for buy a Egg.
	 * Return false if player doesn't have enough coin for buy a Egg.
	 */
	public boolean BeliTelur(){
		if (koin >= 100){
			koin -= 100;
			telur++;
			return true;
		}
		return false;
	}

	/*! \brief Method for buy fish food on player's Akuarium by On-Screen Click.
	 *
	 * Return true if player has enough coin for buy a fish food.
	 * Return false if player doesn't have enough coin for buy a fish food.
	 */
	public boolean BeliMakanan(double x, double y){
		if (koin >= 5){
			koin -=5;
			MakananIkan makanBang = new MakananIkan(x, y, this);
			MakananIkanList.add(makanBang);
			return true;
		}
		return false;
	}
}