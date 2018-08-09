package multivariatePolynomial;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to create a whole polynomial term
 */
public class MultiVariatePolynomial {
	List<Term> listOfTerms;

	//Constructor to initialise the arraylist;
	MultiVariatePolynomial() {
		listOfTerms = new ArrayList<Term>();
	}

	/**
	 * To add the whole term to the list of terms
	 * @param term
	 * @return the list after adding the term
	 */
	public boolean addTerm(Term term) {
		return listOfTerms.add(term);
	}

	/**
	 * To get the list of polynomial terms
	 * @return the list
	 */
	public List<Term> getPolynomial() {
		return this.listOfTerms;
	}

	/**
	 * creating the polynomial string by adding all the terms in the list
	 * 
	 * @return the polynomial
	 */
	public String getPolyNomial() {
		String polynomial = "";
		for (Term term : listOfTerms) {
			polynomial = polynomial + term.getTerm();
		}

		return polynomial;
	}

}
