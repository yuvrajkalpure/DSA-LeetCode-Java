class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int n=heights.length;
        Deque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<=n;i++){
            int currentHeight=i==n?0:heights[i];
            while(!stack.isEmpty() && currentHeight<heights[stack.peek()]){
                int h=heights[stack.pop()];

                int right=i;
                int left=stack.isEmpty()?-1:stack.peek();

                int width=right-left-1;

                maxArea=Math.max(maxArea,h*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}