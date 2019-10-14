import java.util.ArrayList;
import java.util.Scanner;
/**
 * The detailed procedure of a tour towards the depth of the cave
 * @author Anzhe Meng
 * BUID U50590533
 *
 */
public class Journey {
	private Adventure a = new Adventure();
//	private Knight[] knight;
	private ArrayList<Knight> knight = new ArrayList<Knight>();
	private Scanner sc = new Scanner(System.in);
	private Narrator narrator = new Narrator();
	private Evil evil = new Evil();
	/**
	 * The following two variables are just designed to support the program
	 */
	private boolean valid_input = false;
	private String answer = sc.next();
	
	/**
	 * Take a metaphor, assume a person walks by the cave, and somebody asks for help.
	 * This function is somehow like the way that the guidance before the knight decides to venture.
	 * @param exit
	 */
	public void entrance(boolean exit) {
		narrator.set_Knight(knight);
		String name = sc.next();
		knight = new Knight(name);
		narrator.Welcoming();
		int beg = 1;
		
		while(!valid_input) {
			if (answer.equalsIgnoreCase("yes")) {
				valid_input = true;
			}
			else if (answer.equalsIgnoreCase("no")) {
				beg++;
				if (beg <= 2) { // I allow the system/villagers to beg the player to reconsider again
					System.out.print("бн. Please, please help us brave knight, are you ready to enter the mouth of the caves (Y/N)? ");
					answer = sc.next();
				}
				else {
					System.out.println("Thanks for coming! See you next time!");
					valid_input = true;
					exit = true;
				}
			}
			else {
				System.out.print("Can you say it again, our mighty " + knight + "?");
			}
		}
	}
	
	/**
	 * This function shows how a person venture the cave step by step.
	 * Majorly, there is for loop, meaning the knight passes through one by one more adventure.
	 * @param exit
	 */
	public void venture(boolean exit) {
		int trap = evil.get_level(); // There will be a trap in the NO.(trap) adventure
		//"for loop" here represents the process that a knight ventures deeper into the cave.
		for (int i = 1; i <= 3; i++) {
			a = new Adventure(i, knight);
			narrator.set_Adventure(a);
			narrator.openning_question();
			answer = sc.next();
			valid_input = false;
			while(!valid_input) {
				if (answer == "1" || answer == "2") {
					valid_input = true;
				}
				else {
					System.out.print("Can you say it again, our mighty " + knight + "?");
				}
			}
			if (answer == "1") {
				a.set_Slayed(); // The evil awaiting in this adventure  has been slayed.
				narrator.after_killing_monster(); // The question that is set to pop up when the knight successfully kills the monster
				answer = sc.next();
				valid_input = false;
				while(!valid_input) {
					if (answer == "1" || answer == "2") {
						valid_input = true;
					}
					else {
						System.out.print("Can you say it again, our mighty " + knight + "?");
					}
				}
				if (answer == "1") { // The knight forgets to pick the treasure, then game is over.
					System.out.println("You failed to pick up the treasure, game over!");
					exit = true;
				}
				else { // The knight has both killed the monster and collected the treasure, then he/she enters deeper or completes the journey.
					narrator.after_finding_treasure();
					answer = sc.next();
					i++;
				}
			}
			else {
				a.set_found(); // The treasure in this adventure has been picked up.
				System.out.println("You have picked up the treasure, now go rest before continuing the mission");
				knight.dream();
				narrator.after_finding_treasure(); // The question that is set to pop up when the knight successfully picks up the treasure
				answer = sc.next();
				valid_input = false;
				while(!valid_input) {
					if (answer == "1" || answer == "2") {
						valid_input = true;
					}
					else {
						System.out.print("Can you say it again, our mighty " + knight + "?");
					}
				}
				if (answer == "2") { // The knight has both killed the monster and collected the treasure, then he/she enters deeper or completes the journey.
					narrator.after_killing_monster();
					answer = sc.next();
				}
				else {
					System.out.println("You failed to kill the enemy, game over!");
					exit = true;
				}
				narrator.trap_testing(trap);
				if (this.a.get_level() == trap) {
					answer = sc.next();
					valid_input = false;
					while(!valid_input) {
						if (answer == "1" || answer == "2") {
							valid_input = true;
						}
						else {
							System.out.print("Can you say it again, our mighty " + knight + "?");
						}
					}
					if (answer == "2") { // The knight is seduced to make a mistake
						knight.penance();
						
					}
					else {
						narrator.after_killing_monster();
						answer = sc.next();
						i++;
					}
				}
			}
		}
	}
}
