class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> temp = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] > end) {
                temp.add(new int[] {
                    start,
                    end
                });
                start = intervals[i][0];
                end = intervals[i][1];

            }
            else {
                end = Math.max(end, intervals[i][1]);

            }
        }
        temp.add(new int[] {
            start, end
        });
        int[][] ans = new int[temp.size()][2];


        for(int i = 0; i < temp.size(); i++) {
            
            ans[i][0] = temp.get(i)[0];
            ans[i][1] = temp.get(i)[1];
        }
        return ans;
    }
}
// [1,4]
// [4,7]