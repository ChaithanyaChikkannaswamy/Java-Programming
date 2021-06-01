/*
* Question: https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
* Date: 06/01/2021
*/

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxHori = horizontalCuts[0];
        for(int i=1 ; i<horizontalCuts.length; ++i){
            maxHori = Math.max(maxHori, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        maxHori = Math.max(maxHori, h - horizontalCuts[horizontalCuts.length - 1]);
        
        int maxVert = verticalCuts[0];
        for(int i = 1; i<verticalCuts.length; ++i){
            maxVert = Math.max(maxVert, verticalCuts[i] - verticalCuts[i-1]);
        }
        maxVert = Math.max(maxVert, w - verticalCuts[verticalCuts.length - 1]);
        
        return (int)(((long)maxHori * (long)maxVert) % 1000000007);
    }
}
