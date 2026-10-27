class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        StringBuilder temp = new StringBuilder();

        for(int i = 0; i < n; i++) {
            temp.append('.');
        }
        ans[0] = temp.toString();

        for(int i = 1; i < m; i++) {
            StringBuilder temp2 = new StringBuilder();
            for(int j = 0; j < n-1; j++) {
                temp2.append('#');
            }
            temp2.append('.');
            ans[i] = temp2.toString();
        }
        return ans;
    }
}