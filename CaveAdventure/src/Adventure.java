import java.util.ArrayList;

/**
 * This class describes the general properties of an adventure at each level.
 * It can be repetively used for three times.
 * @author Anzhe Meng
 * BU ID U50590533
 *
 */
public class Adventure {
	private int level; // There are 3 different adventures in total.
	private boolean trick; // True when the trick shows up at random at this stage, otherwise false
	private boolean slayed = false; // Check the monster whether or not is slayed
	private boolean found = false; // Check the treasure whether or not is found
//	private Knight[] knight;
	private ArrayList<Knight> knight = new ArrayList<Knight>();
	
	public static final String[] EVILS = {"Marcel", "Limpian", "DivaDon"};
	public static final String[] TREASURES = {"sword", "shield", "helmet"};
	public static final String[] MISSIONS = {"clean up all the cob webs", "turn off the water supply", "perform the poetry of life"};
	
	public Adventure() {
		
	}
	
	public Adventure(int LEVEL, Knight knight) {
		this.level = LEVEL;
		this.knight = knight;
	}
	
	public void set_level(int l) {
		this.level = l;
	}
	
	public void set_Slayed() {
		this.slayed = true;
	}
	
	public void set_found() {
		this.found = true;
	}
	
	/**
	 * The access to the private variable level, showing how deep the knight has ventured
	 * @return the private variable level
	 */
	public int get_level() {
		return this.level;
	}
	
	/**
	 * The access to the private variable found, checking whether the treasure at this adventure is found.
	 * @return true when it is found
	 */
	public boolean get_found() {
		return this.found;
	}
	
	/**
	 * The access to the private variable slayed, checking whether the monster at this adventure is killed.
	 * @return true when it is killed
	 */
	public boolean get_slayed() {
		return this.slayed;
	}
	/**
	 * Check whether the knight completes or not the mission		
	 * @return The symbol whether a knight completes his/her missions in an adventure.
	 */
	public boolean Mission_Completed() {
		boolean completed = false;
		if (slayed == true && found == true) {
			completed = true;
		}
		return completed;
	}
}
