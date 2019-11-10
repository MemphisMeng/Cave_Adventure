/**
 * This class describes the abstract but general procedure throughout the game.
 * This the main entrance of the adventure.
 * @author Anzhe Meng
 * BU ID U50590533
 *
 */
public class Cave_Adventure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * When the player fails the challenge or he/she wouldn't play any more, the exit will be true. Otherwise, false.
		 */
		boolean exit = false;
		Journey journey = new Journey();
		if (!exit) {
			journey.entrance(exit);
			journey.venture(exit);
		}
	}

}
