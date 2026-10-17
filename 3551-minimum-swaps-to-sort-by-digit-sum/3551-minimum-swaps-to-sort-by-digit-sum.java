class Solution {
    public int minSwaps(int[] nums) {
        int[][] sum = new int[nums.length][2];

        for(int i = 0; i < nums.length; i++) {
            sum[i][0] = nums[i];
            sum[i][1] = sum(nums[i]);
        }

        Arrays.sort(sum, (a,b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            if(map.get(sum[i][0]) != i) {
                int temp = nums[i];
                nums[i] = nums[map.get(sum[i][0])];
                nums[map.get(sum[i][0])] = temp;

                map.put(nums[map.get(sum[i][0])], map.get(sum[i][0]));
                map.put(nums[i], i);

                ans++;
            }
        }
        return ans;

    }
    public int sum(int num) {
        int ans = 0;
        while(num != 0) {
            int div = num %10;
            num/=10;
            ans+=div;
        }
        return ans;
    }
}