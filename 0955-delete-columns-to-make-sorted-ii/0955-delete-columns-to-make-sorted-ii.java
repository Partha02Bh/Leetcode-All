class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        // sorted[i] = true means strs[i] <= strs[i+1] is already decided
        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;

        // Traverse columns left to right
        for (int col = 0; col < m; col++) {
            boolean needDelete = false;

            // Check if this column breaks lexicographic order
            for (int row = 0; row < n - 1; row++) {
                if (!sorted[row] &&
                    strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    needDelete = true;
                    break;
                }
            }

            // If column is bad, delete it
            if (needDelete) {
                deletions++;
                continue;
            }

            // Otherwise, update sorted status
            for (int row = 0; row < n - 1; row++) {
                if (!sorted[row] &&
                    strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                    sorted[row] = true;
                }
            }
        }

        return deletions;
    }
}
