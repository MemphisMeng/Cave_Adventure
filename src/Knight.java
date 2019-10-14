import java.util.Scanner;
/**
 * This class is in charge of a player's movements and his/her properties
 * @author pc1
 *
 */
public class Knight {
	private String name;
	
	public Knight() {
		
	}
	
	public Knight(String name) {
		this.name = name;
	}
	
	public String get_Name() {
		return this.name;
	}
	
	public void set_Name(String name) {
		this.name = name;
	}
	
	/**
	 * When the knight collects the treasure ahead of killing the monster, it will be called.
	 */
	public void dream() {
		String[] stocks = {"cow", "sheep", "pig", "chicken"};
		String[] sounds = {"moo", "meo", "quack", "chic"};
		
		int num = (int)(Math.random() * 4);
		System.out.println("Old MacDonald had a farm e-i-e-i-o.");
		System.out.println("And on this farm he had a " + stocks[num] + " e-i-e-i o");
		System.out.println("With a " + sounds[num] + "-" + sounds[num] + "here and " + sounds[num] + "-" + sounds[num] + " there");
		System.out.println("Here a " + sounds[num] + " there a " + sounds[num] + " everywhere a " + sounds[num] + "-" + sounds[num]);
	}
	
	/**
	 * Executing the penance
	 */
	public void penance() {
		int num = (int)(Math.random() * 2) + 1;
		
		switch(num) {
		case 1:
			System.out.println("Now you have to see a song for me!");
			sing();
			break;
		case 2:
			equations();
			System.out.println("Before you leave, you have to figure out five equations right now!");
			break;
		}	
	}
	
	/**
	 * One kind of punishment when choosing a wrong option.
	 * It will not be independently called, and neither will equations(), because both of them are embedd in the penance()
	 */
	public void sing() {
		System.out.println("On the first day of Christmas my true love gave to me, a partridge in a pear tree");
		System.out.println("On the second day of Christmas my true love gave to me, two turtle doves and a partridge in a pear tree");
		System.out.println("On the third day of Christmas my true love gave to me, three French hens, two turtle doves and a partridge in a pear tree");
		System.out.println("On the fourth day of Christmas My true love gave to me Four calling birds Three French hens Two turtle doves And a partridge in a pear tree");
		System.out.println("etc.");
	}
	
	/**
	 * Another kind of punishment when choosing a wrong option.
	 */
	public void equations() {
		Scanner sc = new Scanner(System.in);
		String answer;
		for (int i = 0; i < 5; i++) {
			int a = (int)(Math.random() * 100) + 1;
			int b = (int)(Math.random() * 100) + 1;
			System.out.print(Integer.toString(a) + "+" + Integer.toString(b) + "=");
			answer = sc.next();
			boolean correct = false;
			while (!!correct) {
				if (Integer.parseInt(answer) == a + b) {
					System.out.println("Correct! Get ready for the next question!");
					correct = true;
				}
				else {
					System.out.println("Wrong! Please try again!");
					answer = sc.next();
				}
			}
		}
	}
}
