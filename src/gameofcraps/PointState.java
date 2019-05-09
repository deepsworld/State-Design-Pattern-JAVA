package gameofcraps;

public class PointState extends State {
// ------------------------------------------------------------------------
// Second roll of dice:
//    7 Loss ("seven out")
//    match of previous roll Win ("hits the points")
//    any other, roll again
// ------------------------------------------------------------------------    
    private int points_to_match;

    public PointState(State source) {
        super(source);
        points_to_match = super.getContext().getCurrentRoll();
    }
    
    public PointState(Dice dice) {
        super(dice);
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

    public void transitionState() {
        // 7 - craps
        if(super.getContext().getCurrentRoll() == 7){
            getContext().setState(new Loss(this));
            System.out.println("\troll of " + 7 + " (craps)");
        }
        // Same - wins
        else if(points_to_match == super.getContext().getCurrentRoll()){
            getContext().setState(new Win(this));
            System.out.println("\troll of " + super.getContext().getCurrentRoll() + "(hits the point-win)");
        }
        // Anyother - roll again
        else{
            super.getContext().rollDice();
        }
    }
    // transitions to either a Win or Loss state
}
