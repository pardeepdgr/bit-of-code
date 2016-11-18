

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapSortByValue {

	static void customSort(int[] arr) {

		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (int val : arr) {
			Integer existingVal = map.get(val);
			if (null != existingVal) {
				map.put(val, ++existingVal);
			} else {
				map.put(val, 1);
			}
		}

		List<Map.Entry<Integer, Integer>> list = sortByValue(map);
		sortedArray(arr, list);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static List<Map.Entry<Integer, Integer>> sortByValue(
			Map<Integer, Integer> frequencyMap) {

		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(
				frequencyMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1,
					Map.Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		return list;
	}

	private static void sortedArray(int[] array,
			List<Map.Entry<Integer, Integer>> list) {
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : list) {
			for (int i = 0; i < entry.getValue(); i++) {
				array[index++] = entry.getKey();
			}
		}
	}
}