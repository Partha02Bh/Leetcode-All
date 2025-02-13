class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer((long)num);
        }
        int operations = 0;
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            Long x = minHeap.poll(); 
            Long y = minHeap.poll();    
            Long newVal = (Math.min(x, y) * 2) + Math.max(x, y);
            minHeap.offer(newVal);          
            operations++;
        }
        return (minHeap.peek() >= k) ? operations : -1;
    }
}