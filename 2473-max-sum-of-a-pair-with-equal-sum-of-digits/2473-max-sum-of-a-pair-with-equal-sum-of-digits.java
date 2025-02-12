class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> maxMap = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (maxMap.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, maxMap.get(digitSum) + num);
                maxMap.put(digitSum, Math.max(maxMap.get(digitSum), num));
            } else {
                maxMap.put(digitSum, num);
            }
        }
        return maxSum;
    }
    public  int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}