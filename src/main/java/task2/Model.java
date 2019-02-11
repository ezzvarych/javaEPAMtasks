package task2;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    //Number to guess
    private int number;

    private List<Integer> previousTurns = new ArrayList<>();
    private int currentLowerBound = 0;
    private int currentUpperBound = 100;

    public void setNumber() {
        number = new Random().nextInt(currentUpperBound - 1);
    }

    /**
     * Check if number in current guessing bounds
     * @param userTurn, inputted by user
     * @return
     */
    public boolean isInBounds(int userTurn) {
        return userTurn >= currentLowerBound && userTurn <= currentUpperBound;
    }

    /**
     * End game if number is guessed, fix bounds if not
     * @param userTurn
     * @return
     */
    public boolean checkNumber(int userTurn) {
        if (userTurn == number) {
            return true;
        } else {
            if (userTurn <= number) {
                currentLowerBound = userTurn;
            } else if (userTurn >= number) {
                currentUpperBound = userTurn;
            }
        }
        return false;
    }

    public int getNumber() {
        return number;
    }

    public void addTurn(int turn) {
        previousTurns.add(turn);
    }

    public List<Integer> getPreviousTurns() {
        return previousTurns;
    }

    public void setCurrentLowerBound(int currentLowerBound) {
        this.currentLowerBound = currentLowerBound;
    }

    public int getCurrentLowerBound() {
        return currentLowerBound;
    }

    public void setCurrentUpperBound(int currentUpperBound) {
        this.currentUpperBound = currentUpperBound;
    }

    public int getCurrentUpperBound() {
        return currentUpperBound;
    }
}
