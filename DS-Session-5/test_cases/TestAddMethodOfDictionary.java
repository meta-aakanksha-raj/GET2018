package test_cases;

import java.io.FileNotFoundException;
import java.io.IOException;

import dictionary.Dictionary;
import dictionary.JsonInputList;
import dictionary.DictionaryTree;

import static org.junit.Assert.assertEquals;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class TestAddMethodOfDictionary {

	Dictionary dictionary;

	@Before
	public void initializeDictionary() throws FileNotFoundException,
			IOException, ParseException {
		dictionary = new DictionaryTree(JsonInputList
						.takeInput("C:\\Users\\aakan\\workspace\\DS5\\src\\dictionary\\inputFile.json"));
	}

	@Test
	public void testAddMethodToAddAKeyValuePairToDictionaryWhenNoSimilarKeyOfSuchTypeIsPresent() {
		boolean isAddedFlag = dictionary.add(100, "hey");
		assertEquals("no similar key exists, so element added successfully",true, isAddedFlag);
	}

	@Test
	public void testAddMethodToAddAKeyValuePairToDictionaryWhenSimilarKeyOfSuchTypeIsPresent() {
		dictionary.add(100, "dsa");
		boolean isAddedFlag = dictionary.add(100, "hey");
		assertEquals("Two same keys can not be added" , false, isAddedFlag);
	}
}
