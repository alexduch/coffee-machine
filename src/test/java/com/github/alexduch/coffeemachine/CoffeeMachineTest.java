package com.github.alexduch.coffeemachine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.alexduch.coffeemachine.Order.Drink;
import com.github.alexduch.coffeemachine.Order.Sugar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

	private static final double ONE_EURO = 1;

	private CoffeeMachine coffeeMachine;

	@BeforeEach
	void installCoffeeMachine() {
		coffeeMachine = new CoffeeMachine();
	}

	@Test
	void shouldTranslateDrinkType() {
		assertEquals("T::", coffeeMachine.buy(new Order(Drink.TEA, ONE_EURO)));
		assertEquals("C::", coffeeMachine.buy(new Order(Drink.COFFEE, ONE_EURO)));
		assertEquals("H::", coffeeMachine.buy(new Order(Drink.CHOCOLATE, ONE_EURO)));
		assertEquals("O::", coffeeMachine.buy(new Order(Drink.ORANGE_JUICE, ONE_EURO)));
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
	void shouldBeExtraHot() {
		assertEquals("Th::", coffeeMachine.buy(new Order(Drink.TEA, Sugar.NONE, true, ONE_EURO)));
		assertEquals("Ch:1:0", coffeeMachine.buy(new Order(Drink.COFFEE, Sugar.ONE, true, ONE_EURO)));
		assertEquals("Hh:2:0", coffeeMachine.buy(new Order(Drink.CHOCOLATE, Sugar.TWO, true, ONE_EURO)));
	}

	@Test
	void shouldIgnoreSugarForColdDrinks() {
		assertEquals("O::", coffeeMachine.buy(new Order(Drink.ORANGE_JUICE, Sugar.ONE, ONE_EURO)));
		assertEquals("O::", coffeeMachine.buy(new Order(Drink.ORANGE_JUICE, Sugar.TWO, ONE_EURO)));
	}

	@Test
	void shouldIgnoreExtraHotForColdDrinks() {
		assertEquals("O::", coffeeMachine.buy(new Order(Drink.ORANGE_JUICE, Sugar.ONE, true, ONE_EURO)));
	}

	@Test
	void shouldNotPrepareDrinkAndDisplayAMessage() {
		assertEquals("M:missing 0,20 €", coffeeMachine.buy(new Order(Drink.TEA, Sugar.TWO, 0.2)));
		assertEquals("M:missing 0,05 €", coffeeMachine.buy(new Order(Drink.COFFEE, Sugar.TWO, 0.55)));
		assertEquals("M:missing 0,33 €", coffeeMachine.buy(new Order(Drink.CHOCOLATE, Sugar.TWO, 0.17)));
		assertEquals("M:missing 0,48 €", coffeeMachine.buy(new Order(Drink.ORANGE_JUICE, Sugar.TWO, 0.12)));
	}

	@Test
	void shouldRegisterSalesAndReport() {
		assertEquals("H:2:0", coffeeMachine.buy(new Order(Drink.CHOCOLATE, Sugar.TWO, ONE_EURO)));
		assertEquals("T:1:0", coffeeMachine.buy(new Order(Drink.TEA, Sugar.ONE, ONE_EURO)));
		assertEquals("H:2:0", coffeeMachine.buy(new Order(Drink.CHOCOLATE, Sugar.TWO, ONE_EURO)));
		assertEquals("Ch:1:0", coffeeMachine.buy(new Order(Drink.COFFEE, Sugar.ONE, true, ONE_EURO)));
		assertEquals("O::", coffeeMachine.buy(new Order(Drink.ORANGE_JUICE, Sugar.TWO, ONE_EURO)));
		assertEquals("O::", coffeeMachine.buy(new Order(Drink.ORANGE_JUICE, Sugar.ONE, true, ONE_EURO)));
		assertEquals("M:missing 0,33 €", coffeeMachine.buy(new Order(Drink.CHOCOLATE, Sugar.TWO, 0.17)));

		coffeeMachine.printSalesReport();

    assertEquals(
        "Amount of money earned: 3,20€\n"
            + "Drinks sold:\n"
            + "Tea: \t1\n"
						+ "Coffee: \t1\n"
						+ "Chocolate: \t2\n"
						+ "Orange juice: \t2\n",
        coffeeMachine.stats.report());
	}

}
