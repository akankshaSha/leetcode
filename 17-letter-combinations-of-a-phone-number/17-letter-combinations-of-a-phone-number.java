class Solution {
    static String[] pad={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        {
            List<String> res=new ArrayList<>();
            return res;
        }
        return letterCombinations2(digits);
    }
    public static List<String> letterCombinations2(String digits) {
        List<String> res=new ArrayList<>();
        
        if(digits.length() == 0)
        {
            res.add("");
            return res;
        }
        
        int digit=digits.charAt(0)-'0';
        String a = pad[digit];
        for(int i=0; i<a.length(); i++)
        {
            List<String> prev=letterCombinations2(digits.substring(1));
            for(String str: prev)
                res.add(a.charAt(i) + str);
        }
        return res;
    }
}