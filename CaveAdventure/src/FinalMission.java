import java.util.ArrayList;
import java.util.Random;

public class FinalMission extends Adventure{

    @Override
    public void move() throws Exception {
        narrator.set_Adventure(this);
        narrator.opening_question();
        valid_input = false;
        String answer = sc.next();
        YesNoJudge(answer);
        if (answer.equalsIgnoreCase("y")) {
            mission(answer);
        } else {
            System.out.println("Thanks for coming! See you next time!");
        }
    }



    private boolean StrInList(String s, ArrayList<String> ss) {
        return ss.contains(s);
    }

    private String poem(ArrayList<String> arr) {
        Random rand = new Random();


        for (int i = arr.size() - 1; i >= 0; i--) {
            int j= rand.nextInt(i + 1);
            String tmp = arr.get(i);
            arr.set(1, arr.get(j));
            arr.set(j, tmp);
        }

        String s="";
        for (String n:arr) {
            s+=(n+' ');
        }
        return s;
    }

    private void mission(String answer) {
        answer = sc.nextLine();
        System.out.println("Let's start the mission now!");
        int num = (int)(Math.random() * 101) + 1;
        ArrayList<String> str = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            System.out.println("Village Idiot #" + i +", what is your special word?");
            System.out.print("> ");
            answer = sc.nextLine();
            if (answer.equals("break")) {
                break;
            }
            boolean unique = true;
            while (unique) {
                if (!StrInList(answer, str)) {
                    str.add(answer);
                    unique = false;
                } else {
                    System.out.println("The word has been recorded!");
                    System.out.println("It can't be that, say it again.");
                    System.out.print("> ");
                    answer = sc.nextLine();
                    if (answer.equals("break")) {
                        break;
                    }
                }
            }
        }
        System.out.println("Generate the poem made up of a random selection of the special words entered and you are DONE!");
        System.out.println(poem(str));
    }
}
