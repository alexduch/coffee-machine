package com.github.alexduch.coffeemachine;

public class Order {

  public final Drink drink;
  public final Sugar sugar;
  public final boolean extraHot;
  public final double moneyInserted;

  public Order(Drink drink, double moneyInserted) {
    this(drink, Sugar.NONE, moneyInserted);
  }

  public Order(Drink drink, Sugar sugar, double moneyInserted) {
    this(drink, sugar, false, moneyInserted);
  }

  public Order(Drink drink, Sugar sugar, boolean extraHot, double moneyInserted) {
    this.drink = drink;
    this.sugar = sugar;
    this.extraHot = extraHot;
    this.moneyInserted = moneyInserted;
  }

  public enum Drink {
    TEA("T", "Tea", 0.4, "water"),
    COFFEE("C", "Coffee", 0.6, "water"),
    CHOCOLATE("H", "Chocolate", 0.5, "milk"),
    ORANGE_JUICE("O", "Orange juice", 0.6, false);

    public final String id;
    public final String displayName;
    public final double price;
    public final boolean isHotDrink;
    public final String[] ingredients;

    Drink(String id, String displayName, double price, String... ingredients) {
      this(id, displayName, price, true, ingredients);
    }

    Drink(String id, String displayName, double price, boolean isHotDrink,
        String... ingredients) {
      this.id = id;
      this.displayName = displayName;
      this.price = price;
      this.isHotDrink = isHotDrink;
      this.ingredients = ingredients;
    }
  }

  public enum Sugar {
    NONE,
    ONE,
    TWO
  }
}
