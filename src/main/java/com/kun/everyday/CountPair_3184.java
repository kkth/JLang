package com.kun.everyday;

import java.util.*;

public class CountPair_3184 {
    public static void main(String[] args) {
        CountPair_3184 countPair3184 = new CountPair_3184();

        int[] hours = new int[]{12,12,30,24,24};
        System.out.println(countPair3184.countCompleteDayPairs(hours));

        hours = new int[]{72,48,24,3};
        System.out.println(countPair3184.countCompleteDayPairs(hours));
    }

    public int countCompleteDayPairs(int[] hours) {
        int pairCount = 0;
        Map<Integer, List<Integer>> toBeMatched = new HashMap<>();
        for(int cur: hours){
            int matchKey = cur%24;
            if(toBeMatched.containsKey(matchKey)){
                pairCount += toBeMatched.get(matchKey).size();
            }

            /*
            *    0  1  2  3... 22 23
            *    0
            *    24 23 22 21    2  1
            *
            * */

            //实现太丑
            int curKey = 24 - cur%24;
            if(curKey == 24){
                curKey = 0;
            }
            if(toBeMatched.containsKey(curKey)){
                List<Integer> theList = toBeMatched.get(curKey);
                theList.add(cur);
            }else{
                List<Integer> theList = new ArrayList<>();
                theList.add(cur);
                toBeMatched.put(curKey,theList);
            }
        }


        return pairCount;
    }
}
