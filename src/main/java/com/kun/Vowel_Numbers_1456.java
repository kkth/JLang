package com.kun;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Vowel_Numbers_1456 {
    public static void main(String[] args) {
        Vowel_Numbers_1456 vowelNumbers1456 = new Vowel_Numbers_1456();
        System.out.println(vowelNumbers1456.maxVowels("abciiidef",3));
        System.out.println(vowelNumbers1456.maxVowels("aeiou",2));
        System.out.println(vowelNumbers1456.maxVowels("leetcode",3));
        System.out.println(vowelNumbers1456.maxVowels("rhythms",4));
        System.out.println(vowelNumbers1456.maxVowels("tryhard",4));

    }

    public int maxVowels(String s, int k) {
        Set<String> vowels = new HashSet<>(Arrays.asList(new String[]{"a", "e", "i", "o", "u"}));
        if (s.length() < k){
            return 0;
        }

        Set<String> window = new HashSet<>();
        int maxNum = 0;
        int curNum = 0;
        for(int l = 0,r = 0; r < s.length();r++){
            String cur = s.substring(r, r+1);
            if(vowels.contains(cur)){
                curNum++;
            }
            if(r-l+1 > k){//Exceed k, must remove the left
               String leftSide = s.substring(l,l+1);
               if(vowels.contains(leftSide)){
                  curNum--;
               }
               l++;
            }
            if(curNum > maxNum)
                maxNum = curNum;
        }
        return maxNum;
    }
}
