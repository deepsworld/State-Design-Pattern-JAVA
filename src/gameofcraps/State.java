package gameofcraps;

public abstract class State {

    private Dice context;

    public State(Dice dice) {
        context = dice;
    }

    public State(State source) {
        setContext(source.getContext());
    }

    public static State InitialState(Dice pts) {
        return new ComingOutState(pts);
    }

    public Dice getContext() {
        return context;
    }

    public void setContext(Dice dice) {
        context = dice;
    }
    
    public void roll_dice(){
        transitionState();
    }

    public abstract void transitionState();

}
