package data_structure.search.binary;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void should_return_element_index_if_element_found_using_binary_search() {
        int[] dataSet = { 10, 78, 87, 14, 25, 4, 92, 72, 89, 1 };

        assertTrue(BinarySearch.search(dataSet, 72));
    }

    @Test
    public void should_return_invalid_index_if_element_found_using_binary_search() {
        int[] dataSet = { 10, 78, 87, 14, 25, 4, 92, 72, 89, 1 };

        assertFalse(BinarySearch.search(dataSet, 100));
    }

}