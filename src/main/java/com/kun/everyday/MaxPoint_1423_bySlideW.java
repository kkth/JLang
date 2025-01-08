package com.kun.everyday;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxPoint_1423_bySlideW {
    public static void main(String[] args) {
        int[] cardPoints = new int[]{1,2,3,4,5,6,1};
        int k = 3;
        MaxPoint_1423_bySlideW maxPoint1423 = new MaxPoint_1423_bySlideW();
        System.out.println(maxPoint1423.maxScore(cardPoints,k));

        cardPoints = new int[]{2,2,2};
        k = 2;
        System.out.println(maxPoint1423.maxScore(cardPoints,k));
    }

    public int maxScore(int[] cardPoints, int k) {
        int windowSize = (cardPoints.length -k)>=0?cardPoints.length -k:0;
        Deque<Integer> window = new ArrayDeque<>();
        int totalSum = 0;
        int windowSum = 0;
        int minSum = 0;
        for (int cardPoint : cardPoints) {
            totalSum += cardPoint;
            window.addLast(cardPoint);
            windowSum += cardPoint;
            if (window.size() > windowSize) {
                int removed = window.removeFirst();
                windowSum -= removed;
            }

            if(window.size() == windowSize) {
                if (minSum == 0) {
                    minSum = windowSum;
                } else if (windowSum < minSum) {
                    minSum = windowSum;
                }
            }
        }

        System.out.println(Arrays.toString(window.toArray()));

        return totalSum -minSum;
    }
}
