package com.github.alexduch.coffeemachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.alexduch.coffeemachine.Order.Drink;
import com.github.alexduch.coffeemachine.Order.Sugar;
import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

	private static final double ONE_EURO = 1;

	private final CoffeeMachine coffeeMachine = new CoffeeMachine();

	@Test
	void shouldTranslateDrinkType() {
		assertEquals("T::", coffeeMachine.buy(new Order(Drink.TEA, ONE_EURO)));
		assertEquals("C::", coffeeMachine.buy(new Order(Drink.COFFEE, ONE_EURO)));
		assertEquals("H::", coffeeMachine.buy(new Order(Drink.CHOCOLATE, ONE_EURO)));
	}

	@Test
	void shouldAddOneSugarAndAStick() {
		assertEquals("T:1:0", coffeeMachine.buy(new Order(Drink.TEA, Sugar.ONE, ONE_EURO)));
		assertEquals("C:1:0", coffeeMachine.buy(new Order(Drink.COFFEE, Sugar.ONE, ONE_EURO)));
		assertEquals("H:1:0", coffeeMachine.buy(new Order(Drink.CHOCOLATE, Sugar.ONE, ONE_EURO)));
	}

	@Test
	void shouldAddTwoSugarsAndAStick() {
		assertEquals("T:2:0", coffeeMachine.buy(new Order(Drink.TEA, Sugar.TWO, ONE_EURO)));
		assertEquals("C:2:0", coffeeMachine.buy(new Order(Drink.COFFEE, Sugar.TWO, ONE_EURO)));
		assertEquals("H:2:0", coffeeMachine.buy(new Order(Drink.CHOCOLATE, Sugar.TWO, ONE_EURO)));
	}

	@Test
	void shouldNotPrepareDrinkAndDisplayAMessage() {
		assertEquals("M:missing 0,20 €", coffeeMachine.buy(new Order(Drink.TEA, Sugar.TWO, 0.2)));
		assertEquals("M:missing 0,05 €", coffeeMachine.buy(new Order(Drink.COFFEE, Sugar.TWO, 0.55)));
		assertEquals("M:missing 0,33 €", coffeeMachine.buy(new Order(Drink.CHOCOLATE, Sugar.TWO, 0.17)));
	}

}
