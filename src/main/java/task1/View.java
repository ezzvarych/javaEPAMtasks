package task1;

public class View {
    public static final String INPUT_STR_DATA = "Input string: ";
    public static final String WRONG_INPUT_STR_DATA = "Wrong input, first input should be 'hello', second - 'world'";
    public static final String OUT_STR = "Your string: ";

    public void printMessage(String ...messages) {
        for (String str : messages) {
            System.out.print(str);
        }
        System.out.println();
    }
}
