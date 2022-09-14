import java.util.*;

class Solution {

    public String reverseWords(String s) {

        int start = s.length() - 1;
        int end = s.length();
        ArrayList<String> words = new ArrayList<>();

        while(s.charAt(end-1) == ' ') end -= 1;
        start = end - 1;

        while (start >= 0) {

            if (s.charAt(start) == ' ') {
                words.add(s.substring(start+1, end));
                end = start;
                while(end > 0 && s.charAt(end-1) == ' ') end -= 1;
                start = end;
            }
            start -= 1;
        }

        if (s.charAt(0) != ' ') words.add(s.substring(0, end));

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution o = new Solution();

        System.out.println(
            o.reverseWords("the sky is    blue")
        );

    }
}