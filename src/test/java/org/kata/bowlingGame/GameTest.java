package org.kata.bowlingGame;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class GameTest {
	private final Game game = new Game();

	@Test
	public void testGutterGame() {
		rollMany(20, 0);

		assertThat(game.score()).isZero();
	}

	@Test
	public void testAllOnes() {
		rollMany(20, 1);

		assertThat(game.score()).isEqualTo(20);
	}

	@Test
	public void testOneSpare() {
		game.roll(5);
		game.roll(5); // spare
		game.roll(3);
		rollMany(17, 0);

		assertThat(game.score()).isEqualTo(16);
	}

	@Test
	public void testOneStrike() {
		game.roll(10);
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);

		assertThat(game.score()).isEqualTo(24);
	}

	@Test
	public void testPerfectGame() {
		rollMany(12, 10);

		assertThat(game.score()).isEqualTo(300);
	}

	@Test(expected = IllegalStateException.class)
	public void testMoreThan10Rolls() {
		rollMany(14, 10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoreThan10Pins() {
		game.roll(15);
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			game.roll(pins);
		}
	}

}
