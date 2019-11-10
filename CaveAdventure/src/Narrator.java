import java.util.ArrayList;

/**
 * This is an implicit class because we are not given such a character throughout the specification.
 * But it helps the whole program a lot, making it much more logical.
 * @author Anzhe Meng
 * BUID U50590533
 *
 */
public class Narrator {
	private Adventure a;
//	private Knight[] knight;
	private ArrayList<Knight> knight = new ArrayList<Knight>();
	
	public Narrator() {
		
	}
	
	public void set_Adventure(Adventure a) {
		this.a = a;
	}
	
	public void set_Knight(Knight k) {
		this.knight = k;
	}
	
	public Adventure get_Adventure() {
		return this.a;
	}
	
	public Knight get_Knight() {
		return this.knight;
	}
	
	/**
	 * When the knight is "wandering" around the cave, the function will be called, asking for help.
	 */
	public void Welcoming() {
		System.out.print("Brave knight!!! What is your name?");
		System.out.println("We are in need of your help, " + knight + "!");
		System.out.println("Our village is being overrun by the goblins of the NorthernCaves.");
		System.out.println("We need you to defeat them!");
		System.out.print("Will you accept the challenge(Y/N)?");
	}
	
	/**
	 * The question that pops up as soon as the player enters a new adventure
	 */
	public void openning_question() {
		switch(this.get_Adventure().get_level()) {
		case 1:
			System.out.println("You are now entering the mouth of the cave, what would you like to do?");
			System.out.println("     1) Attack the evil " + Adventure.EVILS[0] + " and " + Adventure.MISSIONS[0]);
			System.out.println("     2) Pick up the golden " + Adventure.TREASURES[0]);
			break;
		case 2:
			System.out.println("You have ventured deeper into the cave, what would you like to do?");
			System.out.println("     1) Attack the evil " + Adventure.EVILS[1] + " and " + Adventure.MISSIONS[1]);
			System.out.println("     2) Pick up the golden " + Adventure.TREASURES[1]);
			break;
		case 3:
			System.out.println("Great! You have now reached the depths of the caves, what would you like to do?");
			System.out.println("     1) Attack the evil " + Adventure.EVILS[2]);
			System.out.println("     2) Pick up the golden " + Adventure.TREASURES[2]);
			break;
		default:
			System.out.println("Are you ready for the final mission (Y/N)?");
			break;
		}
	}
	
	/**
	 * The question that pops up as soon as the player kills the monster at every adventure
	 */
	public void after_killing_monster() {
		if (this.a.get_level() < 3) { // Before the knight enters the deepest of the cave
			if (this.a.Mission_Completed()) {
				System.out.println("Oh, my knight! You are still alive and can get ready for the next adventure");
				System.out.println("You have ventured deeper into the cave, what would you like to do?");
				System.out.println("     1) Move on to the next adventure");
			}
			else if (!this.a.get_found()) {
				System.out.println("You slayed the evil " + Adventure.EVILS[this.a.get_level()] + " and are sill alive, what would you like to do?");
				System.out.println("     1) Move on to the next adventure");
				System.out.println("     2) Pick up the golden " + Adventure.TREASURES[this.a.get_level()]);
			}
		}
		if (this.a.Mission_Completed()) {
			System.out.println("Yes! Now there is only the final mission left, ready go!");
			System.out.println("Are you ready for the final mission (Y/N)?");
		}
		else if (!this.a.get_found()) {
			System.out.println("You slayed the evil " + Adventure.EVILS[this.a.get_level()] + " and are sill alive, what would you like to do?");
			System.out.println("     1) Move on to the final mission");
			System.out.println("     2) Pick up the golden " + Adventure.TREASURES[this.a.get_level()]);
		}
	}
	
	/**
	 * The question that pops up as soon as the player finds the treasure at that adventure
	 */
	public void after_finding_treasure() {
		if (this.a.get_level() < 3) {
			if (this.a.Mission_Completed()) {
				System.out.println("Oh, my knight! You are still alive and can get ready for the next adventure");
				System.out.println("You have ventured deeper into the cave, what would you like to do?");
				System.out.println("     1) Move on to the next adventure");
			}
			else if (!this.a.get_slayed()) {
				System.out.println("You have picked up the gold " + Adventure.TREASURES[this.a.get_level()] + " and are still alive, what would you like to do?");
				System.out.println("     1) Move on to the next adventure");
				System.out.println("     2) Attack the evil " + Adventure.EVILS[this.a.get_level()] + " and " + Adventure.MISSIONS[this.a.get_level()]);
			}
		}
		if (this.a.Mission_Completed()) {
			System.out.println("Yes! Now there is only the final mission left, ready go!");
			System.out.println("Are you ready for the final mission (Y/N)?");
		}
		else if (!this.a.get_found()) {
			System.out.println("You have picked up the gold " + Adventure.TREASURES[this.a.get_level()] + " and are sill alive, what would you like to do?");
			System.out.println("     1) Move on to the final mission");
			System.out.println("     2) Attack the hobgoblin lord " + Adventure.EVILS[this.a.get_level()]);
		}
	}
	
	/**
	 * The question that pops up as soon as the player finds the treasure at that adventure
	 */
	public void after_waking_up() {
		System.out.println("Great! You are awake and rested what would you like to do?");
		System.out.println("     1) Move on to the next adventure");
		System.out.println("     2) Attack the evil " + Adventure.EVILS[this.a.get_level()] + " and " + Adventure.MISSIONS[this.a.get_level()]);
	}
	
	/**
	 * This function is not executed until a monster trick the knight to collect one more thing.
	 * @param trap it stands by the index of the adventure where the trick takes place
	 */
	public void trap_testing(int trap) {
		if (this.a.get_level() == trap) {
			if (this.a.get_level() < 3) {
				if (this.a.Mission_Completed()) {
					System.out.println("Oh, my knight! You are still alive, what would you like to do?");
					System.out.println("     1) Move on to the next adventure");
					System.out.println("     2) Pick up the silver tray of life");
				}
				else if (!this.a.get_slayed()) {
					System.out.println("You have picked up the gold " + Adventure.TREASURES[this.a.get_level()] + " and are still alive, what would you like to do?");
					System.out.println("     1) Attack the evil " + Adventure.EVILS[this.a.get_level()] + " and " + Adventure.MISSIONS[this.a.get_level()]);
					System.out.println("     2) Pick up the silver tray of life");
				}
			}
			if (this.a.Mission_Completed()) {
				System.out.println("Oh, my knight! You are still alive, what would you like to do?");
				System.out.println("     1) Move on to the next adventure");
				System.out.println("     2) Pick up the silver tray of life");
			}
			else if (!this.a.get_found()) {
				System.out.println("You have picked up the gold " + Adventure.TREASURES[this.a.get_level()] + " and are sill alive, what would you like to do?");
				System.out.println("     1) Attack the hobgoblin lord " + Adventure.EVILS[this.a.get_level()]);
				System.out.println("     2) Pick up the silver tray of life");
			}
		}
	}
}
