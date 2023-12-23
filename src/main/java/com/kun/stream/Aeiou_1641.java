package com.kun.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Aeiou_1641 {
    public static void main(String[] args) {
        Aeiou_1641 aeiou1641 = new Aeiou_1641();
       System.out.println(aeiou1641.countVowelStrings(1));
       System.out.println(aeiou1641.countVowelStrings(2));
        System.out.println(aeiou1641.countVowelStrings(33));
        System.out.println(aeiou1641.countVowelStrings(50));


    }

    public int countVowelStrings(int n) {
        if(n<=0)
            return 0;

        String[] aeiou = new String[]{"a","e","i","o","u"};
        List<List<String>> ret = new ArrayList<>();
        Stack<String> path = new Stack<>();
        stepInto(aeiou,0,ret,path,n);
        //System.out.println(Arrays.toString(ret.toArray()));

        return ret.size();
    }

    public void stepInto(String[] aeiou, int curIndex, List<List<String>> ret,Stack<String> path,int n){
        for(int i = curIndex;i<aeiou.length;i++){
            path.add(aeiou[i]);
            if(path.size() == n){
               List<String> solution = new ArrayList<>();
               Object[] arr =  path.toArray();
               for(Object o:arr){
                   solution.add((String)o);
               }
               ret.add(solution);
            }else{
                stepInto(aeiou,i,ret,path,n);
            }
            path.pop();
        }
    }
}
