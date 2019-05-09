package gameofcraps;

public class Loss extends State {

    public Loss(Dice pts) {
        super(pts);
    }
    
    public Loss(State source) {
        super(source);
    }

    public void transitionState() {
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }
}
