package nyc.c4q;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        game();
    }

    public static void game(){
        Hangman hangman = new Hangman();
        while (hangman.getMisses() < 5){
            hangman.printCurrentWord();
            hangman.promptPlayer("Enter a letter: ");
            hangman.readLetter();
            hangman.checkLetter();
            if(hangman.guessedSuccessfully()){
                break;
            }
            System.out.println(Drawing.get(hangman.getMisses()));
            System.out.println("Misses -> " +hangman.getMisses());
        }
        if(hangman.guessedSuccessfully()){
            System.out.println("Success");
        } else {
            System.out.println("The answer was " + hangman.getSecretWord());
        }

        endGame();
    }

    public static void endGame () {
        Scanner input = new Scanner(System.in);
        boolean validChoice;

        do {
            System.out.println("***********");
            System.out.println("Would you like to play again?");
            System.out.println("[Yes/No]");
            System.out.println("***********");
            String choice = input.next();

            switch (choice.toLowerCase()) {
                case "yes":case "y":
                    validChoice = true;
                    System.out.println("***********");
                    System.out.println("Great! Let's play.");
                    System.out.println("***********\n");
                    game();
                    break;
                case "no":case "n":
                    validChoice = true;
                    System.out.println("***********");
                    System.out.println("Thanks for playing!");
                    System.out.println("***********\n");
                    break;
                default:
                    validChoice = false;
                    System.out.println("***********");
                    System.out.println("Sorry. I didn't understand.");
                    continue;
            }
        } while (!validChoice);
    }
}
