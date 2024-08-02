package dev.lpa.burguer;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    //Attributes for Meal class

    private double price = 5.0;
    private Burguer burguer;
    private Item drink;
    private Item side;

    private double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burguer = new Burguer("regular");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }

    public double getTotal(){
        double total = burguer.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burguer, drink, side
        , "Total Due: ", getTotal());
    }

    public void addToppings(String... selectedToppings) {
        burguer.addToppings(selectedToppings);
    }

    private class Item {
        //Attributes for Item class
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burguer") ? Meal.this.price : 0);
        }
        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,
                    getPrice(price, conversionRate));
        }
        private static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

    private class Burguer extends Item {

        private enum Extra {AVOCADO, BACON, CHEESE, KETCHUP, MAYO, MUSTARD, PICKLES;

            private double getPrice(){
                return switch (this) {
                    case AVOCADO -> 1.0;
                    case BACON, CHEESE -> 1.5;
                    default -> 0;
                };
            }
        }
        private List<Item> toppings = new ArrayList<>();
        Burguer(String name) {
            super(name, "burguer", 5.0);
        }

        public double getPrice(){
            double total = super.price;
            for (Item topping : toppings) {
                total += topping.price;
            }
            return total;
        }

        private void addToppings(String... selectedToppings){
            for (String selectedTopping : selectedToppings){
                try {
                    Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
                    toppings.add(new Item(topping.name(),
                            "TOPPING", topping.getPrice()));
                } catch(IllegalArgumentException e){
                    System.out.println("No topping found for " + selectedTopping);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder itemized = new StringBuilder(super.toString());
            for (Item topping : toppings) {
                itemized.append("\n");
                itemized.append(topping);
            }
            return itemized.toString();
        }
    }
}

