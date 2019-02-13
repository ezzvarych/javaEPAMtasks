package task3;

import task3.controllers.Controller;
import task3.models.RecordBook;
import task3.views.View;

public class Main {

    public static void main(String[] args) {

        new Controller(new RecordBook(), new View()).processUser();
    }
}
