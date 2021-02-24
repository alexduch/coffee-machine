package com.github.alexduch.coffeemachine;

import com.github.alexduch.coffeemachine.Order.Drink;
import com.github.alexduch.coffeemachine.drinkmaker.AbstractDrinkMakerCommand;
import com.github.alexduch.coffeemachine.drinkmaker.DisplayMessageCommand;
import com.github.alexduch.coffeemachine.drinkmaker.MakeDrinkCommandBuilder;
import com.github.alexduch.coffeemachine.exceptions.IngredientShortageException;
import com.github.alexduch.coffeemachine.exceptions.NotEnoughMoneyException;
import com.github.alexduch.coffeemachine.services.BeverageQuantityChecker;
import com.github.alexduch.coffeemachine.services.EmailNotifier;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CoffeeMachine {

  public final CoffeeMachineStats stats = new CoffeeMachineStats();

  private final BeverageQuantityChecker beverageQuantityChecker;
  private final EmailNotifier emailNotifier;

  public CoffeeMachine(
      BeverageQuantityChecker beverageQuantityChecker,
      EmailNotifier emailNotifier
  ) {
    this.beverageQuantityChecker = beverageQuantityChecker;
    this.emailNotifier = emailNotifier;
  }

  public String buy(Order order) {
    AbstractDrinkMakerCommand command;
    try {
      checkAmountOfMoney(order);
      checkIngredientsAvailability(order.drink);

      command = MakeDrinkCommandBuilder.forDrink(order.drink)
          .with(order.sugar)
          .extraHot(order.extraHot)
          .build();

      stats.registerSale(order.drink);

    } catch (NotEnoughMoneyException | IngredientShortageException e) {
      command = new DisplayMessageCommand(e.getMessage());
    }
    return command.toString();
  }

  private void checkAmountOfMoney(Order order) throws NotEnoughMoneyException {
    double missingAmount = order.drink.price - order.moneyInserted;
    if (missingAmount > 0) {
      throw new NotEnoughMoneyException(missingAmount);
    }
  }

  private void checkIngredientsAvailability(Drink drink) throws IngredientShortageException {
    String ingredients = Arrays.stream(drink.ingredients)
        .filter(beverageQuantityChecker::isEmpty)
        .peek(emailNotifier::notifyMissingDrink)
        .collect(Collectors.joining(", "));
    if (!ingredients.isBlank()) {
      throw new IngredientShortageException(ingredients);
    }
  }

  public void printSalesReport() {
    System.out.println(stats.report());
  }
}
