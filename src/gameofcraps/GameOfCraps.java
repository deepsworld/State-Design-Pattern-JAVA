package gameofcraps;

import java.util.Random;
import java.util.Scanner;

/**
 * Main Driver
 */
public class GameOfCraps {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
 
        int hwager, cwager;
        int human_winnings = 0;
        int computer_winnings = 0;
        int num_games_to_play;
        
        final int MAX_WAGER = 100;
        Dice dice;

        num_games_to_play = promptForNumGames();
        for(int i = 1; i <= num_games_to_play; i++){

            // HUMAN'S ROUND
            hwager = getHumansWager(MAX_WAGER);
            cwager = randomly_generate(MAX_WAGER);
            System.out.println("I wager $" + cwager + " (Computer)");
            dice = new Dice();
            System.out.println("Your rolls...");
            playRound(dice);

            if(dice.getState() instanceof Win)
                human_winnings = human_winnings + hwager;
            else
                human_winnings = human_winnings - hwager;

            // COMPUTER'S ROUND
            dice = new Dice();
            System.out.println("Now its my turn...");
            playRound(dice);

            if(dice.getState() instanceof Win)
                computer_winnings = computer_winnings + cwager;
            else
                computer_winnings = computer_winnings - cwager;
            System.out.println("Your winnings: " + human_winnings);
            System.out.println("My winnings: " + computer_winnings);
        }
        // FINAL WINNER
        if(human_winnings > computer_winnings){
            System.out.println("--- Game Over: Humans rule <^ ^>");
        }
        else{
            System.out.println("--- Game Over: Computers rule <* *>");
        }
    } 

    /*
    Prompt user for number of games.
     */
    public static int promptForNumGames(){
        int response = 0;
        do{
            System.out.println("How many rounds would you like to play: ");
            response = scan.nextInt();
        }
        while(response <= 0);
        return response;
    }
     /*
    Prompt user for their wager.
     */
    public static int getHumansWager(int max_wager){
        int response = 0;
        do{
            System.out.println("How much would you like to wager this round(between $1 & $" + max_wager + "):$ ");
            response = scan.nextInt();
        }
        while(response <= 0 || response > max_wager);
        return response;
    }

    // returns wager between 1 and max_wager dollars
    public static int randomly_generate(int max){
        return generateRandomIntRange(1,max);
    }

    public static void playRound(Dice dice){
    // play until win or loss occurs
        while(!(dice.getState() instanceof Win) &&
              !(dice.getState() instanceof Loss))
            dice.rollDice();
    }

    /**
     * Extra methods for generating random int and double between given range.
     */
    // generates random double between min and max
    public static double generateRandomDoubleRange(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    // generates random int between min and max
    public static int generateRandomIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
