/**
 * Date : 01/29/2021
 * Return an integer representing the number of players who will be able to level up their characters at the end of the round.
 */
 
 A group of work friends at Amazon is playing a competitive video game together. During the game, each player receives a certain amount of points based on their performance. At the end of a round, players who achieve at least a cutoff rank get to "level up" their character, gaining increased abilities for them. Given the scores of the players at the end of the round, how many players will be able to level up their character?

Note that players with equal scores will have equal ranks, but the player with the next lowest score will be ranked based on the position within the list of all players' scores. For example, if there are four players, and three players tie for first place, their ranks would be 1,1,1, and 4. Also, no player with a score of O can level up, no matter what their rank.

Write an algorithm that returns the count of players able to level up their character.

Input

The input to the function/method consists of three arguments:

cutOffRank, an integer representing the cutoff rank for levelin up the player's character;

num, an integer representing the total number of scores;

scores, a list of integers representing the scores of the players.

Output

Return an integer representing the number of players who will be able to level up their characters at the end of the round.

Constraints

1 <= num <= 10^5

0 <= scores[i] <= 100

0 <= i < num

cutOffRank <= num

Examples

Example 1:

Input:

cutOffRank = 3

num= 4

scores=[100, 50, 50, 25 ]

Output:

3

Explanation:

There are num= 4 players, where the cutOffRank is 3 and scores = [100, 50,50, 25]. These players' ranks are [1, 2, 2, 4]. Because the players need to have a rank of at least 3 to level up their characters, only the first three players will be able to do so.

So, the output is 3.

import java.util.*;
import java.io.*;

class CutoffRanks {

    public static void main(String[] args) {
        System.out.println(cutOffRank(3, 4, new int[]{100, 50, 50, 25}));
        System.out.println(cutOffRank(4, 5, new int[]{2, 2, 3, 4, 5}));
    }

    public static int cutOffRank(int cutOffRank, int num, int[] scores) {
        Arrays.sort(scores);
        int total = 0;
        int initialscore = 0;
        for (int i = scores.length - 1; i >= 0; i--) {
            int currscore = scores[i];
            if (initialscore == currscore) {
                total++;
            } else {
                if (total >= cutOffRank) break;
                total++;
                initialscore = currscore;
            }
        }
        return total;
    }
}
