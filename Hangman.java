
import java.util.*;

/*
* Full-name : 
* StudentID: 
*
*/

public class Main {
    public static void main(String[] args) {

//        instantiating the scanner class
        Scanner sc = new Scanner(System.in);


//        printing the welcome message
        System.out.printf("-------------------------------"
                + "\n      Welcome to HANGMAN       "
                + "\n-------------------------------");

//        prompting the user to enter the word to guess
        System.out.println("\nOK Guessing Player ... turn around, while your friend enters the word to guess!");
        System.out.print("\nEnter the word to guess: ");
        String hiddenWord = sc.next();

//       checking if the word is greater than 10 characters
        while (hiddenWord.length() >= 10) {
            System.out.println("The word is too long, try again! Word must be less than 10 characters");
            System.out.print("\nEnter the word to guess: ");
            hiddenWord = sc.next();
        }

//        clearing the screen
        for (int i = 0; i <= 20; i++) {
            System.out.print("\n");
        }

//        printing the message to the guessing player
        System.out.println("\nOK, now you can turn around and start guessing!");


//        creating a string of dashes to represent the hidden word
        String guessedWord = "";
        for (int i = 0; i < hiddenWord.length(); i++) {
            guessedWord += "-";
        }

//       creating a string of the alphabet to be used in the game, declaring the guessed letters and guesses left
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String guessedLetters = "";
        int guessesLeft = 10;
        boolean guessed = false;

//        starting the game
        while (!guessed) {
//                    printing the game status
            System.out.println("Word to date: " + guessedWord + " (" + guessesLeft + " guesses left)");
//            checking if the user wants to solve the puzzle
            System.out.println("Want to solve the puzzle? (Y/N)");
            String solve = sc.next();
            if (solve.equalsIgnoreCase("Y")) { // if the user wants to solve the puzzle
                System.out.println("Enter your guess: ");
                String guess = sc.next();
//                checking if the user guessed the word correctly, if not, the number of guesses left is reduced by the number of letters in the guess
                if (guess.equalsIgnoreCase(hiddenWord)) {
                    if (guessesLeft == 10){
                        guessesLeft--;
                    }
                    System.out.printf("---------------------------------------------------- \nCongratulations!!! " +
                            "\nYou guessed the mystery word \"%s\" in %d guesses! " +
                            "\nGoodbye .... " +
                            "\n--------------------------------------------------", hiddenWord, 10 - guessesLeft);
                    guessed = true;
                } else {
                    System.out.println("Incorrect!");
                    int guessLength = guess.length();
                    for (int i = 0; i < guessLength; i++) {
                        guessesLeft--;
                    }
                    for (int i = 0; i < guessLength; i++) {
                        if (!hiddenWord.contains(guess.substring(i, i + 1))) {
                            guessedLetters += guess.substring(i, i + 1);
                        }
                    }
                }
            } else {
//                if the user doesn't want to solve the puzzle, the game continues, printing the letters not guessed and the letters already guessed
                System.out.println("Letters not guessed: " + alphabet.replace(guessedLetters, ""));
                System.out.println("Letters already guessed: " + guessedLetters);
                System.out.println("Enter your guess: ");
                String guess = sc.next();

//                checking if the user entered a letter or more than one letter and if the letter has already been guessed
                while (guessedLetters.contains(guess) || guessedWord.contains(guess) || guess.length() > 1) {
                    System.out.println("You have already guessed this letter!");
                    System.out.println("Enter your guess: ");
                    guess = sc.next();
                }

                guessedLetters += guess;
     //           checking if the hidden word contains the guessed letter withotu case sensitivity
                    if (hiddenWord.toUpperCase().contains(guess.toUpperCase())) {
                        System.out.println("Correct!");
                        for (int i = 0; i < hiddenWord.length(); i++) {
                            if (hiddenWord.substring(i, i + 1).equalsIgnoreCase(guess)) {
                                guessedWord = guessedWord.substring(0, i) + guess + guessedWord.substring(i + 1);
                            }
                        }
                        guessesLeft--;
                    } else {
                        System.out.println("Incorrect!");
                        guessesLeft--;
                    }

            }
//            checking if the user guessed the word correctly or if the user ran out of guesses
            if (guessedWord.equalsIgnoreCase(hiddenWord)) {
                System.out.printf("---------------------------------------------------- \nCongratulations!!! " +
                        "\nYou guessed the mystery word \"%s\" in %d guesses! " +
                        "\nGoodbye .... " +
                        "\n--------------------------------------------------", hiddenWord, 10 - guessesLeft);
                guessed = true;
            }
            if (guessesLeft == 0) {
                System.out.printf("---------------------------------------------------- " +
                        "\nSorry, you have run out of guesses! " +
                        "\nThe mystery word was \"%s\" " +
                        "\nGoodbye .... " +
                        "\n--------------------------------------------------", hiddenWord);
                guessed = true;
            }
        }
//        closing the scanner
        sc.close();
//        exiting the program
        System.exit(0);
    }
}


