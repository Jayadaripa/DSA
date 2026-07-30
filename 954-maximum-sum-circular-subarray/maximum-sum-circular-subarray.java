class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMax = nums[0];
        int maxSum = nums[0];
        int currentMin = nums[0];
        int minSum = nums[0];
        for(int i=0 ; i<nums.length; i++){
            totalSum += nums[i];
            if(i>0){
                currentMax = Math.max(nums[i],currentMax+nums[i]);
                maxSum = Math.max(currentMax, maxSum);
                currentMin = Math.min(nums[i],currentMin+nums[i]);
                minSum = Math.min(currentMin, minSum);
            }
        }
        // If all elements are negative
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum,totalSum-minSum);
    }
    

}