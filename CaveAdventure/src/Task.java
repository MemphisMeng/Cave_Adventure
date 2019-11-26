public interface Task {
    String[] EVILS = {"Marcel", "Limpian", "DivaDon"};
    String[] TREASURES = {"sword", "shield", "helmet"};
    String[] MISSIONS = {"clean up all the cob webs", "turn off the water supply", "perform the poetry of life"};

    void move() throws Exception;
}
