package com.github.alexduch.coffeemachine.drinkmaker;

import com.github.alexduch.coffeemachine.Order.Drink;
import com.github.alexduch.coffeemachine.Order.Sugar;

public class MakeDrinkCommand extends AbstractDrinkMakerCommand {

  public final int sugar;

  public MakeDrinkCommand(Drink drink, Sugar sugar) {
    super(drink.id);
    this.sugar = drink.isHotDrink ? sugar.ordinal() : 0;
  }

  @Override
  public String commandParameters() {
    return sugarAndStick();
  }

  private String sugarAndStick() {
    return sugar > 0 ? (sugar + ":0")  : ":";
  }
}
