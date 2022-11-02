class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        
        int max = maxSum(nums);
        
        if (max < 0) return max;
        
        int min = minSum(nums);
        
        return Math.max(max, totalSum - min);
    }
    
    int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(max, num);
        if (max < 0) return max;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num > 0 ? sum + num : 0;
            max = Math.max(max, sum);
        }
        return max;        
    }
    
    int minSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) min = Math.min(min, num);
        if (min >= 0) return 0;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num < 0 ? sum + num : 0;
            min = Math.min(min, sum);
        }
        return min;
    }
}