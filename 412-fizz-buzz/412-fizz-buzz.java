class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer=new ArrayList<>();
        for(int i=1; i<=n; i++)
        {
            String ans="";
            if(i%3==0) ans+="Fizz";
            if(i%5==0) ans+="Buzz";
            if(i%3!=0 && i%5!=0) ans=Integer.toString(i);
            answer.add(ans);
        }
        return answer;
    }
}