class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int len = s.length();

            // Only check even digit numbers
            if (len % 2 != 0) continue;

            int half = len / 2;
            int leftSum = 0, rightSum = 0;

            for (int j = 0; j < half; j++) {
                leftSum += s.charAt(j) - '0';
                rightSum += s.charAt(j + half) - '0';
            }

            if (leftSum == rightSum) {
                count++;
            }
        }

        return count;
    }
}