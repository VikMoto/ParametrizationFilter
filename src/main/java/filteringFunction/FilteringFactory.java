package filteringFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    public static <T> List<T> filter(List<T> elements, Predicate<T> predicate){

        List<T> result = new ArrayList<>();
        for (T element : elements) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void prettyPrintMethod(List<Apple> appleList,AppleGet getApple ){
        StringBuilder result = new StringBuilder();
        for (Apple apple : appleList) {
            System.out.println(getApple.getApple(apple));
        }
//        return String.valueOf(result);
    }
}
