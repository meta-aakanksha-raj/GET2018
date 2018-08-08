package nested_list_json;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import nested_list_json.NestedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestNestedList {
	public static final String jsonFilePath= "C:\\Users\\Aakanksha\\workspace\\DS2\\src\\nested_list_json\\inputData.json";
	NestedList nestedlist = new NestedList();
	List<Object> nestedListOfIntegers = new LinkedList<Object>();	

	@Before
	public void init() {
		try{
			Object object = new JSONParser().parse(new FileReader(jsonFilePath));
			JSONObject inputJsonObject = (JSONObject) object;
			JSONArray jsonArrayOfInputList = (JSONArray) inputJsonObject.get("inputData");
			nestedListOfIntegers = nestedlist.createNestedList(nestedListOfIntegers,jsonArrayOfInputList);
			nestedlist.listOfIntegersFinal = nestedListOfIntegers;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSumOfWholeList(){
		int sum=nestedlist.sumOfAllIntegersInList(nestedlist.listOfIntegersFinal);
		assertEquals(120,sum);
	}
	
	@Test
	public void testLargestNumberOfWholeList(){
		int largest=nestedlist.largestIntegerInList(nestedlist.listOfIntegersFinal);
		assertEquals(15,largest);
	}
	
	@Test
	public void testsearchNumberOfWholeListWhenNumberIsPresent(){	
		boolean result=nestedlist.searchIntegerInList(nestedlist.listOfIntegersFinal, 4);
		assertEquals(true,result);
	}
	
	@Test
	public void testsearchNumberOfWholeListWhenNumberIsNotPrsent(){	
		boolean result=nestedlist.searchIntegerInList(nestedlist.listOfIntegersFinal, 20);
		assertEquals(false,result);
	}
}
