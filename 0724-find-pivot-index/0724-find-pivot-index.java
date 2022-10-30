class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] fwd = new int[n];
        int[] bwd = new int[n];
        
        for (int i = 0, sum = 0; i < n; ++i) {
            sum += nums[i];
            fwd[i] = sum;
        }
        
        for (int i = n-1, sum = 0; i > -1; --i) {
            sum += nums[i];
            bwd[i] = sum;
        }
        
        for (int i=0, j=0; i < n; ++i, ++j)
            if (fwd[i] == bwd[j]) return i;
        
        return -1;
    }
}