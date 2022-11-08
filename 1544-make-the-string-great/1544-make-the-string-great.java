class Solution {
    public String makeGood(String s) {
        StringBuilder res = new StringBuilder();
        for(int i =0; i<s.length(); i++)
        {
            if(res.length() == 0) res.append(s.charAt(i));
            else
            {
                char a = s.charAt(i), b = res.charAt(res.length()-1);
                if(Math.abs(a - b) == 32) res = res.deleteCharAt(res.length()-1);
                else res.append(a);
            }
        }
        return res.toString();
    }
}