package task1;

public class Model {
    private String greeting;
    private final String[] greetingParts = {"hello", "world"};

    public void setGreeting(String greeting) {
       this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public String[] getGreetingParts() {
        return greetingParts;
    }
}
