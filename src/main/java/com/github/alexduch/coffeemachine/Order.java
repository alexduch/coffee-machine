package com.github.alexduch.coffeemachine;

public class Order {

  public final Drink drink;

  public Order(Drink drink) {
    this.drink = drink;
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
}
