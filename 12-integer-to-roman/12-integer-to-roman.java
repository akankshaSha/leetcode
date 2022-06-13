class Solution {
    public String intToRoman(int num)
    {
        String R[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int r[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder n=new StringBuilder("");
        
        for(int i=0;i<r.length;i++)
        {
            if(num-r[i]>=0)
            {
                n.append(R[i]);
                num-=r[i--];
            }
            
        }
        return n.toString();
    }
}