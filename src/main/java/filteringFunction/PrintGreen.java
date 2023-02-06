package filteringFunction;

import static filteringFunction.Color.GREEN;

public class PrintGreen implements AppleGet{
    @Override
    public void getApple(Apple apple) {
        String result = "";
        if (GREEN.equals(apple.getColor())){
            result = String.valueOf(apple.getColor());
            System.out.println(apple.getColor());
        }

    }
}
