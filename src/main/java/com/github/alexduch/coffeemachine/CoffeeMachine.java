package com.github.alexduch.coffeemachine;

import com.github.alexduch.coffeemachine.drinkmaker.MakeDrinkCommand;

public class CoffeeMachine {

  public String translate(Order order) {
    return new MakeDrinkCommand(order.drink, order.sugar).toString();
  }
}
