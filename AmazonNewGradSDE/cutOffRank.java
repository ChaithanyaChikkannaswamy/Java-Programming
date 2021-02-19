/*
* Date: February 18th 2021
* Question: https://aonecode.com/amazon-online-assessment-cutoff-ranks
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public int cutOffRank(int cutOffRank, int num, int[] scores) {
        //if cutoffraank is 0, return 0
        if(cutOffRank ==0)
            return 0;
            
        //initialization of arrays and variables;
        int scorearr[] = new int[101];
        int count = 1;
        int scorerank[] = new int[num+1];
        Arrays.fill(scorerank, -1);
        
        //store the scores into new Array
        for(int score : scores)
            scorearr[score]++;
            
        //calculate the rank of the scores    
        for(int i = scorearr.length -1 ; i>0; i--){
            if(scorearr[i]>0){
                scorerank[count] = i;
                count += scorearr[i];
            }
        }
        
        //compute the result wrt rank
        int res = 0;
        for(int i=1; i<= cutOffRank; i++){
            if(scorerank[i]!= -1){
                res += scorearr[scorerank[i]];
            }
        }
        return res;
    }
}
