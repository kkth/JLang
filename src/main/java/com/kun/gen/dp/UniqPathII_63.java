package com.kun.gen.dp;

public class UniqPathII_63 {
    public static void main(String[] args) {
       UniqPathII_63 uniqPathII63 = new UniqPathII_63();
       int [][] obstacle = new int[][] {{0,0,0},{0,1,0},{0,0,0}};

       System.out.println(uniqPathII63.uniquePathsWithObstacles(obstacle));

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][] path = new int[m+1][n+1];
        for(int i = 0;i<m+1;i++){
           path[i][0] = 0;
        }
        for(int j = 0;j<n+1;j++){
            path[0][j] = 0;
        }

        for(int i = 1;i<m+1;i++){
            for(int j = 1;j<n+1;j++){
                if(obstacleGrid[i-1][j-1] == 1){
                    path[i][j] =0;
                }else{
                    if(i==1&&j==1){
                        path[i][j] = 1;
                    }else{
                        path[i][j] = path[i][j-1] + path[i-1][j];
                    }
                }
            }
        }

        return path[m][n];
    }
}
