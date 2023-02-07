package filteringFunction;

public class PrintWeight implements AppleGet {

    @Override
    public String getApple(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy":"light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
