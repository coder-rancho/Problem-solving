class Solution {
    public String countAndSay(int n) {
        Queue<String> q = _countAndSay(n);
        StringBuffer sbr = new StringBuffer();
        while(q.peek() != null) sbr.append(q.poll());
        return sbr.toString();
    }
    
    private Queue<String> _countAndSay(int n) {

        if (n == 1) {
            Queue<String> q = new LinkedList<>();
            q.add("1");
            return q;
        }

        Queue<String> q = new LinkedList<>();
        Queue<String> res = _countAndSay(n-1);

        int count = 0;
        String num = res.peek();

        while (res.peek() != null) {

            if (res.peek().equals(num)) {
                count++;
                res.poll();
            } else {
                q.add(Integer.toString(count));
                q.add(num);
                count = 1;
                num = res.poll();
            }
            
        }

        q.add(Integer.toString(count));
        q.add(num);

        return q;
    }

    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(
            o.countAndSay(5)
        );
    }

}