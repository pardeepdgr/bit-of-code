package conceptualization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapSortByValue {

	public static void main(String[] args) {
		Map<Integer, String> unsortedMap = getUnsortedMap();
		printMap(unsortedMap, "Unsorted");

		List<Entry<Integer, String>> mapEntryList = new ArrayList<Entry<Integer, String>>(
				unsortedMap.entrySet());
		Collections.sort(mapEntryList,
				new Comparator<Entry<Integer, String>>() {
					public int compare(Entry<Integer, String> o1,
							Entry<Integer, String> o2) {
						return (o1.getValue().compareTo(o2.getValue()));
					}
				});

		Map<Integer, String> sortedMap = getSortedMap(mapEntryList);
		printMap(sortedMap, "Sorted");
	}

	private static Map<Integer, String> getUnsortedMap() {
		Map<Integer, String> unsortedMap = new HashMap<Integer, String>();
		unsortedMap.put(45, "Z");
		unsortedMap.put(1, "a");
		unsortedMap.put(10, "C");
		unsortedMap.put(67, "P");
		unsortedMap.put(89, "M");
		unsortedMap.put(4, "t");
		unsortedMap.put(33, "s");
		unsortedMap.put(13, "g");
		unsortedMap.put(73, "q");
		unsortedMap.put(99, "l");
		return unsortedMap;
	}

	private static Map<Integer, String> getSortedMap(
			List<Entry<Integer, String>> mapEntryList) {
		Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
		for (Entry<Integer, String> entry : mapEntryList)
			sortedMap.put(entry.getKey(), entry.getValue());
		return sortedMap;
	}

	private static void printMap(Map<Integer, String> map, String status) {
		System.out.println(status + " Map: ");
		System.out.println(map);
		System.out.println();
	}

}
