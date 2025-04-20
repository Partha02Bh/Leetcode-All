class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalRabbits = 0;

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int answer = entry.getKey();
            int freq = entry.getValue();
            int groupSize = answer + 1;
            int groupsNeeded = (int) Math.ceil((double) freq / groupSize);
            totalRabbits += groupsNeeded * groupSize;
        }

        return totalRabbits;
    }
}