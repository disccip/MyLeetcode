// 59. Spiral Matrix II --------- medium

class LC59 {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int[] rd = {0, 1, 0, -1};
        int[] cd = {1, 0, -1, 0};
        int direction = 0, row = 0, col = 0;
        for (int i = 0; i < n * n; i++)
        {
            ret[row][col] = i + 1;
            for (int j = 0; j < 4; j++)
            {
                row += rd[(direction + j) % 4];
                col += cd[(direction + j) % 4];
                if (!isValid(ret, row, col, n))
                {
                    row -= rd[(direction + j) % 4];
                    col -= cd[(direction + j) % 4];
                    continue;
                }
                else 
                {
                    direction = (direction + j) % 4;
                    break;
                }
            }
        }
        return ret;
    }
    
    private boolean isValid(int[][] res, int row, int col, int n)
    {
        if (row < 0 || col < 0 || row > n - 1 || col > n - 1 || res[row][col] != 0)
            return false;
        return true;
    }
}