class Car
{
    int pos, speed;
    Car(int pos, int speed)
    {
        this.pos=pos;
        this.speed=speed;
    }
    public String toString()
    {
        return ("\U0001f697: pos="+pos+" speed="+speed);
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars =new ArrayList<Car>();
        for(int i=0; i<position.length; i++) cars.add(new Car(position[i], speed[i]));
        Collections.sort(cars, (a, b)->Integer.compare(target-a.pos, target-b.pos));
        Stack<Car> stack=new Stack<>();
        
        for(Car car: cars)
        {
            if(stack.empty())
            {
                stack.push(car);
                continue;
            }
            Car ahead=stack.peek();
            boolean merge= (target-ahead.pos)*1.0/ahead.speed >= (target-car.pos)*1.0/car.speed;
            if(!merge) stack.push(car);
        }
        //System.out.println(cars);
        return stack.size();
    }
}