package task2;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    //Number to guess
    private int number;

    private List<Integer> previousTurns;
    private int currentLowerBound;
    private int currentUpperBound;

    public Model() {
        number = new Random().nextInt(101);
        previousTurns = new ArrayList<Integer>();
        currentLowerBound = 0;
        currentUpperBound = 100;
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
