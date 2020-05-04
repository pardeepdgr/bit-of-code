package conceptualization;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MapSortByValueTest {

    @Test
    public void should_sort_map_by_its_value() {
        Map<Integer, String> sortedMap = MapSortByValue.sort(createUnsortedMap());

        assertEquals(createSortedMap(), sortedMap);
    }

    private Map<Integer, String> createUnsortedMap() {
        Map<Integer, String> unsortedMap = new HashMap<>();
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

    private Map<Integer, String> createSortedMap() {
        Map<Integer, String> sortedMap = new HashMap<>();
        sortedMap.put(10, "C");
        sortedMap.put(89, "M");
        sortedMap.put(67, "P");
        sortedMap.put(45, "Z");
        sortedMap.put(1, "a");
        sortedMap.put(13, "g");
        sortedMap.put(99, "l");
        sortedMap.put(73, "q");
        sortedMap.put(33, "s");
        sortedMap.put(4, "t");
        return sortedMap;
    }

}