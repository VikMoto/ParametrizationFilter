package filteringFunction;

import java.util.ArrayList;
import java.util.List;

public class FilteringFactory {
    public static List<Apple> filter(List<Apple> elements, ApplePredicate predicate){

        List<Apple> result = new ArrayList<>();

        for (Apple element : elements) {
            if (predicate.Test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void prettyPrintMethod(List<Apple> appleList,AppleGet getApple ){
        StringBuilder result = new StringBuilder();
        for (Apple apple : appleList) {
            getApple.getApple(apple);
        }
//        return String.valueOf(result);
    }
}
