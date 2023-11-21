package com.kun.sort;

import java.util.Arrays;

public class SortUtils {
    public static int[] generate(int low, int high, int count){
        int[] ret = new int[count];
        for(int i = 0;i<count;i++){
           double random = Math.random();
           ret[i] = (int) (random * high - random * low + low);
        }

        return ret;
    }
    public static int[] generate(int count){
        return generate(0,100,count);
    }
    public static void print(int[] nums){
        System.out.println(Arrays.toString(nums));
    }
}

