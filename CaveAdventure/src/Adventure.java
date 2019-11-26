import java.util.Scanner;

/**
 * This class describes the general properties of an adventure at each level.
 * It can be repetively used for three times.
 * @author Anzhe Meng
 * BU ID U50590533
 *
 */
public class Adventure implements Task{
	private int level; // There are 3 different adventures in total.
	private boolean slayed = false; // Check the monster whether or not is slayed
	private boolean found = false; // Check the treasure whether or not is found
	static Knight knight = new Knight();
	static Narrator narrator = new Narrator();

	// supporting variables
	static Scanner sc = new Scanner(System.in);
	static boolean valid_input;
	static String answer;
	
	public Adventure() {
		
	}
	
	public Adventure(int LEVEL, Knight knight, Narrator narrator) {
		this();
		this.level = LEVEL;
		this.knight = knight;
		this.narrator = narrator;
	}
	
	public void set_slayed() {
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
	public boolean mission_completed() {
		boolean completed = false;
		if (slayed == true && found == true) {
			completed = true;
		}
		return completed;
	}

	@Override
	public void move() throws Exception{
		narrator.set_Adventure(this);
		narrator.opening_question();
		renew();
		if (answer.equals("1")) {
			this.set_slayed(); // The evil awaiting in this adventure  has been slayed
			narrator.after_killing_monster(); // The question that is set to pop up when the knight successfully kills the monster
			renew();
			if (answer.equals("1")) { // The knight forgets to pick the treasure, then game is over.
				System.out.println("You failed to pick up the treasure, game over!");
				throw new Exception();
			}
			else { // The knight has both killed the monster and collected the treasure, then he/she enters deeper or completes the journey.
				this.set_found();
				narrator.after_finding_treasure();
				if (this.get_level() != 3) {
					answer = sc.next();
				}
			}
		}
		else {
			this.set_found(); // The treasure in this adventure has been picked up.
			System.out.println("You have picked up the treasure, now go rest before continuing the mission.\n");
			new Dream();
			narrator.after_finding_treasure(); // The question that is set to pop up when the knight successfully picks up the treasure
			renew();
			if (answer.equals("2")) { // The knight has both killed the monster and collected the treasure, then he/she enters deeper or completes the journey.
				this.set_slayed();
				narrator.after_killing_monster();
				if (this.get_level() != 3) {
					answer = sc.next();
				}
			}
			else {
				System.out.println("You failed to kill the enemy, game over!");
				throw new Exception();
			}
		}
}

	protected static void optionsJudge(String s) {
		while(!valid_input) {
			if (s.equals("1") || s.equals("2")) {
				valid_input = true;
			}
			else {
				System.out.print("Can you say it again, our mighty " + knight.get_Name() + "?");
				s = sc.next();
			}
		}
	}

	protected static void YesNoJudge(String s) {
		while(!valid_input) {
			if (s.equals("y") || s.equals("n")) {
				valid_input = true;
			}
			else {
				System.out.print("Can you say it again, our mighty " + knight.get_Name() + "?");
				s = sc.next();
			}
		}
	}

	protected static void renew() {
		answer = sc.next();
		valid_input = false;
		optionsJudge(answer);
	}
}
