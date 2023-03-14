import java.util.*;

/*
 * Fullname: 
 * StudentID: 
 */
public class Hangman2 {
    public static void main(String[] args) {
//        defining the scanner object
        Scanner scanner = new Scanner(System.in);

//        print the welcome message
        System.out.println("-------------------------------");
        System.out.println(" Welcome to HANGMAN2 ");
        System.out.println("-------------------------------");
        System.out.println("OK Guessing Player ... turn around, while your friend enters the word to guess!");
        System.out.print("Other Player - Enter your word (up to 10 letters only, not case sensitive): ");

//        checking that the word contains only letters and no numbers and no more than 10 letters and no special characters
        while (!scanner.hasNext("[a-zA-Z]{1,10}")) {
            System.out.println("Invalid input. Please enter a word with no more than 10 letters.");
            System.out.print("Other Player - Enter your word (up to 10 letters only, not case sensitive): ");
            char[] wordToGuess = scanner.nextLine().toLowerCase().toCharArray();
        }

//        get the word to guess from the user
        char[] wordToGuess = scanner.nextLine().toLowerCase().toCharArray();

//        clear the screen
        System.out.println("\n".repeat(20));

//        replace the letters with asterisks for the guessing player
        char[] guessedWord = new char[wordToGuess.length];
        Arrays.fill(guessedWord, '*');

//        times the user can guess
        int numGuessesLeft = 10;

//        array of letters not guessed
        char[] lettersNotGuessed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().toCharArray();

//        loop until the user guesses the word or runs out of guesses
        while (numGuessesLeft > 0 && !Arrays.equals(guessedWord, wordToGuess)) {

//            Ask the user if they want to guess the word or a letter
            System.out.printf("Word to date: %s (%d guess(es) left)%n", new String(guessedWord), numGuessesLeft);
            System.out.print("Want to solve the puzzle? Enter \"Y\" to solve the puzzle, or \"N\" to guess a character: ");
            String choice = scanner.next();

//            if the user wants to guess the word
            if (choice.equalsIgnoreCase("Y")) {
                System.out.print("Enter your guess for the whole word: ");
                String guess = scanner.next().toLowerCase();
                if (guess.equals(new String(wordToGuess))) {
                    guessedWord = wordToGuess;
                } else {
                    numGuessesLeft--;
                }

//                if the user wants to guess a letter
            } else {
                System.out.printf("Letters to try: %s%n", new String(lettersNotGuessed));
                char guess = ' ';
                do {
                    System.out.print("Which letter should I check for? ");
                    guess = scanner.next().charAt(0);
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
            System.out.printf("""
                    -------------------------------
                    Congratulations! \nYou found the word "%s" with %d guess(es) left.%n
                    \n-------------------------------""", new String(wordToGuess), numGuessesLeft);
        } else {
            System.out.printf("""
                    -------------------------------
                    Sorry, you didn't find the word "%s". \nBetter luck next time!%n
                    \n-------------------------------""", new String(wordToGuess));
        }
    }


    /**
     * Checks if the letter has already been guessed
     *
     * @param guesses the array of letters guessed
     * @param letter  the letter to check
     * @return the index of the letter in the array if it has been guessed, -1 otherwise
     */

    private static int guessesContainLetter(char[] guesses, char letter) {
        for (int i = 0; i < guesses.length; i++) {
            if (guesses[i] == letter) {
                return i;
            }
        }

//        if the letter has been guessed, or it is not a letter
        System.out.printf("--> Not a valid request - either not a letter or already guessed.%n");
        return -1;
    }
}
