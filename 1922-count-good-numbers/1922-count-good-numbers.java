class Solution {
    int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n)/2;
        return (int) ((findPow(5, even) * findPow(4, odd)) % MOD);
    }
    public long findPow(long n, long p) {
        
        if(p == 0) return 1;

        long half = findPow(n, p/2);
        long res = (half * half) % MOD;
        if(p % 2 == 1) {
            return (n * res) % MOD;
        }
        return res;
    }
}