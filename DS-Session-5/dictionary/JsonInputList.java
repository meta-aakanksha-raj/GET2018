package dictionary;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Key value pair is provided in list in JSON
 * Here input is taken through JSON
 */
public class JsonInputList {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<KeyValuePair> takeInput(String path)
			throws FileNotFoundException, IOException, ParseException {
		List<KeyValuePair> list = new ArrayList<KeyValuePair>();

		JSONArray array = (JSONArray) new JSONParser().parse(new FileReader(path));

		Iterator iterator = array.iterator();
		Iterator<Map.Entry> iteratorMap;

		while (iterator.hasNext()) {
			iteratorMap = ((Map) iterator.next()).entrySet().iterator();
			while (iteratorMap.hasNext()) {
				Map.Entry pair1 = iteratorMap.next();
				Map.Entry pair2 = iteratorMap.next();

				list.add(new KeyValuePair(Integer.parseInt(pair2.getValue().toString()), pair1.getValue().toString()));

				// System.out.println(pair.getKey() + " : " + pair.getValue());
			}
		}
		return list;
	}
}
