public class Counter {
    private int count =0;

//    public synchronized void increment(){
//        count++;
//    }
    // jab ek baar ek thread chala raha ishko increment ko to duhra thread nahi chaleyga ishko

    // ho sakta hia hame pura methods synchronized nahi karna
    // let suppose here multiple chij ho rahi hai aur hmko ek block of code hi
    // synchronized karwani hai means ek baar main ek hi threads access kar paye we use synchronized blocks
    public void increment(){
        synchronized(this){ // hm ek instance ki baat kar rhe hai jispe increment method call ho raha hai agar ushko multiple threads access kar rha hai gaar ushko multiple threads access kar rha hai
            // to ek baar mai ek hi thread access kar payega
            count++;
        }
    }
    public int getCount(){
        return count;
    }

}
