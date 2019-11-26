import java.util.Scanner;

public class Penance {
    private int choice;

    static String[] lyrics = {"On the first day of Christmas my true love gave to me, a partridge in a pear tree",
            "On the second day of Christmas my true love gave to me, two turtle doves and a partridge in a pear tree",
            "On the third day of Christmas my true love gave to me, three French hens, two turtle doves and a partridge in a pear tree",
            "On the fourth day of Christmas My true love gave to me Four calling birds Three French hens Two turtle doves And a partridge in a pear tree"
    };

    public Penance(int i) {
        choice = i;
    }

    public void execute() {
        System.out.print("\nYou have picked up the option " + choice + ", ");
        switch (choice) {
            case 1:
                System.out.println("now you need to  sing the song Sing Twelve Days of Christmas totally correctly.\n");
                sing();
                break;
            case 2:
                System.out.println("here are the problem you are going to solve.\n");
                calculate();
                break;
            default:
                break;
        }
    }

    private void sing() {
        Scanner scanner = new Scanner(System.in);
        String answer;
        System.out.print("Now sing it loud!");
        for (int i = 0; i < lyrics.length; i++) {
            boolean correct = false;
            answer = scanner.nextLine();
            while (!correct) {
                if (answer.equalsIgnoreCase(lyrics[i])) {
                    while (i != lyrics.length-1) {
                        System.out.println("Good! Go on!");
                    }
                    correct = true;
                }
                else {
                    System.out.println("Wrong! Please try again!");
                    answer = scanner.nextLine();
                }
            }
        }
    }

    private void calculate() {
        Scanner sc = new Scanner(System.in);
        String answer;
        for (int i = 0; i < 5; i++) {
            int a = (int)(Math.random() * 100) + 1;
            int b = (int)(Math.random() * 100) + 1;
            System.out.print(a + "+" + b + "=");
            answer = sc.next();
            boolean correct = false;
            while (!correct) {
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
