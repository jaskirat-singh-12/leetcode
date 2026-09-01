class Solution {
    public int minMoves(String[] classroom, int energy) {

        int[][] litterCount = new int[20][20];

        int n = classroom.length;
        int m = classroom[0].length();
        int collected = 0;
        int sRow =0, sCol =0;

        for(int i = 0; i < n; i++) {
            String s = classroom[i];
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'S') {
                    sRow = i;
                    sCol = j;
                }
                if(s.charAt(j) == 'L') {
                    litterCount[i][j] = collected;
                    collected++;
                }
            }
        }
        int allCollect = (1 << collected)-1;

        if(collected == 0) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sRow,sCol,energy, 0));

        boolean[][][][] vis = new boolean[21][21][energy+1][1 << collected];

        vis[sRow][sCol][energy][0] = true;

        int moves = 0;
        int[][] dir = new int[][] {{0,-1}, {0,1}, {1,0}, {-1,0}};

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                    
                Pair p = q.poll();
                int prow = p.row;
                int pcol = p.col;
                int en = p.energy;
                int litter = p.collect;

                if(litter == allCollect) {
                    return moves;
                }

                for(int[] d : dir) {
                    int row = prow + d[0];
                    int col = pcol + d[1];

                    if(row < 0 || row >= n || col < 0 || col >= m) {
                        continue;
                    }
                    if(en == 0) continue;

                    char cell = classroom[row].charAt(col);

                    if(cell == 'X') continue;

                    int nextEnergy = en - 1;
                    int nextMask = litter;

                    if(cell == 'R') {
                        nextEnergy = energy;
                    }
                    else if(cell == 'L') {
                        nextMask |= (1 << litterCount[row][col]);
                    }

                    if(!vis[row][col][nextEnergy][nextMask]) {
                        vis[row][col][nextEnergy][nextMask] = true;
                        q.offer(new Pair(row,col,nextEnergy,nextMask));
                    }
                }
            }
                moves++;
        }

        return -1;

    }

    class Pair{
        int row, col, energy, collect;

        public Pair(int row, int col, int energy, int collect) {
            this.row = row;
            this.col = col;
            this.energy = energy;
            this.collect = collect;
        }
    }
}