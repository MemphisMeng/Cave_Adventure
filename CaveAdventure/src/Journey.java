import java.util.ArrayList;
import java.util.Scanner;

/**
 * The detailed procedure of a tour towards the depth of the cave
 * @author Anzhe Meng
 * BUID U50590533
 *
 */
public class Journey {
	private ArrayList<Adventure> adventures = new ArrayList<>();
	private Knight knight;
	private Narrator narrator;
	private Evil evil;
	/**
	 * The following variable is just designed to support the program
	 */
	private Scanner sc = new Scanner(System.in);

	public Journey() {
		this.narrator = new Narrator();
	}
	
	/**
	 * Take a metaphor, assume a person walks by the cave, and somebody asks for help.
	 * This function is somehow like the way that the guidance before the knight decides to venture.
	 */
	public void entrance(){
		this.knight = narrator.Welcoming();
		try {
			acceptChallenge();
		} catch (Exception e) {
			// Terminate the game if the player fails.
		}

	}
	
	/**
	 * This function shows how a person venture the cave step by step.
	 * Majorly, there is for loop, meaning the knight passes through one by one more adventure.
	 */
	private void venture() throws Exception{
		this.evil = new Evil();
		int trap = evil.get_level(); // There will be a trap in the NO.(trap) adventure
		//"for loop" here represents the process that a knight ventures deeper into the cave.
		for (int i = 1; i <= 3; i++) {
			Adventure adventure = (trap == i) ? new CursedAdventure(i, knight, narrator) : new Adventure(i, knight, narrator);
			adventures.add(adventure);
		}
		Adventure finalMission = new FinalMission();
		adventures.add(finalMission);
		for (Adventure a: adventures) {
			a.move();
		}
	}

	void acceptChallenge() throws Exception{
		int beg = 1;
		boolean valid_input = false;
		String answer = sc.next();

		while(!valid_input) {
			if (answer.equalsIgnoreCase("y")) {
				valid_input = true;
				venture();
			}
			else if (answer.equalsIgnoreCase("n")) {
				beg++;
				if (beg <= 2) { // I allow the system/villagers to beg the player to reconsider again
					System.out.print("бн. Please, please help us brave knight, are you ready to enter the mouth of the caves (Y/N)? ");
					answer = sc.next();
				}
				else {
					System.out.println("Thanks for coming! See you next time!");
					valid_input = true;
				}
			}
			else {
				System.out.print("Can you say it again, our mighty " + knight.get_Name() + "?");
				answer = sc.next();
			}
		}
	}
}
