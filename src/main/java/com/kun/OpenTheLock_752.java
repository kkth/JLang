package com.kun;

import java.util.*;

public class OpenTheLock_752 {
    public static void main(String[] args){
       OpenTheLock_752 openTheLock752 = new OpenTheLock_752();
       String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
       String target = "0202";
       System.out.println(openTheLock752.openLock(deadends,target));
    }

    public int openLock(String[] deadends, String target) {
        int ret = -1;
        //Object to represent
        class Status {
            String number;
            int stepCount;
            List<String> _theSteps;

            Status(String num,int step,List<String> _parentSteps){
                this.number = num;
                this.stepCount = step;
                _theSteps = new ArrayList<>();
                if(_parentSteps != null) {
                    _theSteps.addAll(_parentSteps);
                }
                _theSteps.add(num);
            }
        }

        Deque<Status> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));

        queue.add(new Status("0000",0,null));

        while(!queue.isEmpty()){
            Status curStatus = queue.pop();
            visited.add(curStatus.number);

            //8 possible next number
            String curNum = curStatus.number;
            int curStep = curStatus.stepCount;

            if(curNum.equals(target)) {
                System.out.println(Arrays.toString(curStatus._theSteps.toArray()));
                return curStep;
            }

            for(int i = 0;i<4;i++){
                String head = curNum.substring(0,i);
                String current = curNum.substring(i,i+1);
                String tail = curNum.substring(i+1,4);
                int curDigit = Integer.parseInt(current);
                String curPrev = "",curNext = "";

                if(curDigit==0){
                   curPrev = "9";
                   curNext = "1";
                }else if (curDigit == 9){
                    curPrev = "8";
                    curNext = "0";
                }else {
                    curPrev = Integer.toString(curDigit - 1);
                    curNext = Integer.toString(curDigit + 1);
                }

                String newPrev = head + curPrev + tail;
                String newNext = head + curNext + tail;

                if(!visited.contains(newPrev)){
                    queue.add(new Status(newPrev,curStep+1, curStatus._theSteps));
                }
                if(!visited.contains(newNext)){
                    queue.add(new Status(newNext,curStep+1, curStatus._theSteps));
                }

            }
        }


        return ret;
    }
}
