class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int n = s.length();

        // Initialising index of last occurrence of each character to '-1'.
        int aIdx = -1, bIdx = -1, cIdx = -1;
        for (int i = 0; i < n; i++)
        {

            // Updating the index of last occurrence of each character.
            if (s.charAt(i) == 'a')
            {
                aIdx = i;
            }
            else if (s.charAt(i) == 'b')
            {
                bIdx = i;
            }
            else if (s.charAt(i) == 'c')
            {
                cIdx = i;
            }

            int minIdx = Math.min(aIdx, Math.min(bIdx, cIdx));

            // Adding count of all valid substrings.
            ans = ans + (minIdx + 1);
        }
        return ans;

    }
}