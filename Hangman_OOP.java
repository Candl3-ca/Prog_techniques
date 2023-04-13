/*
*
* Fullname : 
* StudentID : 
*
*/

import java.util.*;
public class Hangman {
    // initializing all the variables
    private static int game_id = 0; // game_id as an instance variable
    private char[] wordToGuess;
    private char[] guessedWord;
    private int numGuessesLeft;
    private char[] lettersNotGuessed;
    public Hangman() {
        game_id++; // constructor that increments game_id
    }

    public void initializeGame_collectWord(Scanner keyIn) {
        //       ask the user for the word to guess and print a welcome message
        System.out.println("-------------------------------");
        System.out.printf(" Welcome to HANGMAN %d%n", game_id); // display game_id in dialogue
        System.out.println("-------------------------------");
        System.out.println("OK Guessing Player ... turn around, while your friend enters the word to guess!");
        System.out.print("Other Player - Enter your word (up to 10 letters only, not case sensitive): ");
        //      get the word to guess from the user and setting the condition that the word must be between 1 and 10 letters and not case sensitive
        while (!keyIn.hasNext("[a-zA-Z]{1,10}")) {
            System.out.println("Invalid input. Please enter a word with no more than 10 letters.");
            System.out.print("Other Player - Enter your word (up to 10 letters only, not case sensitive): ");
            wordToGuess = keyIn.nextLine().toLowerCase().toCharArray();
        }
        wordToGuess = keyIn.nextLine().toLowerCase().toCharArray();
        System.out.println("\n".repeat(20));
    }



    public void playGame(Scanner keyIn) {
//        replace the letters with asterisks for the guessing player
        guessedWord = new char[wordToGuess.length];
        Arrays.fill(guessedWord, '*');

//        times the user can guess
        numGuessesLeft = 10;

//        array of letters not guessed
        lettersNotGuessed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().toCharArray();

//        loop until the user guesses the word or runs out of guesses
        while (numGuessesLeft > 0 && !Arrays.equals(guessedWord, wordToGuess)) {

//            Ask the user if they want to guess the word or a letter
            System.out.printf("GameID " + game_id + ": " + "Word to date: %s (%d guess(es) left)%n", new String(guessedWord), numGuessesLeft);
            System.out.print("GameID " + game_id + ": " + "Want to solve the puzzle? Enter \"Y\" to solve the puzzle, or \"N\" to guess a character: ");
            String choice = keyIn.next();

//            if the user wants to guess the word, ask them for the word and check if it's correct
            if (choice.equalsIgnoreCase("Y")) {
                System.out.print("GameID " + game_id + ": " + "Enter your guess for the whole word: ");
                String guess = keyIn.next().toLowerCase();
                if (guess.equals(new String(wordToGuess))) {
                    guessedWord = wordToGuess;
                } else {
                    numGuessesLeft--;
                }

//                if the user wants to guess a letter, ask them which letter they want to guess and check if it's in the word
            } else {
                System.out.printf("GameID " + game_id + ": " + "Letters to try: %s%n", new String(lettersNotGuessed));
                char guess = ' ';
                do {
                    System.out.print("GameID " + game_id + ": " + "Which letter should I check for? ");
                    guess = keyIn.next().charAt(0);
                } while (guessesContainLetter(lettersNotGuessed, guess) == -1);
                lettersNotGuessed[guessesContainLetter(lettersNotGuessed, guess)] = '*';
                boolean foundLetter = false;
                for (int i = 0; i < wordToGuess.length; i++) {
                    if (guess == wordToGuess[i]) {
                        guessedWord[i] = guess;
                        foundLetter = true;
                    }
                }
                if (!foundLetter) {
                    numGuessesLeft--;
                }
            }
            System.out.println();
        }

//        print the result of the game
        if (Arrays.equals(guessedWord, wordToGuess)) {
            // print the word that the user guessed
            System.out.printf("GameID " + game_id + ": " + """
                    -------------------------------
                    Congratulations! \nYou found the word "%s" with %d guess(es) left.%n
                    \n-------------------------------""", new String(wordToGuess), numGuessesLeft);
        } else {
            // print the word that the user didn't guess
            System.out.printf("GameID " + game_id + ": " +  """
                    -------------------------------
                    Sorry, you didn't find the word "%s". \nBetter luck next time!%n
                    \n-------------------------------""", new String(wordToGuess));
        }
    }

    // Helper method to check if a letter is already guessed
    private int guessesContainLetter(char[] lettersNotGuessed, char guess) {
        for (int i = 0; i < lettersNotGuessed.length; i++) {
            if (lettersNotGuessed[i] == guess) {
                return i;
            }
        }
        return -1;
    }
}

class Driver {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

//        create a new game and play it
        Hangman game = new Hangman();
        game.initializeGame_collectWord(key);
        game.playGame(key);

//       ask the user if they want to play again
        System.out.println("\nWould you like to play again? Enter \"Y\" to play again, or \"N\" to quit: ");
        String playAgain;
        playAgain = key.next();

        // while loop to play the game again if the user wants to, it'll keep playing until the user enters "N" or "n"
         while (playAgain.equalsIgnoreCase("y")){
                Scanner sc = new Scanner(System.in);
                Hangman game1 = new Hangman();
                game1.initializeGame_collectWord(sc);
                game1.playGame(sc);

                // ask the user if they want to play again
                System.out.println("\nWould you like to play again? Enter \"Y\" to play again, or \"N\" to quit: ");
                playAgain = key.next();
         }

         // exiting the game and closing the scanner object and the program
        System.out.println("Thanks for playing! Goodbye.");
        key.close();
         System.exit(0);

    }
}
