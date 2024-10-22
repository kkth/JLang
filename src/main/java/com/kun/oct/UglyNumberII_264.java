package com.kun.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UglyNumberII_264 {
    public static void main(String[] args) {

    }
/*
    public int nthUglyNumber(int n) {
        int[] uglyFactors = new int[]{2,3,5};

        int cur = 0;
        List<Integer> uglyNumbers = new ArrayList<>();
        while(uglyNumbers.size()<n){
            cur++;
            for(Integer factor: uglyFactors){
                if(cur%factor == 0 && uglyNumbers.contains(Integer.valueOf(cur/factor))){
                   uglyNumbers.add(cur);
                   break;
                }
            }
        }


        return uglyNumbers.getLast();
    }

 */
}
