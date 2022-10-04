class Solution {

    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()) return -1;
        if (haystack.equals(needle)) return 0;
        return kmp(haystack, needle);
    }

    static int kmp(String txt, String pat) {
        int[] lps =  Solution.calculateLps(pat);
        // ArrayList<Integer> indices = new ArrayList<>();  // This arraylist can be used to store all occurences of pat in txt
        int i = 0; int j = 0;

        while (i < txt.length()) {
            
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == pat.length()) return i - j;
            }
            else {
                if (j != 0) j = lps[j-1];
                else i++;
            }
        }
        return -1;
    }

    static int[] calculateLps(String pat) {
        int[] lps = new int[pat.length()];
        int i = 1; int len = 0;
        lps[0] = 0;

        while (i < pat.length()) {

            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {
                
                while (pat.charAt(i) != pat.charAt(len) && len > 0) {
                    len = lps[len - 1];
                }

                if (pat.charAt(i) != pat.charAt(len)) lps[i++] = 0;
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        String haystack = "aabaaacaaaaad";
        String needle = "aaa";

        // Check calculation of lps
        // for (int lps : Solution.calculateLps("acacaxa")) System.out.print(Integer.toString(lps) + " "); // 0 0 1 2 3 0 1

        // Check for kmp
        // System.out.println(Solution.kmp("aabaaacaaaad", "aaa")); // 3

        System.out.println(
            o.strStr(haystack, needle)
        );

        
    }
}