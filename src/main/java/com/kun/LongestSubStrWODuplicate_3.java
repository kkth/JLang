package com.kun;

import java.util.*;

public class LongestSubStrWODuplicate_3 {
    public static void main(String[] args) {

        LongestSubStrWODuplicate_3 longestSubStrWODuplicate3 = new LongestSubStrWODuplicate_3();
        longestSubStrWODuplicate3.lengthOfLongestSubstring("12345");
        longestSubStrWODuplicate3.lengthOfLongestSubstring("abcabcbb");
        longestSubStrWODuplicate3.lengthOfLongestSubstring("bbbbb");
        longestSubStrWODuplicate3.lengthOfLongestSubstring("pwwkew");
    }

    int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        int maxLen = -1, lAtMax = -1, rAtMax = -1;
        Map<Integer,List<List<Integer>>> records = new HashMap<>();


        int l = 0;
        Set<String> setsInWindow = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            String cur = s.substring(i,i+1);
            //Found it
            if(setsInWindow.contains(cur)){
               while(true) {
                   //Remove any character before remove the duplicated one
                   String toBeRemoved = s.substring(l, l + 1);
                   setsInWindow.remove(toBeRemoved);
                   l++;
                  //The duplicated one is removed, stop here
                   if(toBeRemoved.equals(cur))
                       break;
               }
               setsInWindow.add(cur);
            }else{//Just put and move window forward
               setsInWindow.add(cur);
            }

            //Keep all the same length when >= is used here
            if(i-l+1 >= maxLen){
                maxLen = i-l+1;
                lAtMax = l;
                rAtMax = i;

                List<Integer> curWindow = new ArrayList<>();
                curWindow.add(lAtMax);
                curWindow.add(rAtMax);

                List<List<Integer>> value = records.get(maxLen);
                if(value == null){
                    value = new ArrayList<>();
                    value.add(curWindow);
                    records.put(maxLen,value);
                }else{
                    value.add(curWindow);
                }
            }
        }

        List<List<Integer>> values = records.get(maxLen);
        System.out.println("max len = " + maxLen + ", the index =" + Arrays.toString(values.toArray()));
        return maxLen;
    }
}
