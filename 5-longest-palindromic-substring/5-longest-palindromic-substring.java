class Solution {

    public String longestPalindrome(String str) {

        if (str == "") return "";

        String lp = Character.toString(str.charAt(0));

        for (int s = 0; s < str.length(); ++s) {
            if (lp.length() >= (str.length() - s)) break;
            for (int e = str.length() - 1; e > s; --e) {
                if (lp.length() >= (e - s + 1)) break;
                if (isPalindrome(str, s, e)) {
                    int len = e - s + 1;
                    if (len > lp.length()) lp = str.substring(s, e+1);
                    break;
                }
            }
        }
        return lp;        
    }

    private boolean isPalindrome(String str, int left, int right) {
        while(left < right) if (str.charAt(left++) != str.charAt(right--)) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        String str = "cbbd";
        System.out.println(
            o.longestPalindrome(str)
        );
    }
}