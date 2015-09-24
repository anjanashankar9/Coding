package algorithms.datastructures.medium;

/**
 * Created by ashankar1 on 5/25/15.
 */
public class JimAndSkyscrapers {
}


/*
Jim has invented a new flying object called HZ42.
HZ42 is like a broom and can only fly horizontally, independent of the environment.
 One day, Jim started his flight from Dubai's highest skyscraper, t
 raveled some distance and landed on another skyscraper of same height! So much fun!
 But unfortunately, new skyscrapers have been built recently.

Let us describe the problem in one dimensional space. We have in total N skyscrapers aligned from left to right.
The ith skyscraper has a height of hi. A flying route can be described as (i,j) with i≠j,
which means, Jim starts his HZ42 at the top of the skyscraper i and lands on the skyscraper j.
Since HZ42 can only fly horizontally, Jim will remain at the height hi only. Thus the path (i,j) can be valid,
only if each of the skyscrapers i,i+1,...,j−1,j is not strictly greater than hi and if the height of the skyscraper
he starts from and arrives on have the same height. Formally, (i,j) is valid iff ∄k∈[i,j]:hk>hi and hi=hj.

Help Jim in counting the number of valid paths represented by ordered pairs (i,j).

Input Format

The first line contains N, the number of skyscrapers.
The next line contains N space separated integers representing the heights of the skyscrapers.

Output Format

Print an integer that denotes the number of valid routes.

Constraints

1≤N≤3⋅105 and no skyscraper will have height greater than 106 and lesser than 1.

Sample Input #00

6
3 2 1 2 3 3
Sample Output #00

8
Sample Input #01

3
1 1000 1
Sample Output #01

0
Explanation

First testcase: (1, 5), (1, 6) (5, 6) and (2, 4) and the routes in the opposite directions are the only valid routes.

Second testcase: (1, 3) and (3, 1) could have been valid, if there wasn't a big skyscraper with height 1000 between them.
 */

//https://www.hackerrank.com/challenges/jim-and-the-skyscrapers