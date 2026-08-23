class Solution {
    public boolean sumGame(String num) {
        boolean alice = true;
        int sumOnRight = 0, qOnRight = 0, qOnLeft = 0, sumOnLeft = 0;

        for(int i = 0; i < num.length()/2; i++) {
            char ch = num.charAt(i);

            if(ch == '?') qOnLeft++;
            else {
                sumOnLeft += ch - '0';
            }
            
        }

        for(int i = num.length()/2; i < num.length(); i++) {
            char ch = num.charAt(i);

            if(ch == '?') qOnRight++;
            else {
                sumOnRight += ch - '0';
            }
        }
        if((qOnLeft + qOnRight) % 2 != 0) return true;

        return ((2 * sumOnLeft) + (9 * qOnLeft)) != ((2 * sumOnRight) + (9 * qOnRight));
    }
}