package Hangman;

import java.util.Scanner;

public class Hangman {
	// Maximum errors
	public static int maxErrors = 7;

	// Error counter
	public static int errorsMade = 0;

	// Previously chosen word
	public static String wordToGuess = "conquistador";

	// String for word guessed.
	public static String wordGuessed = "";

	public static void main(String[] args) {

		// Scanner for input
		Scanner sc = new Scanner(System.in);

		// Creates char array from word to be guessed.
		char[] wordArray = wordToGuess.toCharArray();
		char[] myAnswers = new char[wordArray.length];

		//
		for (int i = 0; i < wordArray.length; i++) {
			myAnswers[i] = '?';
		}

		System.out.println("Welcome to Hangman!\nPlease guess on a letter to start the game.");

		// Loop until game won or lost
		boolean gameFinished = false;
		while (gameFinished == false) {
			System.out.println("********************");

			String input = sc.next();

			// Check in input is valid
			while (input.length() != 1 || Character.isDigit(input.charAt(0))) {
				System.out.println("Invalid input. Please try again.");
				input = sc.next();
			}

			// Check if the char is in the word
			boolean found = false;
			for (int i = 0; i < wordArray.length; i++) {
				if (input.charAt(0) == wordArray[i]) {
					myAnswers[i] = wordArray[i];
					found = true;
				}
			}

			// If the char is not in the word. Removes one of the total mistakes.
			if (!found) {
				maxErrors--;
				System.out.println("The letter is not in the word");
			}

			// Creates _ for correct letters not guessed
			boolean done = true;
			for (int i = 0; i < myAnswers.length; i++) {
				if (myAnswers[i] == '?') {
					System.out.print(" _");
					done = false;
				} else {
					System.out.print(" " + myAnswers[i]);
				}
			}

			// Shows errors left and uses method to draw
			System.out.println("\n" + "Mistakes left: " + maxErrors);
			drawHangman(maxErrors);
			errorsMade++;

			// Checks if game ends
			if (done) {
				System.out.println("Congrats, you won! The word was " + wordToGuess);
				gameFinished = true;
			}
			if (wordGuessed.length() >= 2) {

				if (wordGuessed.equals(wordToGuess)) {
					System.out.println("Correct! You win! The word was " + wordToGuess);

				}
			}

			if (maxErrors <= 0) {
				System.out.println("You lose!" + "\nThe word was " + wordToGuess + ". Better luck next time!");
				gameFinished = true;
			}
		}
		sc.close();

	}

	public static void drawHangman(int l) {
		if (l == 6) {
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 5) {
			System.out.println("|--------");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 4) {
			System.out.println("|--------");
			System.out.println("|       |");
			System.out.println("|       O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 3) {
			System.out.println("|--------");
			System.out.println("|       |");
			System.out.println("|       O");
			System.out.println("|      /|\\");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 2) {
			System.out.println("|--------");
			System.out.println("|       |");
			System.out.println("|       O");
			System.out.println("|      /|\\");
			System.out.println("|       |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 1) {
			System.out.println("|--------");
			System.out.println("|       |");
			System.out.println("|       O");
			System.out.println("|      /|\\");
			System.out.println("|       |");
			System.out.println("|      /");
			System.out.println("|");
			System.out.println("|");
		} else if (l == 0) {
			System.out.println("|--------");
			System.out.println("|       |");
			System.out.println("|       O");
			System.out.println("|      /|\\");
			System.out.println("|       |");
			System.out.println("|      / \\");
			System.out.println("|");
			System.out.println("|");
		}
	}

	// Method creating a menu and running it. ATTEMPTED.
	public static void printMenu() {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("1) Game status");
		System.out.println("2) Guess char");
		System.out.println("3) Guess word");
		System.out.println("4) Input new word for the game");

		choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("You have " + (errorsMade - maxErrors) + "chances left.");
			break;
		case 2:
			System.out.println("Guess on a letter: ");
			break;
		case 3:
			System.out.println("Guess on a word: ");
			break;
		case 4:
			System.out.println("Input new word for Hangman:");
			break;
		}
		sc.close();
	}

}
