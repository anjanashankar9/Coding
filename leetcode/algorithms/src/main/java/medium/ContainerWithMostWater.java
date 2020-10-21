package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-21
 */
public class ContainerWithMostWater {

    //O(N*N)
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;

        for(int i=0; i<height.length; i++) {
            for(int j= i+1; j< height.length; j++) {
                int area = (j-i)*(Math.min(height[j], height[i]));
                maxArea = area > maxArea ? area : maxArea;
            }
        }

        return maxArea;
    }

    //O(N)
    public int maxAreaOptimal(int[] height) {
        int maxArea = 0;

        int p1 = 0;
        int p2 = height.length-1;

        while (p1<p2) {
            int area = (p2-p1)*(Math.min(height[p2], height[p1]));
            maxArea = area > maxArea ? area : maxArea;
            if(height[p1]< height[p2]) {
                p1++;
            }
            else {
                p2--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int height1[] = {1,8,6,2,5,4,8,3,7};
        int height2[] = {1,1};
        int height3[] = {4,3,2,1,4};
        int height4[] = {1,2,1};

        System.out.println(new ContainerWithMostWater().maxAreaOptimal(height1));
        System.out.println(new ContainerWithMostWater().maxAreaOptimal(height2));
        System.out.println(new ContainerWithMostWater().maxAreaOptimal(height3));
        System.out.println(new ContainerWithMostWater().maxAreaOptimal(height4));

    }
}

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2


Constraints:

2 <= height.length <= 3 * 104
0 <= height[i] <= 3 * 104
 */

//https://leetcode.com/problems/container-with-most-water/
