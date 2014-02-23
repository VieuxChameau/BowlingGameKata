package org.kata.bowlingGame;

public class NormalFrame extends AbstractFrame {
	private static final int TOTAL_PINS = 10;
	private static final int MAXIMUM_ROLLS = 2;

	public NormalFrame() {
		super(MAXIMUM_ROLLS);
	}

	@Override
	public boolean isComplete() {
		return fullRolls() || allPinsDown();
	}

	private boolean allPinsDown() {
		return sumPinsDown() == TOTAL_PINS;
	}

	private boolean isSpare() {
		return sumPinsDown() == TOTAL_PINS && fullRolls();
	}

	private boolean isStrike() {
		return sumPinsDown() == TOTAL_PINS && !fullRolls();
	}

	@Override
	protected int frameScore() {
		if (isStrike()) {
			return TOTAL_PINS + pinsOfNextNRolls(2);
		} else if (isSpare()) {
			return TOTAL_PINS + pinsOfNextNRolls(1);
		}
		return sumPinsDown();
	}

	@Override
	public int sumPinsOfNextNRolls(final int n) {
		if (isStrike()) {
			return TOTAL_PINS + pinsOfNextNRolls(n - 1);
		}
		if (n == 2) {
			return sumPinsDown();
		}
		return rolls[0];
	}

}
