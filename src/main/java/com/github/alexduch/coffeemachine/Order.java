package com.github.alexduch.coffeemachine;

public class Order {

  public final Drink drink;
  public final Sugar sugar;

  public Order(Drink drink) {
    this(drink, Sugar.NONE);
  }

  public Order(Drink drink, Sugar sugar) {
    this.drink = drink;
    this.sugar = sugar;
  }

  public enum Drink {
    TEA("T"),
    COFFEE("C"),
    CHOCOLATE("H");

    public final String id;

    Drink(String id) {
      this.id = id;
    }
  }

  public enum Sugar {
    NONE,
    ONE,
    TWO
  }
}
