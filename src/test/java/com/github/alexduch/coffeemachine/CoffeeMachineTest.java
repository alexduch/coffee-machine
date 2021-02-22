package com.github.alexduch.coffeemachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.alexduch.coffeemachine.Order.Drink;
import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

	private final CoffeeMachine coffeeMachine = new CoffeeMachine();

	@Test
	void shouldTranslateDrinkType() {
		assertEquals("T::", coffeeMachine.translate(new Order(Drink.TEA)));
		assertEquals("C::", coffeeMachine.translate(new Order(Drink.COFFEE)));
		assertEquals("H::", coffeeMachine.translate(new Order(Drink.CHOCOLATE)));
	}

}
