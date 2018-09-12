package com.metacube.training;

public class TextEditor {

	private SpellChecker spellChecker;

	/**
	 * @param spellChecker
	 */
	public TextEditor(SpellChecker spellChecker) {
		super();
		this.spellChecker = spellChecker;
	}

	/**
	 * @return the spellChecker
	 */
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	// Display function to print type of spell checker
	public void display() {
		System.out.println("This is " + spellChecker.getType() + " spell checker");
	}
}
