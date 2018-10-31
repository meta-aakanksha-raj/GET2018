package test_cases;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

import dictionary.Dictionary;
import dictionary.DictionaryTree;
import dictionary.JsonInputList;

public class TestDeleteMethodOfDictionary {

	Dictionary dictionary;

	@Before
	public void initializeDictionary() throws FileNotFoundException,IOException, ParseException {
		dictionary = new DictionaryTree(JsonInputList
						.takeInput("C:\\Users\\aakan\\workspace\\DS5\\src\\dictionary\\inputFile.json"));
	}

	@Test
	public void testDeleteMethodForElementWhichDoesNotExistInTree() {
		boolean isDeleteFlag = dictionary.delete(200);
		assertEquals("can not be delete element is not present in tree ",false, isDeleteFlag);
	}

	@Test
	public void testDeleteNodeWhichHasOneChild() {
		boolean isDeleteFlag = dictionary.delete(1);
		assertEquals("node deleted" , true, isDeleteFlag);
	}
	
	@Test
	public void testDeleteNodeWhichHasTwoChild() {
		boolean isDeleteFlag = dictionary.delete(12);
		assertEquals("node deleted" , true, isDeleteFlag);
	}
	
	@Test
	public void testDeleteNodeWhichHasNoChild() {
		boolean isDeleteFlag = dictionary.delete(9);
		assertEquals("node deleted" , true, isDeleteFlag);
	}
}
