package filteringFunction;

import static filteringFunction.Color.RED;

public class AppleHeavyRedPredicate implements ApplePredicate{
    @Override
    public boolean Test(Apple apple) {
        return apple.getWeight() > 150 && RED.equals(apple.getColor());
    }
}
