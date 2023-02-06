package filteringFunction;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean Test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
