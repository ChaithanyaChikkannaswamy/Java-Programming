/**
 * @author chaithanyac
 * Return the maximum total number of units that can be put on the truck. 
 */
 
 class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int maxunits = 0;
        for(int[] box : boxTypes){
            if(truckSize < box[0]){
                return maxunits + truckSize * box[1];
            }
            maxunits += box[0] * box[1];
            truckSize -= box[0];
        }
        return maxunits;
    }
}
