package task2;

import java.util.List;

public class View {
    public static final String WELCOME_MESSAGE = "Welcome! We guessed a number between 0 and 100. Figure it out!";
    public static final String INP_INT = "Input your number: ";
    public static final String WRONG_INP = "Please, input integer number in current bounds!";
    public static final String CURR_BOUNDS = "Current bounds are %d and %d";
    public static final String PREV_TURNS = "Your previous turns were: ";

    /**
     * Print basic messages as greeting and start of new user turn
     * @param message
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Print GREATER_THAN and LESS_THAN patterns for current user turn
     * @param message
     * @param num
     */
    public void printMessage(String message, int num) {
        System.out.printf(message, num);
        System.out.println();
    }

    /**
     * Print current bounds of guessing for user
     * @param lowerBound
     * @param upperBound
     */
    public void printCurrBounds(int lowerBound, int upperBound) {
        System.out.printf(CURR_BOUNDS, lowerBound, upperBound);
        System.out.println();
    }

    /**
     * Print previous user turns
     * @param previousTurns - list of previous turns
     */
    public void printPreviousTurns(List<Integer> previousTurns) {
        System.out.print(PREV_TURNS);
        for (int turn : previousTurns) {
            System.out.print(turn + " ");
        }
        System.out.println();
    }

    /**
     * After user guessed the number
     * @param number
     * @param numOfTurns
     * @param previousTurns
     */
    public void printSuccessMessage(int number, int numOfTurns, List<Integer> previousTurns) {
        System.out.println("Greeting! You guessed number " + number + " from " + numOfTurns + " turns");
        printPreviousTurns(previousTurns);
    }
}
