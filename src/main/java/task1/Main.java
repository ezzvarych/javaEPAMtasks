package task1;

/*      1. Написать программу, которая получает из командной строки сначала слово “Hello”, потом
        слово “world!”. Другие вводы игнорировать с соответствующим комментарием в
        командной строке.
        2. Из этих слов собирается предложение и выводится на экран.
        3. Должен быть применен паттерн MVC. */

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model, view);
        controller.process();
        //System.out.println("Hello Java");
    }
}