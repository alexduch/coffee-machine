package com.github.alexduch.coffeemachine;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

	private final CoffeeMachine coffeeMachine = new CoffeeMachine();

	@Test
	void shouldTranslate() {
		assertNotNull(coffeeMachine.translate(new Order()));
	}

}
