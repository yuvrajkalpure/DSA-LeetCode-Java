class OnlineStockSpan {

    private Deque<int[]> stack;
    public OnlineStockSpan() {
        stack=new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            span+=stack.pop()[1];
        }
        stack.push(new int[]{price,span});
        return span;
    }
}

/**
 * Your OnlineStockSpan object will be instantiated and called as such:
 * OnlineStockSpan obj = new OnlineStockSpan();
 * int param_1 = obj.next(price);
 */