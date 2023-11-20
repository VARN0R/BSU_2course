package laba1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Breakfast {
    private final List<Food> array;

    public Breakfast() {
        array = new ArrayList<>();
    }


    public void add(Food meal) {
        array.add(meal);

    }

    public void calc(Food meal) {
        int count = 0;
        for (Food value : array) {
            if (value.equals(meal)) {
                count++;
            }
        }
        System.out.println("Количество продукта '" + meal + "' в завтраке: " + count);
    }

    public void calcAllCalories() {
        int totalCalories = 0;
        for (Food value : array) {
            totalCalories+=value.calcCalories();
        }
        System.out.println("Калорий в завтраке: " + totalCalories);
    }

    public void sort() {
        array.sort(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.calcCalories(), o2.calcCalories());
            }
        });
    }

    @Override
    public String toString() {
        return "Завтрак состоит из: " +
                 array;
    }
}
