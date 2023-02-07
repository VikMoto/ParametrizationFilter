package filteringFunction;

public class PrintWeightAll implements AppleGet {
    @Override
    public String  getApple(Apple apple) {
        return String.valueOf(apple.getWeight());
    }
}

