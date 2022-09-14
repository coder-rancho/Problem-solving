class Solution {

    public String longestPalindrome(String s) {

        if (s.length() == 0) return "";

        String lp = Character.toString(s.charAt(0));

        // check for even palindrome
        int l = 0;
        int r = 1;
        while(r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                int left = l; int right = r; int len = 0;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left -= 1;
                    right += 1;
                    len += 2;
                }
                
                if (len > lp.length()) {
                    lp = s.substring(left+1, right);
                }
            }
            l += 1;
            r += 1;
        }

        //check for odd palindrome
        l = 0;
        r = 2;
        while (r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                int left = l; int right = r; int len = 1;
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left -= 1;
                    right += 1;
                    len += 2;
                }

                if (len > lp.length()) {
                    lp = s.substring(left+1, right);
                }
            }
            l += 1;
            r += 1;
        }
        return lp;
    }

    

    public static void main(String[] args) {
        Solution o = new Solution();
        String str = "cbbbbaadfrhhhhasdfdsa";
        System.out.println(
            o.longestPalindrome(str)
        );
    }
}