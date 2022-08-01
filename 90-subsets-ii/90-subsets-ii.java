class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<Integer> subset = new ArrayList<Integer>();
        
        Arrays.sort(nums);
        
        subsets(nums, 0, nums.length - 1, subset);
        
        return result;
    }
    
    public void subsets(int[] nums, int l, int r, List<Integer> subset) {
        
        if (l > r) {
            List<Integer> copy = new ArrayList<Integer>(subset);
            String copyStr = copy.toString();
            
            if (map.get(copyStr) != null) return;
            
            map.put(copyStr, true);
            
            result.add(copy);
            
            return;
        }
        
        subset.add(nums[l]);
        
        subsets(nums, l+1, r, subset);
        
        subset.remove(subset.size() - 1);
        
        subsets(nums, l+1, r, subset);
    }
}