this.efficiency=efficiency;
}
}
```
​
2. Sort this array in order of decreasing efficiencies
```
Arrays.sort(engineers, (Engineer a, Engineer b)->Integer.compare(b.efficiency, a.efficiency));
```
​
3. define a priority queue of engineers based on speed. If speed of 2 engineers is the same, the less efficient engineer would be deleted from the queue, else the slower engineer would be deleted
```
PriorityQueue<Engineer> maxHeap=new PriorityQueue<Engineer>((Engineer a, Engineer b)->(a.speed== b.speed)? Integer.compare(a.efficiency, b.efficiency):Integer.compare(a.speed, b.speed));
```
​
4. Iterate through the array and find performance at each iteration.
```
long sumSpeed=0, res=Long.MIN_VALUE;
for(Engineer eng: engineers)
{
if(maxHeap.size()>=k) sumSpeed-=maxHeap.poll().speed;
maxHeap.offer(eng);
sumSpeed+=eng.speed;
res=Math.max(res, sumSpeed*eng.efficiency);
}
```
5. return the answer modulo 10⁹ + 7.
```
return (int) (res%1000000007);
```
​
**Analysis :**
Time Complexity: O(log n + log k)
Auxalary Space: k