package views;

import java.util.Scanner;

public class CmdLineView {

    private String[] letters;
    private String theGuess;

    public CmdLineView(String[] letters) {
        this.letters = letters;
    }

    public void startGame() {
        System.out.println("Guess the word \n");
        for(int i = 0; i < letters.length; i++){
            System.out.print("_ ");
        }
        System.out.print("\n");
    }

    public String makeAGuess(){
        System.out.println("Guess a letter: ");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public void displayHints(String[] hints){
        for(String hint: hints){
            System.out.print(hint);
        }
        System.out.print("\n");
    }

    public void cheat(String theWord){
        System.out.println("The word is " + theWord + ".");
    }

    public void win() {
        System.out.println("You win!");
    }

    public void lose(String word) {
        System.out.println("You lose, the word was " + word); 
    }

    public void wrongGuess(int numGuesses) {
        System.out.println("That letter is not in the word, you have " + numGuesses + " incorrect guesses remaining");
    }


    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public String getTheGuess() {
        return theGuess;
    }

    public void setTheGuess(String theGuess) {
        this.theGuess = theGuess;
    }
}
