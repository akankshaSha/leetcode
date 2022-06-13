class Solution {
       
    public static String numberToWords(int num) {
        
        if(num==0) return "Zero";
        
       String N[]={"Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen","Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven","Ten", "Nine", "Eight", "Seven", "Six", "Five","Four", "Three", "Two", "One"};
        
        int n[]={1000000000, 1000000, 1000, 100, 90, 80, 70, 60, 50 ,40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        String res="";
        
        for(int i=0; i<4; i++)
        {
            int count=0;
            while(num-n[i]>=0)
            {
                count++;
                num-=n[i];
            }
            if(count>0)
            {
                res+=numberToWords(count)+" "+ N[i]+" ";
            }
        }
        
        for(int i=4; i<n.length; i++)
        {
            while(num-n[i]>=0)
            {
                res+=N[i]+" ";
                num-=n[i];
            }
        }
        return res.trim();
    }
}