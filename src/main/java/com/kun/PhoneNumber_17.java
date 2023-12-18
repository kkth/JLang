package com.kun;

import java.util.*;

public class PhoneNumber_17 {
    public static void main(String[] args) {
        PhoneNumber_17 phoneNumber17 = new PhoneNumber_17();
        List<String> ret = phoneNumber17.letterCombinations("23");
        System.out.println(Arrays.toString(ret.toArray()));

        ret = phoneNumber17.letterCombinations("");
        System.out.println(Arrays.toString(ret.toArray()));

        ret = phoneNumber17.letterCombinations("2");
        System.out.println(Arrays.toString(ret.toArray()));

        ret = phoneNumber17.letterCombinations("366");
        System.out.println(Arrays.toString(ret.toArray()));
    }


    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits.isEmpty())
            return ret;

        Map<String,List<String>> keyboard = new HashMap<>();
        keyboard.put("1",new ArrayList<>());
        keyboard.put("2",Arrays.asList(new String[]{"a","b","c"}));
        keyboard.put("3",Arrays.asList(new String[]{"d","e","f"}));
        keyboard.put("4",Arrays.asList(new String[]{"g","h","i"}));
        keyboard.put("5",Arrays.asList(new String[]{"j","k","l"}));
        keyboard.put("6",Arrays.asList(new String[]{"m","n","o"}));
        keyboard.put("7",Arrays.asList(new String[]{"p","q","r","s"}));
        keyboard.put("8",Arrays.asList(new String[]{"t","u","v"}));
        keyboard.put("9",Arrays.asList(new String[]{"w","x","y","z"}));

        Stack<String> path = new Stack<>();

        List<String> numbers = new ArrayList<>();
        for(int i = 0;i<digits.length();i++){
           numbers.add(digits.substring(i,i+1));
        }
        int curIndex = 0;

        stepInto(ret, path,numbers,0,numbers.size(),keyboard);

        return ret;
    }

    public void stepInto(List<String> ret, Stack<String> path, List<String> numbers, int curIndex, int numberLen, Map<String,List<String>> keyboard){
        List<String> curKey = keyboard.get(numbers.get(curIndex));

        for(String alpha: curKey){
           path.add(alpha);
           if(path.size() == numberLen){
                String[] alphas = new String[numberLen];
                path.toArray(alphas);
                StringBuilder sb = new StringBuilder();
                for(String elem: alphas){
                    sb.append(elem);
                }
                ret.add(sb.toString());
           }else{
                stepInto(ret,path,numbers,curIndex+1,numberLen,keyboard);
           }

           path.pop();
        }

    }



}
