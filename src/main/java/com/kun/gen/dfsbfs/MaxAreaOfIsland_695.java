package com.kun.gen.dfsbfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxAreaOfIsland_695 {
    public static void main(String[] args) {
        MaxAreaOfIsland_695 maxAreaOfIsland695 = new MaxAreaOfIsland_695();
        int[][] grid =
                {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
       System.out.println(maxAreaOfIsland695.maxAreaOfIsland(grid));

       int [][] grid2 = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland(grid2));
    }
    public int maxAreaOfIsland(int[][] grid) {
        class Coordinate {
            int i;
            int j;

            Coordinate(int i, int j){
                this.i = i;
                this.j = j;
            }

            @Override
            public String toString() {
                return "Coordinate{" +
                        "i=" + i +
                        ", j=" + j +
                        '}';
            }
        }


        int rows = grid.length;
        int cols = grid[0].length;
        int [][] visited = new int[rows][cols];
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                visited[i][j] = 0;
            }
        }

        int maxArea = 0;
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                if(visited[i][j] == 1){
                    continue;
                }
                visited[i][j] = 1;
                if(grid[i][j] == 0){
                    continue;
                }else{
                    Deque<Coordinate> dfs = new ArrayDeque<>();
                    dfs.add(new Coordinate(i,j));
                    int curArea = 0;
                    while(!dfs.isEmpty()){
                        Coordinate cur = dfs.removeFirst();
                        curArea++;
                        //upper
                        if(cur.i - 1 >=0 && visited[cur.i-1][cur.j] != 1){//
                            if(grid[cur.i-1][cur.j] == 1) {//land found
                                visited[cur.i-1][cur.j] = 1;
                                dfs.add(new Coordinate(cur.i-1,cur.j));
                            }
                        }
                        //down
                        if(cur.i + 1 <rows && visited[cur.i+1][cur.j] != 1){//
                            if(grid[cur.i+1][cur.j] == 1) {//land found
                                visited[cur.i+1][cur.j] = 1;
                                dfs.add(new Coordinate(cur.i+1,cur.j));
                            }
                        }
                        //left
                        if(cur.j-1 >=0 && visited[cur.i][cur.j-1] != 1){//
                            if(grid[cur.i][cur.j-1] == 1) {//land found
                                visited[cur.i][cur.j-1] = 1;
                                dfs.add(new Coordinate(cur.i,cur.j-1));
                            }
                        }
                        //right
                        if(cur.j + 1 <cols && visited[cur.i][cur.j+1] != 1){//
                            if(grid[cur.i][cur.j+1] == 1) {//land found
                                visited[cur.i][cur.j+1] = 1;
                                dfs.add(new Coordinate(cur.i,cur.j+1));
                            }
                        }
                    }

                    if(curArea > maxArea){
                        maxArea = curArea;
                    }

                }

            }
        }


        return maxArea;
    }
}
