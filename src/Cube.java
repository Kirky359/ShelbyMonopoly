public class Cube {
    private int roll1;
    private int roll2;
    // Rolls two dice and returns the sum of the results
    public int rollCube() {
        int roll1;
        int roll2;

        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);

        System.out.println("You got " + roll1 + " and " + roll2);
        return roll1 + roll2;
    }
}
