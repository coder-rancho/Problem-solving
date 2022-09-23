class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        int minLen = Integer.MAX_VALUE;

        for (String s : strs) minLen = Math.min(minLen, s.length());
        
        while (i<minLen) {
            Character res = strs[0].charAt(i);
            for (String s : strs) {
                if (res != s.charAt(i)) return strs[0].substring(0, i);
            }
            i+=1;
        }

        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        String[] strs = {
            "abc",
            "acb"
        };
        System.out.println(
            o.longestCommonPrefix(strs)
        );
    }

}