class Solution {
    public int pivotIndex(int[] nums) {

        // Step 1: Build the prefix sum array
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Step 2: Total sum of the array
        int total = prefix[nums.length - 1];

        // Step 3: Check every index
        for (int i = 0; i < nums.length; i++) {

            int leftSum;

            // If there are no elements on the left
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum = prefix[i - 1];
            }

            // Right sum = Total - Left sum - Current element
            int rightSum = total - leftSum - nums[i];

            // Check if current index is the pivot
            if (leftSum == rightSum) {
                return i;
            }
        }

        // No pivot index found
        return -1;
    }
}