class Solution {
    
    public String getPermutation(int n, int k) {
        int fact = _fact(n);
        int ppe = fact;
        List<Integer> list = _getList(n);
        k = k - 1;
        String ans = "";
        
        while (list.size() > 0) {
            ppe = ppe / list.size();
            int ind = k / ppe;
            ans += list.get(ind).toString();
            list.remove(ind);
            k = k - ind*ppe;
        }
        
        return ans;
    }
    
    public int _fact(int n) {
        int fact = 1;
        while (n > 1) {
            fact *= n;
            n--;
        }
        return fact;
    }
    
    public List<Integer> _getList(int n) {
        Integer[] arr = new Integer[n];
        Arrays.setAll(arr, i -> i + 1);
        return new ArrayList<>(Arrays.asList(arr));
    }
    
}