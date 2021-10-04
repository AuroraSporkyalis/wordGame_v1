package controllers;

import models.WordList;
import views.CmdLineView;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static String[] letters;
    public static int numLetters = 0;
    public static int numGuesses;
    public static String theGuess;
    public static String[] hints;
    public static  CmdLineView view;
    public static int incorrectGuesses;
    public static boolean complete;

    public static void main(String[] args) {

        numGuesses = 6;
        complete = false;


        GetWord getWord = new GetWord();
        String theWord = getWord.getTheWord();

        WordList word = new WordList(theWord);

        letters = calculateLetters(word.getTheWord());

        view = new CmdLineView(letters);
        view.startGame();
        view.cheat(word.getTheWord());

        hints = new String[letters.length];
        for(int i = 0; i < letters.length; i++){
            hints[i] = "-";
        }

        while(numGuesses > 0 && complete == false){
            guess();
            view.displayHints(hints);
            
            if(complete == true) {
                view.win();
            }
            else if(numGuesses <= 0) {
                view.lose(word.getTheWord());
            }
        }
    }

    private static String[] calculateLetters(String theWord){
        String[] letters = theWord.split("");
        numLetters = letters.length;
        return letters;
    }

    private static void guess(){
        theGuess = view.makeAGuess();

        for(int i = 0; i < letters.length; i++){
            if(letters[i].equals(theGuess)){
                hints[i] = theGuess;
            }
        }
        List<String> hint = new ArrayList(Arrays.asList(hints));
        if (!hint.contains(theGuess)) {
            numGuesses--;
            view.wrongGuess(numGuesses);
        }
        if(!hint.contains("-")) {
            complete = true;
        }
    }
}
