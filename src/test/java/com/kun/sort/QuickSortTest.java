package com.kun.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void quickSort() {
        QuickSort quickSort = new QuickSort();
        int[] nums = SortUtils.generate(5);
        System.out.println(Arrays.toString(nums));
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}