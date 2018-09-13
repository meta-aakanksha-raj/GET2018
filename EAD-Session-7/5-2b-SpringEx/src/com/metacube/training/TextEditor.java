package com.metacube.training;

public class TextEditor {

	private SpellChecker spellChecker;

	/**
	 * @return the spellChecker
	 */
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	/**
	 * @param spellChecker the spellChecker to set
	 */
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	// Display function to print type of spell checker
	public void display() {
		System.out.println("This is " + spellChecker.getType() + " spell checker");
	}
}
