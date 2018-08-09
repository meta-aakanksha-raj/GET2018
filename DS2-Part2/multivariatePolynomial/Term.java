package multivariatePolynomial;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to create a polynomial term
 */
public class Term {
	int coefficient;
	List<Variable> listOfVariables;

	public Term(int coefficient) {
		this.coefficient = coefficient;
		listOfVariables = new ArrayList<Variable>();
	}

	/**
	 * Method to add variable with its symbol and power to the List
	 * @param variable
	 * @return the list after adding the variable
	 */
	public boolean addVariable(Variable variable) {
		return listOfVariables.add(variable);
	}

	/**
	 * To generate a term
	 * @return the term
	 */
	public String getTerm() {
		String termString = " + (";
		termString = termString + coefficient + " ";
		for (Variable variable : listOfVariables) {
			termString = termString + variable.getVariableSymbol() + "^"
					+ variable.getPower() + " ";
		}
		return termString + ")";
	}
}
