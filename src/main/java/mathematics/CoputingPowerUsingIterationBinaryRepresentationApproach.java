package mathematics;

public class CoputingPowerUsingIterationBinaryRepresentationApproach {

	public int computePower(int number, int power) {
		int result = 1;

		while (power > 0) {
			// if the number is odd then its last bit is set else if the number is even then
			// its last bit is not set.
			if (power % 2 != 0) {
				// bit is set
				result = result * number;
			}
			power = power / 2;
			number = number * number;
		}

		return result;
	}

}
