class Solution {
    public int maximum69Number (int num) {
        char n[] = Integer.toString(num).toCharArray();
        int i=0;
        for(; i<n.length; i++) if (n[i] =='6') break;
        if(i<n.length) n[i] = '9';
        return Integer.parseInt(new String (n));
    }
}