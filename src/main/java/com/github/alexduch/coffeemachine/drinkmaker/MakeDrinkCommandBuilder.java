package com.github.alexduch.coffeemachine.drinkmaker;

import com.github.alexduch.coffeemachine.Order.Drink;
import com.github.alexduch.coffeemachine.Order.Sugar;

public class MakeDrinkCommandBuilder {

  private final Drink drink;

  private Sugar sugar = Sugar.NONE;
  private boolean extraHot;

  private MakeDrinkCommandBuilder(Drink drink) {
    this.drink = drink;
  }

  public static MakeDrinkCommandBuilder forDrink(Drink drink) {
    return new MakeDrinkCommandBuilder(drink);
  }

  public MakeDrinkCommandBuilder with(Sugar sugar) {
    this.sugar = sugar;
    return this;
  }

  public MakeDrinkCommandBuilder extraHot(boolean extraHot) {
    this.extraHot = extraHot;
    return this;
  }

  public AbstractDrinkMakerCommand build() {
    return drink.isHotDrink ? new MakeHotDrinkCommand(drink, sugar, extraHot) : new MakeColdDrinkCommand(drink);
  }
}
