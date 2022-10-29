
class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1) return 1;
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? 3 : 2;
        }

        int count = s.length();

        //Systemm.out.println("odd");
        int left = 0, right = 2;
        while(right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                int l = left, r = right;
                while (r < s.length() && l > -1 && s.charAt(l--) == s.charAt(r++)) {
                    //Systemm.out.println((l+1) + "_" + (r-1));
                    count++;
                }
            }
            left += 1; right += 1;
        }

        //Systemm.out.println("even");
        left = 0; right = 1;
        while(right < s.length()) {
            if(s.charAt(left) == s.charAt(right)) {
                int l = left, r = right;
                while (r < s.length() && l > -1 && s.charAt(l--) == s.charAt(r++)) {
                    //Systemm.out.println((l+1)+ "_" + (r-1));
                    count++;
                }
            }
            left += 1; right += 1;
        }

        return count;
    }
    public static void main(String[] args) {
        Solution o = new Solution();
        //Systemm.out.println(o.countSubstrings("abc") + " >> 15");
    }
}