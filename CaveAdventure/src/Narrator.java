import java.util.Scanner;

/**
 * This is an implicit class because we are not given such a character throughout the specification.
 * But it helps the whole program a lot, making it much more logical.
 * @author Anzhe Meng
 * BUID U50590533
 *
 */
public class Narrator {
	private Adventure a;
	private Knight knight;

	private Scanner sc = new Scanner(System.in);

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
	public Knight Welcoming() {
		System.out.print("Brave knight!!! What is your name?");
		String answer = sc.next();
		this.knight = new Knight(answer);
		System.out.println("We are in need of your help, " + knight.get_Name() + "!");
		System.out.println("Our village is being overrun by the goblins of the NorthernCaves.");
		System.out.println("We need you to defeat them!");
		System.out.print("Will you accept the challenge(Y/N)?");

		return this.knight;
	}
	
	/**
	 * The question that pops up as soon as the player enters a new adventure
	 */
	public void opening_question() {
		switch(this.get_Adventure().get_level()) {
		case 1:
			System.out.println("You are now entering the mouth of the cave, what would you like to do?");
			System.out.println("     1) Attack the evil " + Task.EVILS[0] + " and " + Task.MISSIONS[0]);
			System.out.println("     2) Pick up the golden " + Task.TREASURES[0]);
			break;
		case 2:
			System.out.println("You have ventured deeper into the cave, what would you like to do?");
			System.out.println("     1) Attack the evil " + Task.EVILS[1] + " and " + Task.MISSIONS[1]);
			System.out.println("     2) Pick up the golden " + Task.TREASURES[1]);
			break;
		case 3:
			System.out.println("Great! You have now reached the very deep of the caves, what would you like to do?");
			System.out.println("     1) Attack the evil " + Task.EVILS[2]);
			System.out.println("     2) Pick up the golden " + Task.TREASURES[2]);
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
			if (this.a.mission_completed()) {
				System.out.println("Oh, my knight! You are still alive and can get ready for the next adventure");
				System.out.println("You have ventured deeper into the cave, what would you like to do?");
				System.out.println("     1) Move on to the next adventure");
			}
			else if (!this.a.get_found()) {
				System.out.println("You slayed the evil " + Task.EVILS[this.a.get_level()-1] + " and are sill alive, what would you like to do?");
				System.out.println("     1) Move on to the next adventure");
				System.out.println("     2) Pick up the golden " + Task.TREASURES[this.a.get_level()-1]);
			}
		}
		else {
			if (this.a.mission_completed()) {
				System.out.println("Yes! Now there is only the final mission left, ready go!");
//				System.out.println("Are you ready for the final mission (Y/N)?");
			} else if (!this.a.get_found()) {
				System.out.println("You slayed the evil " + Task.EVILS[this.a.get_level() - 1] + " and are sill alive, what would you like to do?");
				System.out.println("     1) Move on to the final mission");
				System.out.println("     2) Pick up the golden " + Task.TREASURES[this.a.get_level() - 1]);
			}
		}
	}
	
	/**
	 * The question that pops up as soon as the player finds the treasure at that adventure
	 */
	public void after_finding_treasure() {
		if (this.a.get_level() < 3) {
			if (this.a.mission_completed()) {
				System.out.println("Oh, my knight! You are still alive and can get ready for the next adventure");
				System.out.println("You have ventured deeper into the cave, what would you like to do?");
				System.out.println("     1) Move on to the next adventure");
			}
			else if (!this.a.get_slayed()) {
				System.out.println("You have picked up the gold " + Task.TREASURES[this.a.get_level()-1] + " and are still alive, what would you like to do?");
				System.out.println("     1) Move on to the next adventure");
				System.out.println("     2) Attack the evil " + Task.EVILS[this.a.get_level()-1] + " and " + Task.MISSIONS[this.a.get_level()-1]);
			}
		}
		else {
            if (this.a.mission_completed()) {
                System.out.println("Yes! Now there is only the final mission left, ready go!");
//                System.out.println("Are you ready for the final mission (Y/N)?");
            }
            else if (!this.a.get_slayed()) {
                System.out.println("You have picked up the gold " + Task.TREASURES[this.a.get_level()-1] + " and are sill alive, what would you like to do?");
                System.out.println("     1) Move on to the final mission");
                System.out.println("     2) Attack the hobgoblin lord " + Task.EVILS[this.a.get_level()-1]);
            }
        }
	}
	
	/**
	 * This function is not executed until a monster trick the knight to collect one more thing.
	 */
	public void trap_testing() {
        if (this.a.get_level() < 3) {
            System.out.println("Great! You are awake and rested what would you like to do?");
            System.out.println("     1) Attack the evil " + Task.EVILS[this.a.get_level()-1] + " and " + Task.MISSIONS[this.a.get_level()-1]);
            System.out.println("     2) Pick up the silver tray of life");
        }
        else {
            System.out.println("Great! You are awake and rested what would you like to do?");
            System.out.println("     1) Attack the hobgoblin lord " + Task.EVILS[this.a.get_level()-1]);
            System.out.println("     2) Pick up the silver tray of life");
            }
	}

	public void cursed_notice() {
	    System.out.println("You are tricked! And now you have to do the penance.");
	    System.out.println("Choose the punishment you want.");
	    System.out.println("     1) Sing Twelve Days of Christmas");
	    System.out.println("     2) Solve out 5 equations");
    }

    public void after_penance() {
	    if (this.a.get_level() < 3) {
            System.out.println("Great! You've done the penance, what would you like to do?");
            System.out.println("     1) Attack the evil " + Task.EVILS[this.a.get_level()-1] + " and " + Task.MISSIONS[this.a.get_level()-1]);
            System.out.println("     2) Pick up the silver tray of life");
        }
	    else {
            System.out.println("Great! You've done the penance, what would you like to do?");
            System.out.println("     1) Attack the hobgoblin lord " + Task.EVILS[this.a.get_level()-1]);
            System.out.println("     2) Pick up the silver tray of life");
        }
    }
}
