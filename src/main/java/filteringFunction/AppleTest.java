package filteringFunction;

import java.util.ArrayList;
import java.util.List;

public class AppleTest {
    public static void main(String[] args) {
        Apple apple1 = new Apple(120,Color.RED);
        Apple apple2 = new Apple(150,Color.GREEN);
        Apple apple3 = new Apple(170,Color.YELLOW);
        Apple apple4 = new Apple(180,Color.RED);
        Apple apple5 = new Apple(90,Color.GREEN);
        Apple apple6 = new Apple(80,Color.RED);
        Apple apple7 = new Apple(110,Color.RED);

        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
        inventory.add(apple4);
        inventory.add(apple5);
        inventory.add(apple6);
        inventory.add(apple7);

        List<Apple> applesGreen = FilteringFactory.filter(inventory, new AppleGreenFilter());
        List<Apple> applesHeavy = FilteringFactory.filter(inventory, new AppleHeavyWeightPredicate());
        List<Apple> applesHeavyRed = FilteringFactory.filter(inventory, new AppleHeavyRedPredicate());

        System.out.println("inventory = " + inventory);
        System.out.println();
        System.out.println("applesGreen = " + applesGreen);
        System.out.println();
        System.out.println("applesHeavy = " + applesHeavy);
        System.out.println();
        System.out.println("applesHeavyRed = " + applesHeavyRed);

        FilteringFactory.prettyPrintMethod(inventory, new PrintGreen());
        FilteringFactory.prettyPrintMethod(inventory, new PrintHeavy());

    }
}
