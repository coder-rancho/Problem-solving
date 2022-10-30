class Solution {
//     public int pivotIndex(int[] nums) {
//         int n = nums.length;
//         int[] fwd = new int[n];
//         int[] bwd = new int[n];
        
//         for (int i = 0, sum = 0; i < n; ++i) {
//             sum += nums[i];
//             fwd[i] = sum;
//         }
        
//         for (int i = n-1, sum = 0; i > -1; --i) {
//             sum += nums[i];
//             bwd[i] = sum;
//         }
        
//         for (int i=0, j=0; i < n; ++i, ++j)
//             if (fwd[i] == bwd[j]) return i;
        
//         return -1;
//     }
    
    public int pivotIndex(int[] nums) {
        int total = 0, sum = 0;
        for(int num : nums) total += num;
        for(int i = 0; i < nums.length; sum += nums[i++])
            if ( sum*2 == (total - nums[i]) ) return i;
        return -1;
    }
}