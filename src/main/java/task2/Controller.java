package task2;

import java.util.List;
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

        Scanner sc = new Scanner(System.in);
        model.setNumber();

        /* Game loop */
        while (true) {
            view.printMessage(View.INP_INT);

            int userTurn = inputIntValueWithScanner(sc);

            /* Handle incorrect input */
            if (!model.isInBounds(userTurn)) {
                view.printCurrBounds(model.getCurrentLowerBound(), model.getCurrentUpperBound());
                continue;
            }

            /* Successful user turn, consider, what to do next */
            model.addTurn(userTurn);
            /* If user guessed number */
            if (model.checkNumber(userTurn)) {
                List<Integer> prevTurns = model.getPreviousTurns();
                view.printSuccessMessage(userTurn, prevTurns.size(), prevTurns);
                break;
            }
            view.printCurrBounds(model.getCurrentLowerBound(), model.getCurrentUpperBound());
            view.printPreviousTurns(model.getPreviousTurns());
        }
    }

    /**
     * Handle non-integer input
     * @param sc
     * @return
     */
    private int inputIntValueWithScanner(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(View.WRONG_INP);
            view.printCurrBounds(model.getCurrentLowerBound(), model.getCurrentUpperBound());
            sc.next();
        }
        return sc.nextInt();
    }


}
