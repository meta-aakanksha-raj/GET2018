package nested_list_json;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import nested_list_json.NestedList;

public class MainNestedList {
	
	public static final String jsonFilePath= "C:\\Users\\Aakanksha\\workspace\\DS2\\src\\nested_list_json\\inputData.json";
	
	public static void main(String[] args) {
		NestedList nestedlist = new NestedList();
		List<Object> nestedListOfIntegers = new LinkedList<Object>();
		try {
			Object object = new JSONParser().parse(new FileReader(jsonFilePath));
			JSONObject inputJsonObject = (JSONObject) object;
			JSONArray jsonArrayOfInputList = (JSONArray) inputJsonObject.get("inputData");
			nestedListOfIntegers = nestedlist.createNestedList(nestedListOfIntegers,jsonArrayOfInputList);
			nestedlist.listOfIntegersFinal = nestedListOfIntegers; 
			System.out.println("Nested list");
			nestedlist.printNestedList(nestedlist.listOfIntegersFinal);
			
			System.out.println("\nSum of nested list");
			System.out.println(nestedlist.sumOfAllIntegersInList(nestedlist.listOfIntegersFinal));
			
			System.out.println("Largest element of nested list");
			System.out.println(nestedlist.largestIntegerInList(nestedlist.listOfIntegersFinal));
			
			System.out.println("Integer 1 in list? ");
			System.out.println(nestedlist.searchIntegerInList(nestedlist.listOfIntegersFinal, 1));

			System.out.println("Integer 2 in list? ");
			System.out.println(nestedlist.searchIntegerInList(nestedlist.listOfIntegersFinal, 2));
			
			System.out.println("Integer 3 in list? ");
			System.out.println(nestedlist.searchIntegerInList(nestedlist.listOfIntegersFinal, 3));

			System.out.println("Integer 4 in list? ");
			System.out.println(nestedlist.searchIntegerInList(nestedlist.listOfIntegersFinal, 4));

			System.out.println("Integer 5 in list? ");
			System.out.println(nestedlist.searchIntegerInList(nestedlist.listOfIntegersFinal, 5));

			System.out.println("Integer 6 in list? ");
			System.out.println(nestedlist.searchIntegerInList(nestedlist.listOfIntegersFinal, 6));

			System.out.println("Integer 17 in list? ");
			System.out.println(nestedlist.searchIntegerInList(nestedlist.listOfIntegersFinal, 17));
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
