package filteringFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

import static filteringFunction.Color.*;
import static filteringFunction.FilteringFactory.*;
import static filteringFunction.FilteringFactory.filter;

public class AppleTest {
    public static void main(String[] args) {
        Apple apple1 = new Apple(120, RED);
        Apple apple2 = new Apple(150,Color.GREEN);
        Apple apple3 = new Apple(170,Color.YELLOW);
        Apple apple4 = new Apple(180, RED);
        Apple apple5 = new Apple(90,Color.GREEN);
        Apple apple6 = new Apple(80, RED);
        Apple apple7 = new Apple(110, RED);

        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
        inventory.add(apple4);
        inventory.add(apple5);
        inventory.add(apple6);
        inventory.add(apple7);

        List<Apple> applesGreen = filter(inventory, new AppleGreenFilter());
        List<Apple> applesHeavy = filter(inventory, new AppleHeavyWeightPredicate());
        List<Apple> applesHeavyRed = filter(inventory, new AppleHeavyRedPredicate());
        List<Apple> applesLight = filter(inventory, new ApplePredicate() {
            @Override
            public boolean Test(Apple apple) {
                return apple.getWeight() < 150;
            }
        });

        List<Apple> applesRed = filter(inventory, (Apple a) -> RED.equals(a.getColor()));

        System.out.println("inventory = " + inventory);
        System.out.println();
        System.out.println("applesGreen = " + applesGreen);
        System.out.println();
        System.out.println("applesHeavy = " + applesHeavy);
        System.out.println();
        System.out.println("applesHeavyRed = " + applesHeavyRed);
        System.out.println();
        System.out.println("applesLight = " + applesLight);
        System.out.println();
        System.out.println("applesRed = " + applesRed);
        System.out.println();

//        FilteringFactory.prettyPrintMethod(inventory, new PrintGreen());
        prettyPrintMethod(inventory, new PrintWeight());
        prettyPrintMethod(inventory, new PrintWeightAll());
        prettyPrintMethod(inventory, new PrintAllColor());
        prettyPrintMethod(inventory, new PrintAllColor());
        System.out.println();
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        System.out.println("inventory = " + inventory);
        System.out.println();
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        System.out.println("inventory = " + inventory);

        List<Apple> list = filter(inventory,
                   AppleTest::TestRedColor);
        System.out.println("list = " + list);


/**      ********************************************************************************
 *
 *
 *                         method reference in constructor!!!!!!
 *
 *
 *       *********************************************************************************
 * */

        List<Integer> weights = Arrays.asList(70, 95, 150, 180);
        List<Color> colors = Arrays.asList(RED,YELLOW,GREEN,GREEN);
        List<Apple> appleList = map(colors, weights,Apple::new);
        System.out.println("---------------------------------------------");
        System.out.println("appleList = " + appleList);


    }

    private static List<Apple> map(List<Color> colors, List<Integer> weights, BiFunction<Integer,Color, Apple> function) {
        List<Apple> result = new ArrayList<>();

        for (int i = 0; i < weights.size(); i++) {
            result.add(function.apply(weights.get(i), colors.get(i)));
        }
        return result;
    }

    private static boolean TestRedColor(Apple a) {
        return a.getColor().equals(RED);
    }
}
