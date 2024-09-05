package com.kun.gen.dp;

/*
https://leetcode.cn/problems/unique-paths/
State transition equation
    current path number = path number from left cell + path number from above cell
    path[i,j] = path[i-1,j] + path[i,j-1]
 */
class UniqPath_62 {
    public static void main(String[] args) {
       UniqPath_62 uniqPath62 = new UniqPath_62();
       System.out.println(uniqPath62.uniquePaths(3,7));
       System.out.println(uniqPath62.uniquePaths(1,1));

    }
    public int uniquePaths(int m, int n) {
        //most left column and most upper row: guard with path number 0
        int [][] path = new int[m+1][n+1];

        for(int i = 0;i<=m;i++){
            path[i][0] = 0;
        }
        for(int j = 0;j<=n;j++){
            path[0][j] = 0;
        }

        for(int i= 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                //Special value for the first cell
                if(i==1 && j==1){
                    path[i][j] =1;
                } else {
                    path[i][j] = path[i][j - 1] + path[i - 1][j];
                }
            }
        }

        return path[m][n];
    }
}
