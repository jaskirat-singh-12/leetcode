class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, new StringBuilder());
        return ans;
    }

    public void generate(int n, int open, int close, StringBuilder temp) {
        if(open > n || close > n) {
            return;
        }

        if(open == n && close == n) {
            if(isValid(temp)) {
                ans.add(temp.toString());
            }
            return;
        }

        temp.append('(');
        generate(n, open+1, close, temp);
        temp.deleteCharAt(temp.length()-1);
        temp.append(')');
        generate(n, open, close+1, temp);
        temp.deleteCharAt(temp.length()-1);
        return;
    }
    public boolean isValid(StringBuilder temp) {
        int open = 0;

        for(int i = 0; i < temp.length(); i++) {
            char ch = temp.charAt(i);
            if(ch == ')') {
                open--;
            }
            else {
                open++;
            }
            if(open < 0) {
                return false;
            }
        }
        return open == 0;
    }
}