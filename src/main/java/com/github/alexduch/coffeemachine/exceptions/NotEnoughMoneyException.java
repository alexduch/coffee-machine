package com.github.alexduch.coffeemachine.exceptions;

public class NotEnoughMoneyException extends Exception {

  private static final String MESSAGE_TEMPLATE = "missing %.2f €";

  public NotEnoughMoneyException(double missingAmount) {
    super(String.format(MESSAGE_TEMPLATE, missingAmount));
  }
}
