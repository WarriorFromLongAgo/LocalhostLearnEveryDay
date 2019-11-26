package com.leetcod.di12HighestWaterContainer;

public class HighestWaterContainer {
    //    int[] = {1,2,3,4,5,6}
    //  水位最高的
    public int highestWaterContainer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (right > left) {
            int tempMaxArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, tempMaxArea);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
