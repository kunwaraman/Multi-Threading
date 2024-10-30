import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
public class ReentrantExample {
    private final Lock lock = new ReentrantLock();
    public void outerMethod(){
        lock.lock();
        try{
            System.out.println("Outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }
    public void innerMethod(){
        lock.lock();
        try{
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    /*
    ishi ko deadlock kahte hai
    ki main kishsi par depend kar rha hu wo mere pe depend kar rha hai
    outer method depend kar rha hai for inner method to finish
    innermethod wait kar rha hai for outer method to get finished taki lock jo hai wo unlock ho jaye

     */

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();

    }

}
