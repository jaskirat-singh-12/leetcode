class Solution {
    public boolean checkDivisibility(int n) {
        long mul = 1, sum = 0;

        int temp = n;
        while(temp > 0) {
            mul *= (temp % 10);
            sum += (temp % 10);
            temp = temp/10;
        }
        return n % (mul + sum) == 0;
    }
}