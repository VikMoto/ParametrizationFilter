package filteringFunction;

import static filteringFunction.Color.GREEN;

public class PrintApple implements AppleGet{
    @Override
    public String getApple(Apple apple) {
      return "An apple of " + apple.getWeight() + " g";
    }
}
