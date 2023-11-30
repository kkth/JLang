package com.kun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AeiouSortedStrings_1641 {
    public static void main(String[] args) {
        AeiouSortedStrings_1641 aeiouSortedStrings1641 = new AeiouSortedStrings_1641();
        System.out.println(aeiouSortedStrings1641.countVowelStrings(1));
        System.out.println(aeiouSortedStrings1641.countVowelStrings(2));
        System.out.println(aeiouSortedStrings1641.countVowelStrings(33));
    }

    public int countVowelStrings(int n) {
        String[] aeiou = new String[]{"a","e","i","o","u"};
        int sum = 0;
        ArrayList<Map<String,Integer>> counts = new ArrayList<Map<String, Integer>>();
        Map<String,Integer> count1 = new HashMap<>();
        for(String s: aeiou)
            count1.put(s,1);
        counts.add(count1);

        int i = 1;
        for(;i<n;i++) {
           Map<String,Integer> lastCounts = counts.get(i-1);
           Map<String,Integer> count = new HashMap<>();
            for(String s:aeiou){
                if(s.equals("a"))//deal with result in last round ends with a
                {
                    count.put("a",lastCounts.get("a"));
                    count.put("e",lastCounts.get("a"));
                    count.put("i",lastCounts.get("a"));
                    count.put("o",lastCounts.get("a"));
                    count.put("u",lastCounts.get("a"));
                }
                if(s.equals("e"))//deal with
                {
                    count.put("e",count.get("e") + lastCounts.get("e"));
                    count.put("i",count.get("i") + lastCounts.get("e"));
                    count.put("o",count.get("o") + lastCounts.get("e"));
                    count.put("u",count.get("u") + lastCounts.get("e"));
                }
                if(s.equals("i"))//deal with
                {
                    count.put("i",count.get("i") + lastCounts.get("i"));
                    count.put("o",count.get("o") + lastCounts.get("i"));
                    count.put("u",count.get("u") + lastCounts.get("i"));
                }
                if(s.equals("o"))//deal with
                {
                    count.put("o",count.get("o") + lastCounts.get("o"));
                    count.put("u",count.get("u") + lastCounts.get("o"));
                }
                if(s.equals("u"))//deal with
                {
                    count.put("u",count.get("u") + lastCounts.get("u"));
                }
            }
            counts.add(count);
        }


        Map<String,Integer> lastCount = counts.get(i-1);
        for (Map.Entry<String,Integer> entry: lastCount.entrySet()){
            sum += entry.getValue();
        }

        return sum;
    }
}
