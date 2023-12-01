package com.kun;

import java.util.*;

public class ClosedStrings_1657 {
    public static void main(String[] args) {
        ClosedStrings_1657 closedStrings1657 = new ClosedStrings_1657();
        System.out.println(closedStrings1657.closeStrings("abc","bca"));
        System.out.println(closedStrings1657.closeStrings("cabbba","abbccc"));
        System.out.println(closedStrings1657.closeStrings("cabbba","aabbss"));
    }

    public boolean closeStrings(String word1, String word2) {
        if(word1 == null || word2 == null)
            return false;
        if(word1.length() != word2.length())
            return false;
        if(word1.equals(word2))
            return true;

        //Get unique chars
        char[] chars = word1.toCharArray();
        Set<String> uniqChars = new HashSet<>();
        for(char c: chars){
            uniqChars.add(String.valueOf(c));
        }

        //Get pairs
        List<List<String>> charPairs = new ArrayList<>();


        List<String> uniqStrList = new ArrayList<>();
        for(String s: uniqChars){
            uniqStrList.add(s);
        }
        for(int i = 0; i < uniqStrList.size()-1;i++){
            for(int j = i+1;j<uniqStrList.size();j++){
                List<String> pair = new ArrayList<>();
                pair.add(uniqStrList.get(i));
                pair.add(uniqStrList.get(j));
                charPairs.add(pair);
            }
        }

        Set<String> processed = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.add(word1);
        processed.add(word1);
        while(!queue.isEmpty()){
            String s = queue.poll();
            //swap
            for(int i = 0;i<s.length()-1;i++){
                for(int j =i+1;j<s.length();j++){
                   String toSwapped = String.copyValueOf(s.toCharArray());
                   char l = toSwapped.charAt(i);
                   char r = toSwapped.charAt(j);
                   char[] charArray = toSwapped.toCharArray();
                   charArray[i] = r;
                   charArray[j] = l;
                   String swapped = new String(charArray);
                   if(swapped.equals(word2)){
                       return true;
                   }

                   if(!processed.contains(swapped)){
                       queue.add(swapped);
                       processed.add(swapped);
                   }


                }
            }

            //substitute
            //
            for(List<String> pair: charPairs){
                char c1 = pair.get(0).toCharArray()[0];
                char c2 = pair.get(1).toCharArray()[0];

                char[] theChars = s.toCharArray();
                for(int i = 0;i<theChars.length;i++){
                    if(theChars[i] == c1){
                        theChars[i] = c2;
                    }else if(theChars[i] == c2){
                       theChars[i] = c1;
                    }
                }
                String newStr = new String(theChars);
                if(newStr.equals(word2)){
                   return true;
                }

                if(!processed.contains(newStr)){
                    queue.add(newStr);
                    processed.add(newStr);
                }

            }



        }

        return  false;
    }
}
