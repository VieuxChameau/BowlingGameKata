package org.kata.bowlingGame;

public interface Frame {
	/**
	 * Call for roll ball
	 * 
	 * @param pins
	 *            the number of pins knocked down
	 */
	void roll(final int pins);

	/**
	 * return the score for all the frames
	 */
	int score();

	/**
	 * Check if the frame can accept more rolls
	 */
	boolean isComplete();

	void setNextFrame(final Frame nextFrame);

	int sumPinsOfNextNRolls(final int n);
}
