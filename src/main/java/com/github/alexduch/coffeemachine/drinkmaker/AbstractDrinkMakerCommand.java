package com.github.alexduch.coffeemachine.drinkmaker;

public abstract class AbstractDrinkMakerCommand {

  private final String type;

  AbstractDrinkMakerCommand(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type + ":" + commandParameters();
  }

  protected abstract String commandParameters();
}
