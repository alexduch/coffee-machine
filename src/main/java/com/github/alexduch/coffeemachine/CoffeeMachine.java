package com.github.alexduch.coffeemachine;

import com.github.alexduch.coffeemachine.drinkmaker.AbstractDrinkMakerCommand;
import com.github.alexduch.coffeemachine.drinkmaker.DisplayMissingAmountCommand;
import com.github.alexduch.coffeemachine.drinkmaker.MakeDrinkCommand;

public class CoffeeMachine {

  public String buy(Order order) {
    AbstractDrinkMakerCommand command;
    double missingAmount = order.drink.price - order.moneyInserted;
    if (missingAmount > 0) {
      command = new DisplayMissingAmountCommand(missingAmount);
    } else {
      command = new MakeDrinkCommand(order.drink, order.sugar);
    }
    return command.toString();
  }
}
