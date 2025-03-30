class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        Map<Character, Integer> lastIndex = new HashMap<>();

        // Store last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int start = 0, end = 0;
        // Iterate through the string to determine partitions
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex.get(s.charAt(i))); // Expand partition boundary
            
            // When the current index reaches the partition end, cut the partition
            if (i == end) {
                partitions.add(end - start + 1);
                start = i + 1; // Start a new partition
            }
        }
        return partitions;
    }
}