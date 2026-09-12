class Solution {
    public int[] maximumWeight(List<List<Integer>> interval) {
        // List<List<Integer>> interval = new ArrayList<>();

        for(int i = 0; i < interval.size(); i++) {

            interval.get(i).add(i);
        }

        interval.sort((a,b) -> Integer.compare(a.get(0), b.get(0)));

        int[] next = new int[interval.size()];

        for(int i = 0; i < interval.size(); i++) {
            next[i] = findNext(interval, interval.get(i).get(1));
        }
        Pair[][] dp = new Pair[interval.size()][5];
        
        for(Pair[] row : dp) {
            Arrays.fill(row, new Pair());
        }
        
        Pair p = findScore(interval, next, 0, 4, dp);
        int[] ans = new int[p.list.size()];

        for(int i = 0; i < ans.length; i++) {
            ans[i] = p.list.get(i);
        }
        return ans;
    }

    class Pair{
        List<Integer> list;
        long score;

        public Pair(List<Integer> list, long score) {
            this.list = list;
            this.score = score;
        }
        public Pair(){
            this.list = new ArrayList<>();
            this.score = 0;
        }
    }
    public Pair findScore(List<List<Integer>> interval, int[] next, int i, int k, Pair[][] dp) {
        
        if(k == 0 || i >= interval.size()) {
            return new Pair();
        }
        if(dp[i][k].list.size() > 0) return dp[i][k];

        Pair skip = findScore(interval, next, i+1, k, dp);
        Pair temp;

        if (next[i] == -1) {
            temp = new Pair();
        } else {
            temp = findScore(interval, next, next[i], k-1, dp);
        }

        Pair take = new Pair(
            new ArrayList<>(temp.list),
            interval.get(i).get(2) + temp.score
        );
        // Pair take = new Pair(new ArrayList<>(), 0);
        // take.score = interval.get(i).get(2) + temp.score;
        // take.list = temp.list;
        take.list.add(interval.get(i).get(3));
        take.list.sort(Comparator.naturalOrder());

        if(take.score > skip.score) {
            dp[i][k] = take;
            return take;
        }
        else if(skip.score > take.score) {
            dp[i][k] = skip;
            return skip;
        }
        else {
            for(int l = 0; l < Math.min(take.list.size(), skip.list.size()); l++) {
                if(take.list.get(l) > skip.list.get(l)) {
                    dp[i][k] = skip;
                    return skip;
                }
                if(take.list.get(l) < skip.list.get(l)) {
                    dp[i][k] = take;
                    return take;
                }
            }
            if (take.list.size() < skip.list.size()) {
                dp[i][k] = take;
                return take;
            }
            dp[i][k] = skip;
            return skip;
        }
    }
    public int findNext(List<List<Integer>> interval, int end) {
        int low = 0, high = interval.size()-1;

        int ans= -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(interval.get(mid).get(0) > end) {
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }

        }
        return ans;
    }
}