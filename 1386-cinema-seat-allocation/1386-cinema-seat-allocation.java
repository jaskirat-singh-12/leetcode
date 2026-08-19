class Solution {
    public int maxNumberOfFamilies(int n, int[][] seats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i=0;i<seats.length;i++) {
            map.computeIfAbsent(seats[i][0], k -> new HashSet<>()).add(seats[i][1]);
        }
        int ans = (n-map.size()) * 2;

        for (int i : map.keySet()) {

            boolean left = avail(i, 2, map) &&
                           avail(i, 3, map) &&
                           avail(i, 4, map) &&
                           avail(i, 5, map);

            boolean right = avail(i, 6, map) &&
                            avail(i, 7, map) &&
                            avail(i, 8, map) &&
                            avail(i, 9, map);

            if (left && right) {
                ans += 2;
                continue;
            }

            boolean mid = avail(i, 4, map) &&
                          avail(i, 5, map) &&
                          avail(i, 6, map) &&
                          avail(i, 7, map);

            if (left || mid || right) {
                ans++;
            }
        }
        return ans;
    }
    public boolean avail(int i, int j, HashMap<Integer, HashSet<Integer>> map) {
        if(!map.containsKey(i)) return true;
        
        if(map.get(i).contains(j)) return false;

        return true;
    }
}