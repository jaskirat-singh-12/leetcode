class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < tickets.length; i++) {
            q.offer(i);
        }

        int time = 0;

        while(!q.isEmpty()) {
            int val = q.poll();
            
            time++;
            tickets[val]--;

            if(tickets[val] == 0) {
                if(val == k) {
                    return time;
                }
            }
            else{
                q.offer(val);
            }
        }
        return time;

    }
}