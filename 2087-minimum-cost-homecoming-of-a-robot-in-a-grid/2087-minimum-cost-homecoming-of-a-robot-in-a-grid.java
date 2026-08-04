class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        return minCost(startPos[0], startPos[1], homePos, rowCosts, colCosts);
    }
    public int minCost(int i, int j, int[] homePos, int[] rowCosts, int[] colCosts) {
        int left = 0, right = 0;

        for(int start = Math.min(i, homePos[0]); start <= Math.max(i, homePos[0]); start++) {
            if (start != i) left += rowCosts[start];
        }

        for(int start = Math.min(j, homePos[1]); start <= Math.max(j, homePos[1]); start++) {
            if (start != j) right += colCosts[start];
        }
        return left + right;
    }
}