class Solution {
    int[] parent = new int[26];
    int[] rank = new int[26];

    public boolean equationsPossible(String[] equations) {
        for(int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 0;

        }

        for(String s : equations) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';
            char op = s.charAt(1);

            if(op == '=') {
                union(x,y);
            }
        }
        for(String s : equations) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';
            char op = s.charAt(1);

            if(op == '!') {
                int check_x = find(x);
                int check_y = find(y);

                if(check_x == check_y){
                    return false;
                }
            }
        }
        return true;
    }

    public int find(int x) {
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int par_x = find(x);
        int par_y = find(y);

        if(par_x == par_y) {
            parent[par_y] = par_x;
            return;
        }

        if(rank[par_x] > rank[par_y]) {
            parent[par_y] = par_x;
            rank[par_x]++;
        }
        else{
            parent[par_x] = par_y;
            rank[par_y]++;
        }
    }
}