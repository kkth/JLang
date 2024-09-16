package com.kun.gen.dfsbfs;

import java.util.*;

public class MaxAreaOfIsland_695 {
    public static void main(String[] args) {
        MaxAreaOfIsland_695 maxAreaOfIsland695 = new MaxAreaOfIsland_695();
        int[][] grid =
                {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland(grid));
        System.out.println(maxAreaOfIsland695.maxAreaOfIslandByDfs(grid));

        System.out.println("===============");

        int [][] grid2 = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland695.maxAreaOfIsland(grid2));
        System.out.println(maxAreaOfIsland695.maxAreaOfIslandByDfs(grid2));
    }

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
    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int [][] visited = new int[rows][cols];
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                visited[i][j] = 0;
            }
        }
        List<List<Coordinate>> _islands = new ArrayList<>();

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
                    List<Coordinate> _currentIsland = new ArrayList<>();

                    Deque<Coordinate> dfs = new ArrayDeque<>();
                    dfs.add(new Coordinate(i,j));
                    int curArea = 0;
                    while(!dfs.isEmpty()){
                        Coordinate cur = dfs.removeFirst();
                        curArea++;
                        _currentIsland.add(cur);
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

                    _islands.add(_currentIsland);

                    if(curArea > maxArea){
                        maxArea = curArea;
                    }

                }

            }
        }

        for(List<Coordinate> island: _islands){
            System.out.println(Arrays.toString(island.toArray()));
        }

        return maxArea;
    }

    public int maxAreaOfIslandByDfs(int[][] grid) {
        int maxSize = -1;
        int rows = grid.length;
        int cols = grid[0].length;

        List<List<Coordinate>> _islands = new ArrayList<>();

        boolean [][] visited = new boolean[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                visited[i][j] = false;
            }
        }

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int curSize = 0;
                    List<Coordinate> _currentIsland = new ArrayList<>();

                    Stack<Coordinate> dfs = new Stack<>();
                    dfs.push(new Coordinate(i,j));
                    visited[i][j] = true;

                    while(!dfs.isEmpty()){
                        Coordinate cur = dfs.pop();
                        curSize++;
                        _currentIsland.add(cur);

                        //upper
                        if(check(cur.i-1,cur.j,rows,cols,visited,grid)){
                            dfs.push(new Coordinate(cur.i-1,cur.j));
                            visited[cur.i-1][cur.j] = true;
                        }
                        //right
                        if(check(cur.i,cur.j+1,rows,cols,visited,grid)){
                            dfs.push(new Coordinate(cur.i,cur.j+1));
                            visited[cur.i][cur.j+1] = true;
                        }
                        //bottom
                        if(check(cur.i+1,cur.j,rows,cols,visited,grid)){
                            dfs.push(new Coordinate(cur.i+1,cur.j));
                            visited[cur.i+1][cur.j] = true;
                        }
                        //left
                        if(check(cur.i,cur.j-1,rows,cols,visited,grid)){
                            dfs.push(new Coordinate(cur.i,cur.j-1));
                            visited[cur.i][cur.j-1] = true;
                        }
                    }

                    _islands.add(_currentIsland);

                    if(curSize > maxSize){
                        maxSize = curSize;
                    }
                }
            }
        }

        for(List<Coordinate> island: _islands){
            System.out.println(Arrays.toString(island.toArray()));
        }

        return maxSize;
    }

    boolean check(int i, int j, int rows, int cols,boolean [][] visited, int[][] grid){
        return i>=0 && i<rows && j>=0 && j<cols && !visited[i][j] && grid[i][j] ==1;
    }
}
