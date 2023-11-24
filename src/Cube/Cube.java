package Cube;

import Game.PlayerInput;

public class Cube {
    private int roll1;
    private int roll2;

    public void setRoll1(int roll1) {
        this.roll1 = roll1;
    }

    public void setRoll2(int roll2) {
        this.roll2 = roll2;
    }
    // Rolls two dice and returns the sum of the results
    public int rollCube() {
        System.out.print("Press enter to roll");
        PlayerInput.read();

        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);

        System.out.println("You got " + roll1 + " and " + roll2);
        return roll1 + roll2;
    }
    public boolean isDouble(){
        return roll1 == roll2;
    }

    public int actualRoll(){
        return roll1 + roll2;
    }
}
