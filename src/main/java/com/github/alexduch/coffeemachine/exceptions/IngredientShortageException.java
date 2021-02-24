package com.github.alexduch.coffeemachine.exceptions;

public class IngredientShortageException extends Exception {

  private static final String MESSAGE_TEMPLATE =
      "Sorry, there is a shortage of %s. The company has been notified.";

  public IngredientShortageException(String ingredients) {
    super(String.format(MESSAGE_TEMPLATE, ingredients));
  }
}
