package dev.lpa.burguer;

public class Meal {
    //Attributes for Meal class

    private double base = 5.0;
    private Item burguer;
    private Item drink;
    private Item side;

    public Meal() {
        burguer = new Item("regular", "burguer");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 1.0);
    }
    private class Item {
        //Attributes for Item class
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burguer") ? base : 0);
        }
        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, price);
        }
    }
}

