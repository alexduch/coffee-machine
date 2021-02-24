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
    TEA("T", 0.4),
    COFFEE("C", 0.6),
    CHOCOLATE("H", 0.5),
    ORANGE_JUICE("O", 0.6, false);

    public final String id;
    public final double price;
    public final boolean isHotDrink;

    Drink(String id, double price) {
      this(id, price, true);
    }

    Drink(String id, double price, boolean isHotDrink) {
      this.id = id;
      this.price = price;
      this.isHotDrink = isHotDrink;
    }
  }

  public enum Sugar {
    NONE,
    ONE,
    TWO
  }
}
