package com.kun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distribute_Cnadies_2928 {

    public static void main(String[] args) {
       Distribute_Cnadies_2928 distributeCnadies2928 = new Distribute_Cnadies_2928();
       System.out.println(distributeCnadies2928.distributeCandies(5,2));
       System.out.println(distributeCnadies2928.distributeCandies(3,3));
       System.out.println(distributeCnadies2928.distributeCandies(42,31));
    }

    public int distributeCandies(int n, int limit) {
        List<List<Integer>> solutions = new ArrayList<>();
        solutions.add(Arrays.asList(new Integer[]{0,0,0}));

        for (int i =1;i<=n;i++){
            List<List<Integer>> newCollections = new ArrayList<>();
            for(List<Integer> curSolution: solutions){
                int index = 0;
                for(Integer candy: curSolution){
                    if(candy < limit){//Just distribute to current child
                        List<Integer> newSolution = new ArrayList<>(curSolution);
                        newSolution.set(index,candy+1);
                        if(!newCollections.contains(newSolution)) {
                            newCollections.add(newSolution);
                        }
                    }
                    index ++;
                }
            }
            solutions = newCollections;
            System.out.println( Arrays.toString(solutions.toArray()));
        }
       return solutions.size();
    }
}
