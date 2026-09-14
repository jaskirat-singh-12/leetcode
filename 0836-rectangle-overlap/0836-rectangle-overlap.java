class Solution {
    public boolean isRectangleOverlap(int[] rect1, int[] rect2) {
        int x1 = rect1[0];
        int y1 = rect1[1];
        int x2 = rect1[2];
        int y2 = rect1[3];
        
        int x21 = rect2[0];
        int y21 = rect2[1];
        int x22 = rect2[2];
        int y22 = rect2[3];

        if (x1 < x22 && x21 < x2 && y1 < y22 && y21 < y2) { return true; }
        return false;
    }
}