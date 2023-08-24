package com.kun.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class SortUtilsTest {

    @Test
    void generate() {
       int[] array = SortUtils.generate(0,10,5);
       System.out.println(Arrays.toString(array));
       assertEquals(array.length,5);
    }

    @Test
    void testGenerate() {
    }
}