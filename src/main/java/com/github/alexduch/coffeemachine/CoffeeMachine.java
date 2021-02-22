package com.github.alexduch.coffeemachine;

public class CoffeeMachine {

  public String translate(Order order) {
    return new StringBuilder(order.drink.id)
        .append(":")
        .append(":")
        .toString();
  }
}
