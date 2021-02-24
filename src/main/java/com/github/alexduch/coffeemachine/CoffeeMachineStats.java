package com.github.alexduch.coffeemachine;

import com.github.alexduch.coffeemachine.Order.Drink;
import java.util.EnumMap;

public class CoffeeMachineStats {

  private final EnumMap<Drink, Integer> drinksSold = new EnumMap<>(Drink.class);

  private double moneyEarned;

  public void registerSale(Drink drink) {
    moneyEarned += drink.price;
    drinksSold.merge(drink, 1, Integer::sum);
  }

  public String report() {
    StringBuilder report = new StringBuilder("Amount of money earned: ")
        .append(String.format("%.2f", moneyEarned))
        .append("€\n")
        .append("Drinks sold:\n");
    drinksSold.forEach((drink, number) ->
        report.append(drink.displayName)
            .append(": \t")
            .append(number)
            .append("\n")
    );
    return report.toString();
  }
}
