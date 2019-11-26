public class Dream {
    private static final String[] stocks = {"cow", "sheep", "pig", "chicken"};
    private static final String[] sounds = {"moo", "meo", "quack", "chic"};

    public Dream() {
        int num = (int)(Math.random() * 4);
        System.out.println("Old MacDonald had a farm e-i-e-i-o.");
        System.out.println("And on this farm he had a " + stocks[num] + " e-i-e-i o");
        System.out.println("With a " + sounds[num] + "-" + sounds[num] + " here and " + sounds[num] + "-" + sounds[num] + " there");
        System.out.println("Here a " + sounds[num] + " there a " + sounds[num] + " everywhere a " + sounds[num] + "-" + sounds[num]);
        System.out.println();
    }
}
