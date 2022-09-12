import java.io.Console;
import java.util.Stack;

class Solution {

    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int[] leftSmaller = leftSmaller(heights);
        int[] rightSmaller = rightSmaller(heights);

        for (int i = 0; i < heights.length; ++i) {
            int area = heights[i] * (rightSmaller[i] - leftSmaller[i] - 1);
            maxArea = Integer.max(area, maxArea);


        }

        return maxArea;
    }

    public int[] leftSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {

            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();

            if (stack.isEmpty()) {
                stack.push(i);
                result[i] = -1;
            } else {
                result[i] = stack.peek();
                stack.push(i);
            }

        }
        return result;
    }

    public int[] rightSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; --i) {

            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) stack.pop();

            if (stack.isEmpty()) {
                stack.push(i);
                result[i] = nums.length;
            } else {
                result[i] = stack.peek();
                stack.push(i);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        int[] heights = {2, 4};
        System.out.println(
            o.largestRectangleArea(heights)
        ); 
    }
}