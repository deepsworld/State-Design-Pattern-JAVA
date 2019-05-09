package gameofcraps;

public class ComingOutState extends State {
// ------------------------------------------------------------------------
// First roll of dice:
//    2,3, or 12 Loss ("craps")  
//    7 or 11 Win ("natural")
//    any other (4,5,6,8,9,10) establishes "points"
// ------------------------------------------------------------------------
    private int roll;

    public ComingOutState(Dice dice) {
        super(dice);
    }
    
     public ComingOutState(State source) {
        super(source);
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

    public void transitionState() {
        roll = super.getContext().getCurrentRoll();
        if (roll == 2 || roll == 3 || roll == 12){
            super.getContext().setState(new Loss(this));
            System.out.println("\troll of " + roll + "(craps)");
        }
        else if(roll == 7 || roll == 11){
            super.getContext().setState(new Win(this));
            System.out.println("\troll of " + roll + "(natural-win)");
        }
        else{
            super.getContext().setState(new PointState(this));
            System.out.println("\troll of " + roll + "(point)");
        }
    }
    //  transitions to either a Win, Loss or Points state 
    
}
