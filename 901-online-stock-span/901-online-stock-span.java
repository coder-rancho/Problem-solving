import java.util.Stack;

class StockSpanner {
    
    class PriceSpan {
        int price;
        int span;
        
        PriceSpan(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    Stack<PriceSpan> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek().price <= price) span += stack.pop().span;

        stack.push(new PriceSpan(price, span));
        return span;
    }

    public static void main(String[] args) {
        StockSpanner o = new StockSpanner();
        
        System.out.println(o.next(100));    // 1
        System.out.println(o.next(80));     // 1
        System.out.println(o.next(60));     // 1
        System.out.println(o.next(70));     // 2
        System.out.println(o.next(60));     // 1
        System.out.println(o.next(75));     // 4
        System.out.println(o.next(85));     // 6

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */