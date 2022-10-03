class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        if (haystack.equals(needle)) return 0;
        
        int[] Z = Solution.calculateZ(needle+"$"+haystack);

        for (int i = 0; i < Z.length; i++) {
            if (Z[i] == needle.length()) return i - needle.length() - 1;
        }

        return -1;
    }

    public static int[] calculateZ(String str) {
        // Initialize Z-box;
        int left = 0;
        int right = 0;
        int[] Z = new int[str.length()];
        
        // Calculate Z[k] where, k = (1 -> n-1)
        for (int k = 1; k < str.length(); k++) {
            
            // if k falls beyound Z-bok then calculate new Z-box
            if (k > right) {
                left = right = k;

                while (
                    right < str.length() 
                    && str.charAt(right) == str.charAt(right-left)
                ){
                    right++;
                }
                Z[k] = right - left;
                right--;
            // else try to copy the z values from prev results
            } else {
                int k1 = k - left;

                if ( (k + Z[k1] - 1) < right) {
                    Z[k] = Z[k1];
                } else {
                    left = k;

                    while (
                        right < str.length() 
                        && str.charAt(right) == str.charAt(right-left)
                    ){
                        right++;
                    }
                    Z[k] = right - left;
                    right--;
                }
            }
        }
        return Z;
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        String haystack = "mississippi";
        String needle = "issip";

        System.out.println(o.strStr(haystack, needle));
    }
}



