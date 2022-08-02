class Solution {
    
    List<List<Integer>> permutations = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        ////////////////////////////////////////////
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        _permute(
            numList,
            new ArrayList<Integer>()
        );
        return permutations;
    }
    
    public void _permute(List<Integer> candidates, List<Integer> perm) {
        
        if (candidates.size() == 0) {
            //////////////////////////////////////
            permutations.add( new ArrayList<>(perm) );
            return;
        }
        
        for (Integer cand : candidates ) {
            perm.add(cand);
            _permute(
                _filterList(candidates, cand),
                perm
            );
            perm.remove(perm.size() - 1);
        }
    }
    
    public List<Integer> _filterList(List<Integer> list, Integer elemToRemove) {
        //////////////////////////////////////
        List<Integer> copy = new ArrayList<>(list);
        copy.removeIf(elem -> elem == elemToRemove);
        return copy;
    }
}