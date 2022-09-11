import java.util.*;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        
        for (Character c : s.toCharArray()) {
            
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                Character match = '0';
                
                if (stack.isEmpty()) return false;
                
                switch (stack.pop()) {
                    case '[':
                        match = ']';
                        break;
                    case '{':
                        match = '}';
                        break;
                    case '(':
                        match = ')';
                        break;
                }

                if (match != c) return false;
            }
        }

        if (!stack.isEmpty()) return false;

        return true;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "()[]{";

        System.out.println(
                obj.isValid(s));
    }
}