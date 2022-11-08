class Solution {
    public String makeGood(String s) {
        String res = "";
        for(int i =0; i<s.length(); i++)
        {
            if(res.length() == 0) res += s.charAt(i);
            else
            {
                char a = s.charAt(i), b = res.charAt(res.length()-1);
                if(Math.abs(a - b) == 32) res = res.substring(0, res.length()-1);
                else res += a;
            }
        }
        return res;
    }
}