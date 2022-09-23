import java.util.*;

class Solution {
    HashMap<Character, Integer> symbolValue = new HashMap<>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int result = 0;
        int priority = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Character sym = s.charAt(i);
            int value = symbolValue.get(sym);
            result += value;
            if (priority < value) result -= priority*2;
            priority = value;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution o = new Solution();

        String s = "XCIV";

        System.out.println(
            o.romanToInt(s)
        );
    }
}