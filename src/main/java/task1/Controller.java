package task1;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        Scanner sc = new Scanner(System.in);
        model.setGreeting(inputGreetingWithScanner(sc));
        view.printMessage(View.OUT_STR, model.getGreeting());
    }

    public String inputGreetingWithScanner(Scanner sc) {
        infiniteLoop:
        for (;;) {
            String[] inputArray = new String[model.getGreetingParts().length];
            for (int i = 0; i < model.getGreetingParts().length; i++) {
                view.printMessage(View.INPUT_STR_DATA);
                inputArray[i] = sc.nextLine();
                if (!inputArray[i].equalsIgnoreCase(model.getGreetingParts()[i])) {
                    view.printMessage(View.WRONG_INPUT_STR_DATA);
                    continue infiniteLoop;
                }
            }
            return String.join(" ", inputArray);
        }
    }

}
