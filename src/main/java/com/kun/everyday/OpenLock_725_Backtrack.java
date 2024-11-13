package com.kun.everyday;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class OpenLock_725_Backtrack {
    public static void main(String[] args) {
        OpenLock_725_Backtrack openLock725Backtrack = new OpenLock_725_Backtrack();
        String[] deadEnds = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock725Backtrack.openLock(deadEnds,target));
    }

    public int openLock(String[] deadEnds, String target) {
        List<String> deadList = new ArrayList<>();
        for(String str: deadEnds){
            deadList.add(str);
        }
        Set<String> visited = new HashSet<>();
        Stack<String> path = new Stack<>();
        List<List<String>> solutions = new ArrayList<>();
        int minStep = -1;
        List<String> minStepPath = new ArrayList<>();

        String curNum = "0000";
        backTrack(curNum,target,visited,deadList,path,solutions);

        visited.add(curNum);

        for(List<String> solution: solutions){
            if(minStep == -1 ||path.size() < minStep){
                minStep = path.size();
                minStepPath = solution;
            }
        }

        System.out.println(Arrays.toString(minStepPath.toArray()));
        System.out.println(minStep);

        return minStep;
    }

    void backTrack(String curNums, String target, Set<String> visited,
                   List<String> deadList, Stack<String> path, List<List<String>> solutions ){
        System.out.println(curNums);
        List<String> nextSteps = new ArrayList<>();
        for(int i = 0;i<=3;i++){
            String cur = curNums.substring(i,i+1);
            String prefix = "";
            String postfix = "";
            try {
                prefix = curNums.substring(0, i);
            }catch (Exception e){}
            try {
                postfix = curNums.substring(i + 1, 4);
            }catch (Exception e){}

            int curNum = Integer.parseInt(cur);
            String newCurStrNext = "";
            String newCurStrPrev = "";
            if(curNum == 0){
               newCurStrNext = "1";
               newCurStrPrev = "9";
            }else if(curNum == 9){
               newCurStrNext = "0";
               newCurStrPrev = "8";
            }else{
                newCurStrNext = Integer.toString(curNum + 1);
                newCurStrPrev = Integer.toString(curNum -1);
            }

            String newStrNext = prefix + newCurStrNext + postfix;
            String newStrPrev = prefix + newCurStrPrev + postfix;

            if(!deadList.contains(newStrNext) && !visited.contains(newStrNext)){
                nextSteps.add(newStrNext);
            }
            if(!deadList.contains(newStrPrev) && !visited.contains(newStrPrev)){
                nextSteps.add(newStrPrev);
            }
        }

        for(String nextStep: nextSteps) {
            path.push(nextStep);
            visited.add(nextStep);

            if (nextStep.equals(target)) {
                List<String> pathSoFar = new ArrayList<>(path);
                solutions.add(pathSoFar);
            } else {
                backTrack(nextStep,target,visited,deadList,path,solutions);
            }

            path.pop();
        }

    }


}
