package org.kata.bowlingGame;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

public class Game {
	private static final int MAXIMUM_FRAMES = 10;
	private static final int MAXIMUM_PINS = 10;

	private final Frame firstFrame;
	private Frame currentFrame;
	private int frameNumber = 1;

	public Game() {
		firstFrame = new NormalFrame();
		currentFrame = firstFrame;
	}

	public void roll(final int pins) {
		checkArgument(pins <= MAXIMUM_PINS, "Cannot score more than 10 pins");
		if (currentFrame.isComplete()) {
			finishFrame();
		}
		currentFrame.roll(pins);
	}

	/**
	 * Return the current score for the game
	 */
	public int score() {
		return firstFrame.score();
	}

	private void finishFrame() {
		checkState(++frameNumber <= MAXIMUM_FRAMES,
				"Cannot play more than 10 frames");

		final Frame nextFrame = createNextFrame();
		currentFrame.setNextFrame(nextFrame);
		currentFrame = nextFrame;
	}

	private Frame createNextFrame() {
		if (frameNumber < MAXIMUM_FRAMES) {
			return new NormalFrame();
		}
		return new TenthFrame();
	}
}
