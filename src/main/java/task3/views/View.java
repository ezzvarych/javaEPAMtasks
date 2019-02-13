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
        System.out.println(TextConstants.WRONG_INPUT);
    }
}
