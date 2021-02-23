package com.github.alexduch.coffeemachine.drinkmaker;

public class DisplayMissingAmountCommand extends DisplayMessageCommand {

  private static final String MESSAGE_TEMPLATE = "missing %.2f €";

  public DisplayMissingAmountCommand(double missingAmount) {
    super(String.format(MESSAGE_TEMPLATE, missingAmount));
  }
}
