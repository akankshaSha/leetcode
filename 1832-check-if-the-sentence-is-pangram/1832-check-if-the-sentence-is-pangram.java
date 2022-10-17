class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean occurance[]=new boolean[26];
        for(int i=0; i<sentence.length(); i++)
        {
            occurance[sentence.charAt(i)-'a']=true;
        }
        for(int i=0; i<occurance.length; i++) if(!occurance[i]) return false;
        return true;
    }
}