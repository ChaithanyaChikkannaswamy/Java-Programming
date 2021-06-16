/*
* Question: https://leetcode.com/problems/majority-element-ii/
* Date: 06/16/2021
*/



//Moore's voting Algorithm Implementation

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int x = -1;
        int y = -1;
        int countx = 0;
        int county = 0;
        
        //check the candidates to be considered for majority elements
        for(int i = 0; i<nums.length;i++){
            if(x==nums[i])
                countx++;
            else if(y == nums[i])
                county++;
            else if(countx == 0){
                x = nums[i];
                countx = 1;
            }
            else if(county == 0){
                y = nums[i];
                county = 1;
            }
            else
            {
                countx--;
                county--;
            }
        }
        
        //check if the frequency of the candidate element id greater than nums.length/3. If so, add it to the res.
        
        List<Integer> res = new ArrayList<>();
        countx=0;
        county=0;
        
        for(int i =0; i<nums.length; i++){
            if(x==nums[i])
                countx++;
            else if(y==nums[i])
                county++;
        }
        
        if(countx>nums.length/3)
            res.add(x);
        if(county>nums.length/3)
            res.add(y);
        
        return res;
    }
}


//TC: O(N)
//SC: O(1)
