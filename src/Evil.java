/**
 * This class is mainly used to describe how an evil trick the knight at a random adventure.
 * @author Anzhe Meng 
 * BUID U50590533
 *
 */
public class Evil {
	private static int level = (int)(Math.random() * 3) + 1; // The index of the adventure where the trick takes place
	
	
	public Evil() {
		
	}
	
	/**
	 * This function is designed to imitate how an evil will perform a trick to a player
	 * @return It returns i representing the evil is going to show the trick in the i-th adventure
	 */
	public int trick() {
		return this.get_level();
	}
	
	public int get_level() {
		return Evil.level;
	}
}
