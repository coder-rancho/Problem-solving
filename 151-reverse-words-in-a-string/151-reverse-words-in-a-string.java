import java.util.*;

class Solution {

    public String reverseWords(String s) {

        int start = s.length() - 1;
        int end = s.length();
        String result = "";

        while(s.charAt(end-1) == ' ') end -= 1;
        start = end - 1;

        while (start >= 0) {

            if (s.charAt(start) == ' ') {
                result += s.substring(start+1, end) + " ";
                end = start;
                while(end > 0 && s.charAt(end-1) == ' ') end -= 1;
                start = end;
            }
            start -= 1;
        }

        if (s.charAt(0) != ' ') result += s.substring(0, end) + " ";

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        Solution o = new Solution();

        System.out.println(
            o.reverseWords("the sky is    blue")
        );

    }
}