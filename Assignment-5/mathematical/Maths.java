package mathematical;

public class Maths {
	/**
	 * To find HCf
	 * @param firstNumber, is the first number passed
	 * @param secondNumber,is the second number passed
	 * @return error if values are negative else returns HCF of the two numbers
	 */
	public int hcf(int firstNumber, int secondNumber) {
		if(firstNumber < 0 || secondNumber < 0) {
			throw new AssertionError("Numbers are negative");
		}
		if(secondNumber !=0) {
			return hcf(secondNumber, firstNumber % secondNumber);
		}
		else {
			return firstNumber;
		}
	}
	
	/**
	 * To find LCM, two values are passed to hcf function and returned value is used to find LCM
	 * @param firstNumber, is the first number passed
	 * @param secondNumber,is the second number passed
	 * @return error if values are negative else returns LCM of the two numbers
	 */
	public int lcm(int firstNumber, int secondNumber) {
		int hcfValue=hcf(firstNumber,secondNumber);
		return (firstNumber * secondNumber)/hcfValue;
	}
}