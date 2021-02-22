package com.github.alexduch.coffeemachine;

public class Order {

  public final Drink drink;
  public final Sugar sugar;
  public final double moneyInserted;

  public Order(Drink drink, double moneyInserted) {
    this(drink, Sugar.NONE, moneyInserted);
  }

  public Order(Drink drink, Sugar sugar, double moneyInserted) {
    this.drink = drink;
    this.sugar = sugar;
    this.moneyInserted = moneyInserted;
  }

  public enum Drink {
    TEA("T", 0.4),
    COFFEE("C", 0.6),
    CHOCOLATE("H", 0.5);

    public final String id;
    public final double price;

    Drink(String id, double price) {
      this.id = id;
      this.price = price;
    }
  }

  public enum Sugar {
    NONE,
    ONE,
    TWO
  }
}
