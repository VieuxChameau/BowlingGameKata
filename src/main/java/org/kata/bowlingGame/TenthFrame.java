package org.kata.bowlingGame;

public class TenthFrame extends AbstractFrame {
	private static final int MAXIMUM_ROLLS = 3;

	public TenthFrame() {
		super(MAXIMUM_ROLLS);
	}

	@Override
	public boolean isComplete() {
		return fullRolls() || isUnclosedDoubleRolls();
	}

	private boolean isUnclosedDoubleRolls() {
		return sumPinsDown() < 10 && getRollNumber() == 2;
	}

	@Override
	protected int frameScore() {
		return sumPinsDown();
	}

	@Override
	public int sumPinsOfNextNRolls(final int n) {
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += rolls[i];
		}
		return sum;
	}
}
