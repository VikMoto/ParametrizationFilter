package filteringFunction;

public class PrintHeavy implements AppleGet {

    @Override
    public void getApple(Apple apple) {
        if (apple.getWeight() > 150) {
            System.out.println("apple.getWeight() = " + apple.getWeight());
        }
    }
}
