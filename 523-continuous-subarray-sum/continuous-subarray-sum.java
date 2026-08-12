import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        // Remainder 0 before the array starts
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int rem = prefixSum % k;

            // If remainder was seen before
            if (map.containsKey(rem)) {

                // Subarray length must be at least 2
                if (i - map.get(rem) >= 2) {
                    return true;
                }

            } else {
                // Store only the first occurrence
                map.put(rem, i);
            }
        }

        return false;
    }
}