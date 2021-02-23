package com.github.alexduch.coffeemachine.drinkmaker;

public class DisplayMessageCommand extends AbstractDrinkMakerCommand {

  private final String message;

  public DisplayMessageCommand(String message) {
    super("M");
    this.message = message;
  }

  @Override
  protected String commandParameters() {
    return message;
  }
}
