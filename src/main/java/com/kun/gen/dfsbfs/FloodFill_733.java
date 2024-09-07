package com.kun.gen.dfsbfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FloodFill_733 {

    public static void main(String[] args) {

        FloodFill_733 floodFill733 = new FloodFill_733();
        int[][] image1 = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(image1));
        floodFill733.floodFill(image1,1,1,2);
        System.out.println(Arrays.deepToString(image1));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rows = image.length;
        int cols = image[0].length;

        int[][] visited = new int[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                visited[i][j] = 0;
            }
        }

        class Cell{
            int i;
            int j;

            Cell(int i,int j){
                this.i = i;
                this.j = j;
            }
        }

        int colorToBeReplaced = image[sr][sc];

        Deque<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(sr,sc));
        visited[sr][sc] = 1;
        while(!queue.isEmpty()){
            Cell cur = queue.removeFirst();
            image[cur.i][cur.j] = color;

            //left
            if(cur.j-1 >=0 && visited[cur.i][cur.j-1] != 1) {
               if(image[cur.i][cur.j-1] == colorToBeReplaced){
                   visited[cur.i][cur.j-1] =1;
                   queue.add(new Cell(cur.i, cur.j-1));
               }
            }
            //right
            if(cur.j+1 <cols &&visited[cur.i][cur.j+1] != 1) {
                if(image[cur.i][cur.j+1] == colorToBeReplaced){
                    visited[cur.i][cur.j+1] =1;
                    queue.add(new Cell(cur.i, cur.j+1));
                }
            }
            //upper
            if(cur.i-1 >=0 &&visited[cur.i-1][cur.j] != 1) {
                if(image[cur.i-1][cur.j] == colorToBeReplaced){
                    visited[cur.i-1][cur.j] =1;
                    queue.add(new Cell(cur.i-1, cur.j));
                }
            }
            //button
            if(cur.i+1<rows&&visited[cur.i+1][cur.j] != 1) {
                if(image[cur.i+1][cur.j] == colorToBeReplaced){
                    visited[cur.i+1][cur.j] =1;
                    queue.add(new Cell(cur.i+1, cur.j));
                }
            }

        }

        return image;
    }
}
