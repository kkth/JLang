package com.kun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxStudents_1349 {
    public static void main(String[] args) {
        MaxStudents_1349 maxStudents1349 = new MaxStudents_1349();
        char[][] seats = new char[][]{{'#','.','#','#','.','#'},
                {'.','#','#','#','#','.'},
                {'#','.','#','#','.','#'}};
        System.out.println(maxStudents1349.maxStudents(seats));

        seats = new char[][] {{'.','#','#','.','#','#','#'},{'.','#','#','.','.','.','.'},{'#','#','.','.','#','#','#'},{'.','.','.','#','#','.','.'},{'.','#','#','.','.','.','#'},{'.','.','.','.','.','#','.'}};
        System.out.println(maxStudents1349.maxStudents(seats));


    }

    public int maxStudents(char[][] seats) {
        //  System.out.println(Arrays.deepToString(seats));
        List<List<Integer>> solutions = new ArrayList<>();
        int max = 0;
        /*
        -1 = malformed seat
        0  = good seat but no one sit here
        1  = good seat and allocated to someone
         */
        Stack<Integer> path = new Stack<>();
        stepInto(seats,path,solutions);

        System.out.println("how many solutions: " + solutions.size());
        int index = -1, maxIndex = -1;
        for(List<Integer> solution: solutions){
            int sum = 0;
            index++;
            for(Integer seatUsage :solution){
                if(seatUsage == 1){
                    sum++;
                }
            }
            if(sum > max){
                max = sum;
                maxIndex = index;
            }
        }

        System.out.println("maxIndex" + maxIndex);
        //Just for debug
        int rowNum = seats.length;
        int colNum = seats[0].length;

        List<Integer> maxSolution = solutions.get(maxIndex);
        for(int i = 0;i< maxSolution.size();i++){
            if(maxSolution.get(i) == 1){
                int rowIndex = i / colNum;
                int colIndex = i - rowIndex * colNum;
                seats[rowIndex][colIndex] = 'S';
            }
        }
        // System.out.println(Arrays.deepToString(seats));
        //Just for debug
        return max;
    }

    public int stepInto(char[][] seats, Stack<Integer> path,List<List<Integer>> solutions){
        int max = 0;
        int rowNum = seats.length;
        int colNum = seats[0].length;
        //Get current seat to be processed
        int lineIndexToBeProcess = path.size();
        int rowIndex = lineIndexToBeProcess / colNum;
        int colIndex = lineIndexToBeProcess - rowIndex * colNum;
        char curSeat = seats[rowIndex][colIndex];

        for(int sitOrNot = 0; sitOrNot<=1; sitOrNot++){//2 choices: not allocate or allocate
            if (curSeat == '#') {//Skip it
                path.add(-1);
                sitOrNot++;//skip next choice
            }else {
                if (sitOrNot == 0) {
                    //No one sit here, no check is needed,just step to next seat
                    path.add(0);
                } else {
                    //Check left,right, upper left and upper right
                    Object[] arr = path.toArray();
                    boolean leftOK = colIndex - 1 < 0 || (Integer) arr[rowIndex * colNum + (colIndex - 1)] == -1 || (Integer) arr[rowIndex * colNum + (colIndex - 1)] == 0;
                    //boolean rightOK = colIndex+1 >= colNum || (Integer)arr[rowIndex*colNum + (colIndex+1)] == -1 || (Integer)arr[rowIndex*colNum + (colIndex+1)] == 0;
                    boolean rightOK = true;
                    boolean upperLeftOK = colIndex - 1 < 0 || rowIndex - 1 < 0 || (Integer) arr[(rowIndex - 1) * colNum + (colIndex - 1)] == -1 || (Integer) arr[(rowIndex - 1) * colNum + (colIndex - 1)] == 0;
                    boolean upperRightOK = colIndex + 1 >= colNum || rowIndex - 1 < 0 || (Integer) arr[(rowIndex - 1) * colNum + (colIndex + 1)] == -1 || (Integer) arr[(rowIndex - 1) * colNum + (colIndex + 1)] == 0;
                    if (leftOK && rightOK && upperLeftOK && upperRightOK) {
                        path.add(1);
                    } else {
                        path.add(0);
                    }
                }
            }

            if(path.size() == rowNum*colNum){//Reach the last seat, get a solution
                List<Integer> solution = new ArrayList<>();
                Object[] arr = path.toArray();
                for(Object o: arr){
                    solution.add((Integer) o);
                }
                solutions.add(solution);
            }else {
                stepInto(seats, path, solutions);
            }
            path.pop();
        }

        return max;
    }
}

