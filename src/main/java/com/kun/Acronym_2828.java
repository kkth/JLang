package com.kun;

import java.util.Arrays;
import java.util.List;

public class Acronym_2828 {
    public static void main(String[] args) {
        Acronym_2828 acronym2828 = new Acronym_2828();
        System.out.println(acronym2828.isAcronym(Arrays.asList(new String[]{"abc","def"}),"ad"));
    }

    public boolean isAcronym(List<String> words, String s) {
        if(words == null || s.isEmpty() || words.size() != s.length()){
            return false;
        }
        int index = 0;
        for(String w: words){
           if(!w.substring(0,1).equals(s.substring(index,index+1))){
              return false;
           }
           index++;
        }
        return true;
    }
}
