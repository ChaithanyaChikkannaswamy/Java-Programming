/*
* Question: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3764/
* Date: 06/02/2021
*/



class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i =0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1)
                    max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }
    
    public int dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0)
            return 0;
        
        int count = 1;
        grid[i][j] = 0;
        count += dfs(grid, i+1, j);
        count += dfs(grid, i-1, j);
        count += dfs(grid, i, j+1);
        count += dfs(grid, i, j-1);
        
        return count;
    }
}


/* 
* TC: O(n^2)
* SC: O(n)
*/
