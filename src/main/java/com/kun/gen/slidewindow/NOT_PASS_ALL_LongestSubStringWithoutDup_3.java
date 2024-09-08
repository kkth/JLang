package com.kun.gen.slidewindow;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NOT_PASS_ALL_LongestSubStringWithoutDup_3 {
    public static void main(String[] args) {
        NOT_PASS_ALL_LongestSubStringWithoutDup_3 longestSubStringWithoutDup3 = new NOT_PASS_ALL_LongestSubStringWithoutDup_3();

        String s = "aab";
        System.out.println(s);
        System.out.println(longestSubStringWithoutDup3.lengthOfLongestSubstring(s));
        s = "bbbbbb";
        System.out.println(s);
        System.out.println(longestSubStringWithoutDup3.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(s);
        System.out.println(longestSubStringWithoutDup3.lengthOfLongestSubstring(s));

    }
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        char[] theCharacters = s.toCharArray();
        List<String> theCharList = new ArrayList<>();
        for(char c:theCharacters){
            theCharList.add(String.valueOf(c));
        }

        Set<String> curChars = new HashSet<>();
        List<String> curSubString = new ArrayList<>();
        for(String theChar : theCharList){
            if(curChars.contains(theChar)){
                if(curSubString.size() > maxLen){
                    maxLen = curSubString.size();
                }
                for(int i = 0;i<curSubString.size();i++){
                    curChars.remove(curSubString.get(i));
                    if(curSubString.get(i).equals(theChar)){
                        curSubString = curSubString.subList(i+1,curSubString.size());
                    }
                }

            }
            curChars.add(theChar);
            curSubString.add(theChar);
        }

        if(curSubString.size() > maxLen)
            maxLen = curSubString.size();

        return maxLen;
    }
}
