class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0, right=arr.length-1, mid=0;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(arr[mid]>x) right=mid-1;
            else if(arr[mid]<x) left=mid+1;
            else break;
        }
        
        int p=0, q=0;
        if(arr[mid]<=x)
        {
            p=mid;
            q=p+1;
        }
        else
        {
            q=mid;
            p=q-1;
        }
        
        List<Integer> res=new ArrayList<>();
        while(res.size()<k)
        {
            if(p<0)
            {
                res.add(arr[q++]);
            }
            else if(q>=arr.length)
            {
                res.add(0, arr[p--]);
            }
            else if(x-arr[p] < arr[q]-x)
            {
                res.add(0, arr[p--]);
            }
            else if(x-arr[p] > arr[q]-x)
            {
                res.add(arr[q++]);
            }
            else
            {
                res.add(0, arr[p--]);
            }
        }
        return res;
    }
}