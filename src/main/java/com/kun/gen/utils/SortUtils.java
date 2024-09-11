package com.kun.gen.utils;

import java.util.Arrays;

public class SortUtils {
    public static int[] genRandom(int max, int count){
        int[] result = new int[count];
        for(int i = 0;i<count;i++){
            result[i] = (int) (Math.random()*max);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SortUtils.genRandom(100,10)));
    }
}
