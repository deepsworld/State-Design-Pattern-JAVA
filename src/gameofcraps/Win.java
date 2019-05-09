package gameofcraps;

public class Win extends State {
// Dummy State
    
    public Win (Dice dice){
        super(dice);
    }

    public Win (State source) {
        super(source);
    }
    
    public void transitionState() {
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }
}
