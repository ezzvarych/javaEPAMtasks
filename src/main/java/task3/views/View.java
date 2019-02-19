package task3.views;

import java.util.List;

public class View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printList(List list) {
        for (Object o: list) {
            System.out.println(o);
        }
    }

    public void printWrongInput() {
        System.err.println(TextConstants.WRONG_INPUT);
    }

    public void printWrongInput(String message) {
        System.err.println(message);
    }
}
