package filteringFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

import static filteringFunction.Color.*;
import static filteringFunction.Color.GREEN;
import static filteringFunction.Taste.*;
import static java.util.Comparator.*;

public class GrapeTest {
    public static void main(String[] args) {

        List<Integer> weights = Arrays.asList(170, 195, 250, 180, 120);
        List<Color> colors = Arrays.asList(RED,YELLOW,GREEN,GREEN,DARKBLUE);
        List<Taste> tastes = Arrays.asList(SWEET, SOUR, TART, SWEET, TART);

        List<Grape> grapeList = map(colors, weights, tastes, Grape::new);


        for (Grape grape : grapeList) {
            System.out.println(grape);
        }
//        grapeList.sort((a,b) -> a.getTaste().compareTo(b.getTaste()));

        grapeList.sort(comparing(Grape::getTaste).reversed().thenComparing(Grape::getWeight));
        System.out.println("***********************");
        for (Grape grape : grapeList) {
            System.out.println(grape);
        }
    }

    private static List<Grape> map(List<Color> colors, List<Integer> weights, List<Taste> tastes, TriFunction<Integer,Color, Taste, Grape> function) {
        List<Grape> result = new ArrayList<>();

        for (int i = 0; i < weights.size(); i++) {
            result.add(function.apply(weights.get(i), colors.get(i), tastes.get(i)));
        }
        return result;
    }
}
