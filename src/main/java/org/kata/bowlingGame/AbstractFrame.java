package org.kata.bowlingGame;

public abstract class AbstractFrame implements Frame {
	protected final int[] rolls;
	private final int maximumRolls;
	private int currentRoll = 0;

	private Frame nextFrame = null;

	protected AbstractFrame(final int maxRolls) {
		maximumRolls = maxRolls;
		rolls = new int[maxRolls];
	}

	abstract protected int frameScore();

	protected boolean fullRolls() {
		return getRollNumber() == maximumRolls;
	}

	@Override
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}

	@Override
	public void setNextFrame(final Frame nextFrame) {
		this.nextFrame = nextFrame;
	}

	@Override
	public int score() {
		return frameScore() + scoreOfNextFrame();
	}

	private int scoreOfNextFrame() {
		return nextFrame == null ? 0 : nextFrame.score();
	}

	protected int getRollNumber() {
		return currentRoll;
	}

	protected int sumPinsDown() {
		int sum = 0;
		for (int roll : rolls) {
			sum += roll;
		}
		return sum;
	}

	protected int pinsOfNextNRolls(final int n) {
		if (n > 0) {
			return nextFrame.sumPinsOfNextNRolls(n);
		}
		return 0;
	}
}
