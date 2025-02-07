class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0], color = queries[i][1];
            if (ballColorMap.containsKey(ball)) {
                int prevColor = ballColorMap.get(ball);
                colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                if (colorCount.get(prevColor) == 0) {
                    colorCount.remove(prevColor);
                }
            }
            ballColorMap.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            result[i] = colorCount.size();
        }
        return result;
    }
}