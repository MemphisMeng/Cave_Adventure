public class CursedAdventure extends Adventure {
    private int tricked;

    public CursedAdventure(int i, Knight knight, Narrator narrator) {
        super(i, knight, narrator);
    }

    @Override
    public void move() throws Exception {
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
            } else { // The knight has both killed the monster and collected the treasure, then he/she enters deeper or completes the journey.
                this.set_found();
                narrator.after_finding_treasure();
                if (this.get_level() != 3) {
                    answer = sc.next();
                }
            }
        } else {
            this.set_found(); // The treasure in this adventure has been picked up.
            System.out.println("You have picked up the treasure, now go rest before continuing the mission.\n");
            new Dream();
            narrator.trap_testing(); // The question that is set to pop up when the knight successfully picks up the treasure
            renew();
            tricked =  answer.equals("2")? 2: 1;
            while (tricked > 0) {
                switch (answer) {
                    case "1":
                        this.set_slayed();
                        narrator.after_killing_monster();
                        if (this.get_level() != 3) {
                            answer = sc.next();
                        }
                        tricked = 0;
                        break;
                    case "2":
                        narrator.cursed_notice();
                        renew();
                        Penance penance = new Penance(Integer.parseInt(answer));
                        penance.execute();
                        narrator.after_penance();
                        renew();
                }
            }
        }
    }
}
