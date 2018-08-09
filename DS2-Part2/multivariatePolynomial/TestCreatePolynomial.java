package multivariatePolynomial;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCreatePolynomial {
	MultiVariatePolynomial multiVariatePolynomial = new MultiVariatePolynomial();

	public TestCreatePolynomial() {
		Variable variableOne = new Variable('a', 3);
		Variable variableTwo = new Variable('b', 5);
		Variable variableThree = new Variable('c', 7);
		Variable variableFour = new Variable('d', 3);
		Variable variableFive = new Variable('e', 5);
		Variable variableSix = new Variable('f', 5);

		Term termOne = new Term(4);
		termOne.addVariable(variableOne);
		termOne.addVariable(variableFour);
		termOne.addVariable(variableThree);

		Term termTwo = new Term(5);
		termTwo.addVariable(variableTwo);
		termTwo.addVariable(variableFour);

		Term termThree = new Term(6);
		termThree.addVariable(variableFive);
		termThree.addVariable(variableSix);

		multiVariatePolynomial.addTerm(termOne);
		multiVariatePolynomial.addTerm(termTwo);
		multiVariatePolynomial.addTerm(termThree);
	}

	@Test
	public void testPolynomial() {
		String actualResult = multiVariatePolynomial.getPolyNomial();
		String ExpectedResult = " + (4 a^3 d^3 c^7 ) + (5 b^5 d^3 ) + (6 e^5 f^5 )";
		assertEquals("checking the polynomial representation", ExpectedResult,
				actualResult);
	}
}
