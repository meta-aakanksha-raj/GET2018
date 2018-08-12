package test_cases;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

import dictionary.Dictionary;
import dictionary.DictionaryTree;
import dictionary.JsonInputList;
import dictionary.KeyValuePair;

public class TestSorting {

	Dictionary dictionary;

	@Before
	public void initializeDictionary() throws FileNotFoundException,IOException, ParseException {
		dictionary = new DictionaryTree(JsonInputList
						.takeInput("C:\\Users\\aakan\\workspace\\DS5\\src\\dictionary\\inputFile.json"));
	}

	@Test
	public void testSortMethodForAListOfKeyValuePair() {
		int [] sortedKeyList = new int[dictionary.getSortedListOfKeyValuePair().size()];
		int index =0;
		for(KeyValuePair pair:dictionary.getSortedListOfKeyValuePair() ){
			sortedKeyList[index] = pair.getKey();
			index++;
		}
		int actualResult[] = new int[]{1, 3, 5, 7, 9, 12, 13, 15, 17};
		assertArrayEquals("sorted list",sortedKeyList, actualResult);
	}
}
