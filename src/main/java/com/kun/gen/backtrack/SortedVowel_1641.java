package com.kun.gen.backtrack;

import java.util.*;

public class SortedVowel_1641 {
    public static void main(String[] args) {
        SortedVowel_1641 sortedVowel1641 = new SortedVowel_1641();
        System.out.println(sortedVowel1641.countVowelStrings(33));
    }

    public int countVowelStrings(int n) {
        String[] vowels = new String[]{"a","e","i","o","u"};
        List<List<String>> result = new ArrayList<>();
        Stack<String> path  = new Stack<>();
        Set<String> used = new HashSet<>();

        backtrack(n,vowels,0,result,path);

        /*
        for(List<String> thePath:result){
            System.out.println(thePath);
        }

         */

        return result.size();
    }

    public void backtrack(int count, String[] vowels, int curIndex,List<List<String>> result,Stack<String> path ){
        for(int i = curIndex;i<vowels.length;i++){
            path.push(vowels[i]);
            if(path.size() == count){
                result.add(path.subList(0,path.size()));
            } else{
                backtrack(count,vowels,i,result,path);
            }
            path.pop();
        }

    }
}
