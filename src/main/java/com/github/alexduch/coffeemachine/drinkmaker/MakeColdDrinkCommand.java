package com.github.alexduch.coffeemachine.drinkmaker;

import com.github.alexduch.coffeemachine.Order.Drink;

public class MakeColdDrinkCommand extends AbstractDrinkMakerCommand {

  MakeColdDrinkCommand(Drink drink) {
    super(drink.id);
  }

  @Override
  protected String commandParameters() {
    return ":";
  }
}
