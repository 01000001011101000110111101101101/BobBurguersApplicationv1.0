package dev.lpa;

import dev.lpa.burguer.Meal;

public class Store {
    public static void main(String[] args) {
        Meal regularMeal = new Meal();
        System.out.println(regularMeal);

        Meal NYRegularMeal = new Meal(0.79);
        System.out.println(NYRegularMeal);
    }
}
