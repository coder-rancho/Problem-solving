import java.util.*;

class Solution {

    public int updateStack(Stack<Integer> stack, int num) {

        while (!stack.isEmpty() && num >= stack.peek()) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            stack.push(num);
            return -1;
        }

        int nextElem = stack.peek();
        stack.push(num);
        return nextElem;
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; --i) updateStack(stack, nums[i]);

        for (int i = nums.length - 1; i >= 0; --i) result[i] = updateStack(stack, nums[i]);
        
        return result;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {5,4,3,2,1};   // [-1,5,5,5,5]
        int[] result = obj.nextGreaterElements(nums);

        for (int num : result) {
            System.out.println(num);
        }
    }
}