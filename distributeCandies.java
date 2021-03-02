/*
* Date: March 1st 2021
* Question: https://leetcode.com/problems/distribute-candies/
*/


class Solution {
  public int distributeCandies(int[] candyType) {
    return Math.min(
      Arrays.stream(candyType).boxed().collect(Collectors.toSet()).size(),
      candyType.length / 2
    );
  }
}
