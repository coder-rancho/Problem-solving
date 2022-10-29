import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length == 0) return Collections.emptyList();

        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) { // leaves two element for last iteration
            int j = i+1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    res.add(new ArrayList<>(List.of(nums[i], nums[j++], nums[k--])));
                }
            }
        }        
        return new ArrayList<>(res);
    }
}