package task2;

import java.util.Scanner;

/**
 * Game Controller
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Consist whole game logic
     */
    public void processGame() {
        view.printMessage(View.WELCOME_MESSAGE);

        int numOfTurns = 0;
        Scanner sc = new Scanner(System.in);
        /* Game loop */
        while (true) {
            view.printMessage(View.INP_INT);

            /* Handle non-integer input */
            while (!sc.hasNextInt()) {
                view.printMessage(View.WRONG_INP);
                sc.next();
            }
            int userTurn = sc.nextInt();

            /* Handle incorrect input */
            if (!isInBounds(userTurn)) {
                view.printCurrBounds(model.getCurrentLowerBound(), model.getCurrentUpperBound());
                continue;
            } else if (model.getPreviousTurns().contains(userTurn)) {
                view.printMessage(View.REPEATED_NUMBER);
                continue;
            }

            /* Successful user turn, consider, what to do next */
            numOfTurns++;
            model.addTurn(userTurn);
            /* If user guessed number */
            if (model.getNumber() == userTurn) {
                view.printSuccessMessage(userTurn, numOfTurns, model.getPreviousTurns());
                break;
            } else {  /* Correct bounds of guessing for user */
                if (model.getNumber() > userTurn) {
                    view.printMessage(View.GREATER_THAN, userTurn);
                    model.setCurrentLowerBound(userTurn);
                } else {
                    view.printMessage(View.LESS_THAN, userTurn);
                    model.setCurrentUpperBound(userTurn);
                }
                view.printCurrBounds(model.getCurrentLowerBound(), model.getCurrentUpperBound());
                view.printPreviousTurns(model.getPreviousTurns());
            }

        }
    }

    /**
     * Check if number in current guessing bounds
     * @param num, inputted by user
     * @return
     */
    private boolean isInBounds(int num) {
        return num >= model.getCurrentLowerBound() && num <= model.getCurrentUpperBound();
    }

    public static String getHello() { return "Hello"; }
}
