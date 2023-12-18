package com.kun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Combination_77 {
    public static void main(String[] args) {

        Combination_77 combination77 = new Combination_77();
        List<List<Integer>> ret = combination77.combine(4,2);
        System.out.println(Arrays.toString(ret.toArray()));

        ret = combination77.combine(10,4);
        System.out.println(Arrays.toString(ret.toArray()));
        System.out.println(ret.size());

        ret = combination77.combine(1,1);
        System.out.println(Arrays.toString(ret.toArray()));
    }



    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n<=0 || k>n)
            return ret;
        Stack<Integer> path = new Stack<>();
        int curIndex = 1;

        stepInto(n, k, path, curIndex,ret);

        return ret;
    }

    public void stepInto(int n, int k, Stack<Integer> path, int curIndex,List<List<Integer>> ret){
        for(int i = curIndex;i<=n;i++){
            path.add(i);
            if(path.size() == k){//Reach the limit, a new combination is generated
                Object[] arr = path.toArray();
                List<Integer> curCombination = new ArrayList<>();
                for(Object o:arr){
                    curCombination.add((Integer) o);
                }
                ret.add(curCombination);
            } else{
                stepInto(n,k,path,i+1,ret);
            }
            path.pop();
        }
    }
}
