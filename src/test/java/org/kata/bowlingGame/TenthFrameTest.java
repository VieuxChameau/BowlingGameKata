package org.kata.bowlingGame;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class TenthFrameTest {
	private final Frame frame = new TenthFrame();

	@Test
	public void shouldBeCompleteWithTwoSimpleRolls() {
		frame.roll(5);
		frame.roll(0);

		assertThat(frame.isComplete()).isTrue();
	}

	@Test
	public void shouldBeCompleteWithThreeStrikes() {
		frame.roll(10);
		frame.roll(10);
		frame.roll(10);

		assertThat(frame.isComplete()).isTrue();
	}

	@Test
	public void shouldBeCompleteWithTwoStrikesAndSimpleRoll() {
		frame.roll(10);
		frame.roll(10);
		frame.roll(1);

		assertThat(frame.isComplete()).isTrue();
	}

	@Test
	public void shouldBeCompleteWithSpareAndStrikes() {
		frame.roll(8);
		frame.roll(2);
		frame.roll(10);

		assertThat(frame.isComplete()).isTrue();
	}

	@Test
	public void shouldBeCompleteWithSpareAndSimpleRoll() {
		frame.roll(8);
		frame.roll(2);
		frame.roll(5);

		assertThat(frame.isComplete()).isTrue();
	}

	@Test
	public void shouldNotBeCompleteWithSpare() {
		frame.roll(8);
		frame.roll(2);

		assertThat(frame.isComplete()).isFalse();
	}

	@Test
	public void shouldNotBeCompleteWithOneStrike() {
		frame.roll(10);
		frame.roll(5);

		assertThat(frame.isComplete()).isFalse();
	}

	@Test
	public void shouldNotBeCompleteWithTwoStrikes() {
		frame.roll(10);
		frame.roll(10);

		assertThat(frame.isComplete()).isFalse();
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
