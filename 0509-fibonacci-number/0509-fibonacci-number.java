class Solution {
    public int fib(int n) {
        return fiboRecursion(n);
    }

    public int fiboRecursion(int n) {
        if(n == 0 || n == 1) return n;

        return fiboRecursion(n-1) + fiboRecursion(n-2);
    }
}