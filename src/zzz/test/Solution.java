class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] memo = new int[m][n];
        int result = 0;
        for(int i = 0; i< m ; i++){
            for(int j = 0; j< n; j++){
                dfs(matrix, i, j, memo, m, n);
                result = Math.max(result, memo[i][j]);
            }
        }
        return result;
    }

    public int dfs(int[][] matrix, int i , int j, int[][] memo, int m, int n){
        if(i< 0 || i>= m || j<0 || j>=n) return 0;
        int a=0, b=0, c=0, d=0;
        if(i+1 < m && matrix[i+1][j] > matrix[i][j]){
            a = memo[i+1][j] != 0? memo[i+1][j]: 1 + dfs(matrix, i+1, j, memo, m, n);
        }
        if(i-1 >=0 && matrix[i-1][j] > matrix[i][j]){
            b = memo[i-1][j] != 0? memo[i-1][j]:1 + dfs(matrix, i-1, j, memo, m, n);
        }

        if(j+1 < n && matrix[i][j+1] > matrix[i][j]){
            c = memo[i][j+1] != 0? memo[i][j+1]: 1 + dfs(matrix, i, j+1, memo, m, n);
        }
        if(j-1 < m && matrix[i][j-1] > matrix[i][j]){
            d = memo[i][j-1] != 0? memo[i][j-1]:1 + dfs(matrix, i, j-1, memo, m, n);
        }
        memo[i][j]= Math.max(Math.max(a, b), Math.max(c, d));
        return memo[i][j];
    }
}