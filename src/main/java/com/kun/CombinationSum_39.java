package com.kun;

import java.util.*;

public class CombinationSum_39 {
    public static void main(String[] args) {
        CombinationSum_39 combinationSum39 = new CombinationSum_39();
        List<List<Integer>> result = combinationSum39.combinationSum(new int[]{2,3,6,7},7);
        System.out.println(Arrays.toString(result.toArray()));
        result = combinationSum39.combinationSum(new int[]{2,3,5},8);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Map to accommodate value and possible combination for this value
        Map<Integer,List<List<Integer>>> solutions = new HashMap<>();
        //Important! dummy combination and solution for 0
        //The single value from candidate for this value could not be inserted if
        //there's no such dummy data structure
        List<Integer> dummyCombination = new ArrayList<>();
        List<List<Integer>> dummyCollection = new ArrayList<>();
        dummyCollection.add(dummyCombination);
        solutions.put(0,dummyCollection);

        //Loop from 1 to target
        for(int i = 1;i<=target;i++){
            List<List<Integer>> currentSolution = new ArrayList<>();
            for(int candidate : candidates){
                //Only try to get previous combinations only when it's >=0
                //== 0 must be taken into consideration!
                if(i-candidate>=0){
                   List<List<Integer>> prevSolution = solutions.get(i-candidate);
                   if(prevSolution != null){
                     for(List<Integer> singleCombination: prevSolution){
                         List<Integer> newCombination = new ArrayList<>(singleCombination);
                         newCombination.add(candidate);
                         //Must sort so that the duplicate combination could be excluded
                         newCombination.sort(new Comparator<Integer>(){
                             @Override
                             public int compare(Integer o1, Integer o2) {
                                 return o1.compareTo(o2);
                             }
                         });
                         //Only record new combination
                         if(!currentSolution.contains(newCombination)){
                             currentSolution.add(newCombination);
                         }
                     }
                   }
                }
            }
            //Store possible combinations for this value
            solutions.put(i,currentSolution);
        }
        return solutions.get(target);
    }
}
