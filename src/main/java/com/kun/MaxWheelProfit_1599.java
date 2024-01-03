package com.kun;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class MaxWheelProfit_1599 {

    public static void main(String[] args) {
        MaxWheelProfit_1599 maxWheelProfit1599 = new MaxWheelProfit_1599();
        int[] customers = new int[]{10, 9, 6};
        //System.out.println(maxWheelProfit1599.minOperationsMaxProfit(customers, 6, 4));
        customers = new int[]{0,43,37,9,23,35,18,7,45,3,8,24,1,6,37,2,38,15,1,14,39,27,4,25,27,33,43,8,44,30,38,40,20,5,17,27,43,11,6,2,30,49,30,25,32,3,18,23,45,43,30,14,41,17,42,42,44,38,18,26,32,48,37,5,37,21,2,9,48,48,40,45,25,30,49,41,4,48,40,29,23,17,7,5,44,23,43,9,35,26,44,3,26,16,31,11,9,4,28,49,43,39,9,39,37,7,6,7,16,1,30,2,4,43,23,16,39,5,30,23,39,29,31,26,35,15,5,11,45,44,45,43,4,24,40,7,36,10,10,18,6,20,13,11,20,3,32,49,34,41,13,11,3,13,0,13,44,48,43,23,12,23,2};
        System.out.println(maxWheelProfit1599.minOperationsMaxProfit(customers, 43, 54));
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = 0;
        int income = 0;
        int cost = 0;

        Deque<Integer> wheel = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            wheel.addLast(0);
        }
        int peopleInWheel = 0;
        int waitingPeople = 0;
        int interval = 0;
        int rollings = 0;
        int rollingForMaxProfile = 0;

        while (interval <customers.length || waitingPeople != 0) {
            if(interval <customers.length) {
                int cur = customers[interval];
                waitingPeople += cur;
                interval ++;
            }

            //How about just stop now?
            int profileIfStopHere = income - cost;
            if (profileIfStopHere > maxProfit) {
                maxProfit = profileIfStopHere;
                rollingForMaxProfile = rollings;
            }

            //It seems that this is not a valid assumption
            /*
            if (waitingPeople == 0 && peopleInWheel == 0) {
                continue;
            } else {
             */
                if (waitingPeople != 0) {
                    int onboardPeople = 0;
                    if (waitingPeople >= 4) {
                        onboardPeople = 4;
                    } else if (waitingPeople > 0) {
                        onboardPeople = waitingPeople;
                    }
                    waitingPeople -= onboardPeople;
                    income += onboardPeople * boardingCost;
                    wheel.addLast(onboardPeople);
                } else {
                    wheel.addLast(0);
                }
                int jumpOff = wheel.removeFirst();
                peopleInWheel -= jumpOff;
                cost += runningCost;

                rollings++;
                profileIfStopHere = income - cost;
                if (profileIfStopHere > maxProfit) {
                    maxProfit = profileIfStopHere;
                    rollingForMaxProfile = rollings;
                }

                System.out.println("For rolling " + rollings + "," + Arrays.toString(wheel.toArray()) + "," +income + "," + cost + "," + profileIfStopHere);
          //  }
        }
        return maxProfit>0? rollingForMaxProfile:-1;
    }
}