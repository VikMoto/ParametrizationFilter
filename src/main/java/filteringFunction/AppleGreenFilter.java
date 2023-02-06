package filteringFunction;

import static filteringFunction.Color.GREEN;

public class AppleGreenFilter implements ApplePredicate{
    @Override
    public boolean Test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
