package com.github.alexduch.coffeemachine;

import com.github.alexduch.coffeemachine.drinkmaker.AbstractDrinkMakerCommand;
import com.github.alexduch.coffeemachine.drinkmaker.DisplayMissingAmountCommand;
import com.github.alexduch.coffeemachine.drinkmaker.MakeDrinkCommandBuilder;

public class CoffeeMachine {

  public final CoffeeMachineStats stats = new CoffeeMachineStats();

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
      stats.registerSale(order.drink);
    }
    return command.toString();
  }

  public void printSalesReport() {
    System.out.println(stats.report());
  }
}
