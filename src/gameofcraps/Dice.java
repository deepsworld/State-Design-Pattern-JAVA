
package gameofcraps;

import java.util.Random;

public class Dice {
// Context class - current roll of the dice
    
    private int current_roll;
    private State objState;
    private final int MIN = 2;
    private final int MAX = 12;

    public Dice() {
        objState = State.InitialState(this);
    }

    public void setState(State newState) {
        objState = newState;
    }

    public State getState() {
        return objState;
    }

    public int getCurrentRoll() {
        return current_roll;
    }

    public void rollDice() {
        current_roll = generateRoll();
        System.out.println(" rolled a " + current_roll);
        objState.roll_dice();
    }

    // randmomly generated number between 2-12
    private int generateRoll(){
        return generateRandomIntRange(MIN,MAX);
    }

    // generates random int between min and max
    private int generateRandomIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
