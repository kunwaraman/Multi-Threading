import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {
    private final Lock lock = new ReentrantLock(true); // to make it fair make true
    // aab kitni baar bhi chale le ek ke baad do hi aayega


    public void accessResource(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " acquired the lock,");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "released the lock.");

        }

    }

    public static void main(String[] args){
        UnfairLockExample example = new UnfairLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };
        Thread thread1 = new Thread(task,"Thread1");
        Thread thread2 = new Thread(task,"Thread2");
        Thread thread3 = new Thread(task,"Thread3");

        try {
            thread1.start();
            Thread.sleep(50); // agar bilkul 123 order main chahiye t thread ko sula do
            thread2.start();
            Thread.sleep(50);
            thread3.start();
        }catch (Exception e){
            //e.printStackTrace();
        }
    }
}
