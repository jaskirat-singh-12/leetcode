class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;

        while(i < s.length()){
            char start = s.charAt(i);
            if(start == '(' || start == '[' || start == '{'){
                st.push(start);
            }
            else{
                if(st.isEmpty()) return false;
                char check = st.pop();
                if(check == '(' && start != ')'
                || check == '[' && start != ']'
                || check == '{' && start != '}'
                ){
                    return false;
                }
            }
            i++;
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}