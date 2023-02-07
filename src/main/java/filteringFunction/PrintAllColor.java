package filteringFunction;

public class PrintAllColor implements AppleGet{
    @Override
    public String getApple(Apple apple) {
        return String.valueOf(apple.getColor());
    }
}
