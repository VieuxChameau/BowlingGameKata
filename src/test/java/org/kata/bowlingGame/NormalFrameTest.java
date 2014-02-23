package org.kata.bowlingGame;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class NormalFrameTest {
	private final Frame frame = new NormalFrame();

	@Test
	public void shouldBeCompleteWithStrike() {
		frame.roll(10);

		assertThat(frame.isComplete()).isTrue();
	}

	@Test
	public void shouldBeCompleteWithSpare() {
		frame.roll(5);
		frame.roll(5);

		assertThat(frame.isComplete()).isTrue();
	}

	@Test
	public void shouldBeCompleteWithTwoRolls() {
		frame.roll(5);
		frame.roll(1);

		assertThat(frame.isComplete()).isTrue();
	}

	@Test
	public void shouldNotBeCompleteWithOneSimpleRoll() {
		frame.roll(5);

		assertThat(frame.isComplete()).isFalse();
	}

	@Test
	public void shouldNotBeCompleteWithoutRolls() {
		assertThat(frame.isComplete()).isFalse();
	}
}
