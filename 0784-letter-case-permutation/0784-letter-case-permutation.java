import java.util.*;

class Solution {

    ArrayList<String> res;
    char[] chars;

    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        chars = s.toCharArray();
        helper(0, new char[s.length()]);
        return res;
    }

    void helper(int indx, char[] combination) {

        if (indx == combination.length) {
            String s = new String(combination);
            res.add(s);
            return;
        }

        char ch = chars[indx];
        // Compulsory call
        combination[indx] = ch;
        helper(indx+1, combination);

        // If char is alphabet
        if ( (int)ch > 96 && (int)ch < 123) {   // small-case alphabet
            combination[indx] = (char)(ch - 32);
            helper(indx+1, combination);
        }

        if ( (int)ch > 64 && (int)ch < 91) { // upper-case alphabet
            combination[indx] = (char)(ch + 32);
            helper(indx+1, combination);
        }
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(o.letterCasePermutation("a1b2"));
    }
}