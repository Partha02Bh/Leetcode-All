class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        long sum = 0;
        int negcnt = 0;
        int negnumber = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0) {
                    negcnt++;
                }
                negnumber = Math.min(negnumber,Math.abs(matrix[i][j]));
            }
        }
        if(negcnt%2==0) {
            return sum;
        }
        return sum - 2*negnumber;
    }
}