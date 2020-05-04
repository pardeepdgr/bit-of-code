package data_structure.sort.merge;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void should_sort_dataset_using_merge_sort() {
        int[] dataSet = { 43, 21, 89, 67, 87, 5, 40, 100, 87, 72, 89, 2, 50 };
        int[] sortedDataSet = MergeSort.sort(dataSet);
        int[] expectedDataSet = { 2, 5, 21, 40, 43, 50, 67, 72, 87, 87, 89, 89, 100 };

        assertTrue(Arrays.equals(expectedDataSet, sortedDataSet));
    }

}