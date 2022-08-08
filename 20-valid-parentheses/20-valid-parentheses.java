class Solution {
    boolean match(char open, char close)
    {
        if(open=='(' && close==')') return true;
        if(open=='{' && close=='}') return true;
        if(open=='[' && close==']') return true;
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            char c=s.charAt(i);
            boolean isOpening= c=='('||c=='{'||c=='[';
            if(isOpening) stack.push(c);
            else
            {
                if(stack.empty()) return false;
                char open=stack.pop();
                if(!match(open, c)) return false;
            }
        }
        return stack.empty();
    }
}