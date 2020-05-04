package conceptualization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapSortByValue {

    public static Map<Integer, String> sort(Map<Integer, String> unsortedMap) {
        List<Entry<Integer, String>> entryList = new ArrayList<>(unsortedMap.entrySet());

        Collections.sort(entryList, Comparator.comparing(Entry::getValue));

        return createMapFrom(entryList);
    }

    private static Map<Integer, String> createMapFrom(List<Entry<Integer, String>> mapEntryList) {
        Map<Integer, String> map = new LinkedHashMap<>();

        for (Entry<Integer, String> entry : mapEntryList) {
            map.put(entry.getKey(), entry.getValue());
        }

        return map;
    }

}
