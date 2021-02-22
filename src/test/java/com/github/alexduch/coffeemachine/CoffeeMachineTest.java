package com.github.alexduch.coffeemachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.alexduch.coffeemachine.Order.Drink;
import com.github.alexduch.coffeemachine.Order.Sugar;
import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

	private final CoffeeMachine coffeeMachine = new CoffeeMachine();

	@Test
	void shouldTranslateDrinkType() {
		assertEquals("T::", coffeeMachine.translate(new Order(Drink.TEA)));
		assertEquals("C::", coffeeMachine.translate(new Order(Drink.COFFEE)));
		assertEquals("H::", coffeeMachine.translate(new Order(Drink.CHOCOLATE)));
	}

	@Test
	void shouldAddOneSugarAndAStick() {
		assertEquals("T:1:0", coffeeMachine.translate(new Order(Drink.TEA, Sugar.ONE)));
		assertEquals("C:1:0", coffeeMachine.translate(new Order(Drink.COFFEE, Sugar.ONE)));
		assertEquals("H:1:0", coffeeMachine.translate(new Order(Drink.CHOCOLATE, Sugar.ONE)));
	}

	@Test
	void shouldAddTwoSugarsAndAStick() {
		assertEquals("T:2:0", coffeeMachine.translate(new Order(Drink.TEA, Sugar.TWO)));
		assertEquals("C:2:0", coffeeMachine.translate(new Order(Drink.COFFEE, Sugar.TWO)));
		assertEquals("H:2:0", coffeeMachine.translate(new Order(Drink.CHOCOLATE, Sugar.TWO)));
	}

}
