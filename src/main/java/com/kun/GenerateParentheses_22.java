package com.kun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses_22 {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        int lUsed = 0,rUsed = 0;
       List<List<String>> solutions = new ArrayList<>();
       Stack<String> path = new Stack<>();


       List<String> ret = new ArrayList<>();
       for(List<String> l: solutions){
           ret.add(Arrays.toString(l.toArray()));
       }
       return ret;
    }

    void dfs(int lUsed, int rUsed, int n, List<List<String>> solutions,Stack<String> path){
        
    }

}
