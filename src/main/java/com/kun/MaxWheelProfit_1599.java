package com.kun;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class MaxWheelProfit_1599 {

    public static void main(String[] args) {
        MaxWheelProfit_1599 maxWheelProfit1599 = new MaxWheelProfit_1599();
        int[] customers = new int[]{10, 9, 6};
        System.out.println(maxWheelProfit1599.minOperationsMaxProfit(customers, 6, 4));
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
            }

            if (waitingPeople == 0 && peopleInWheel == 0) {
                continue;
            } else {
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

                profileIfStopHere = income - cost;
                if (profileIfStopHere > maxProfit) {
                    maxProfit = profileIfStopHere;
                }

                //System.out.println(Arrays.toString(wheel.toArray()) + "," +income + "," + cost);
            }
        }
        return maxProfit>0? maxProfit:-1;
    }
}