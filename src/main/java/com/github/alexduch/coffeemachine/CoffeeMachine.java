package com.github.alexduch.coffeemachine;

import com.github.alexduch.coffeemachine.drinkmaker.AbstractDrinkMakerCommand;
import com.github.alexduch.coffeemachine.drinkmaker.DisplayMissingAmountCommand;
import com.github.alexduch.coffeemachine.drinkmaker.MakeDrinkCommandBuilder;

public class CoffeeMachine {

  public String buy(Order order) {
    AbstractDrinkMakerCommand command;
    double missingAmount = order.drink.price - order.moneyInserted;
    if (missingAmount > 0) {
      command = new DisplayMissingAmountCommand(missingAmount);
    } else {
      command = MakeDrinkCommandBuilder.forDrink(order.drink)
          .with(order.sugar)
          .extraHot(order.extraHot)
          .build();
    }
    return command.toString();
  }
}
